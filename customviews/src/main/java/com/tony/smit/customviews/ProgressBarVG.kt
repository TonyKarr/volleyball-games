package com.tony.smit.customviews

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-02.
 *
 */
class ProgressBarVG(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private lateinit var backgroundPaint: Paint
    private lateinit var blackPaint: Paint

    private var alphaAnimation = false

    private lateinit var animationRotate: ValueAnimator
    private lateinit var animationAlpha: ValueAnimator

    private val colorFirst = resources.getColor(R.color.primaryColor, null)
    private val colorSecond = resources.getColor(R.color.primaryColorAlpha, null)
    private val colorThird = resources.getColor(R.color.primaryLightColorAlpha, null)

    private val shaderColors = intArrayOf(
        colorFirst, colorSecond, colorThird
    )

    private val size = resources.displayMetrics.density * 48

    private val pathContureBall = Path()

    private val porterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)


    private val point1 = Point()
    private val point2 = Point()
    private val point3 = Point()
    private val point4 = Point()
    private val point5 = Point()
    private val point6 = Point()

    private val matrix120 = Matrix()

    private var firstLineCoefficient = Triple(
        Pair(0.033f, 0.4f),
        Pair(0.525f, 0.525f),
        Pair(0.475f, 0.475f)
    )
    private var secondLineCoefficient = Triple(
        Pair(0f, 0.55f),
        Pair(0.68f, 0.67f),
        Pair(0.65f, 0.64f)
    )
    private var thirdLineCoefficient = Triple(
        Pair(0.066f, 0.75f),
        Pair(0.67f, 0.86f),
        Pair(0.67f, 0.84f)
    )

    private var point1Coifs = Pair(0.26f, 0.68f)
    private var point2Coifs = Pair(0.26f, 0.63f)
    private var point3Coifs = Pair(0.28f, 0.9f)
    private var point4Coifs = Pair(0.28f, 0.88f)
    private var point5Coifs = Pair(0.35f, 1.01f)
    private var point6Coifs = Pair(0.35f, 1f)

    private val rec = RectF().apply {
        right = size
        bottom = size
    }

    private var rotate: Float = 0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        initPaints()
        initAnimation()
        getAttrs(attrs)
        matrix120.setRotate(120f, rec.centerX(), rec.centerY())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startAnimation()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(size.toInt(), size.toInt())
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        setPointCoordinate(point1, point1Coifs, rec)
        setPointCoordinate(point2, point2Coifs, rec)
        setPointCoordinate(point3, point3Coifs, rec)
        setPointCoordinate(point4, point4Coifs, rec)
        setPointCoordinate(point5, point5Coifs, rec)
        setPointCoordinate(point6, point6Coifs, rec)
        setVolleyCornerLine(pathContureBall, rec, point1, point2, firstLineCoefficient)
        setVolleyCornerLine(pathContureBall, rec, point3, point4, secondLineCoefficient)
        setVolleyCornerLine(pathContureBall, rec, point5, point6, thirdLineCoefficient)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            rotate(rotate, rec.centerX(), rec.centerY())
            drawPath(pathContureBall, blackPaint)
            pathContureBall.transform(matrix120)
            drawPath(pathContureBall, blackPaint)
            pathContureBall.transform(matrix120)
            drawPath(pathContureBall, blackPaint)
            drawCircle(rec.centerX(), rec.centerY(), rec.centerY(), backgroundPaint)
        }
    }

    private fun startAnimation() {
        animationRotate.start()
        if (alphaAnimation)
            animationAlpha.start()
    }

    private fun initPaints() {
        backgroundPaint = Paint().apply {
            xfermode = porterDuffXfermode
            style = Paint.Style.FILL
            isAntiAlias = true
            shader = RadialGradient(
                rec.centerX(),
                rec.centerY(),
                rec.centerX(),
                shaderColors,
                floatArrayOf(0f, .8f, 1f),
                Shader.TileMode.CLAMP
            )
        }

        blackPaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 3f
            isAntiAlias = true
            style = Paint.Style.FILL
        }
    }

    private fun initAnimation() {
        animationRotate = ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            addUpdateListener {
                rotate = it.animatedValue as Float
                invalidate()
            }

            repeatCount = ValueAnimator.INFINITE
        }
        val propertyAlphaName = "alpha"
        val propertyAlpha = PropertyValuesHolder.ofFloat(propertyAlphaName, 0.2f, 1f)
        animationAlpha = ValueAnimator.ofPropertyValuesHolder(propertyAlpha).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            addUpdateListener {
                this@ProgressBarVG.alpha = it.getAnimatedValue(propertyAlphaName) as Float
                invalidate()
            }
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }
    }

    private fun getAttrs(attrs: AttributeSet){
        val attr: TypedArray = context.theme.obtainStyledAttributes(attrs,R.styleable.ProgressBarVG, 0, 0)
        alphaAnimation = attr.getBoolean(R.styleable.ProgressBarVG_alpha_animation, false)
        attr.recycle()
    }

    private fun setPointCoordinate(point: Point, pair: Pair<Float, Float>, rec: RectF) = point.let {
        it.x = (pair.first * rec.width()).toInt()
        it.y = (pair.second * rec.height()).toInt()
    }

    private fun setVolleyCornerLine(
        path: Path,
        rec: RectF,
        pointBottom: Point,
        pointTop: Point,
        listCoef: Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>
    ) = path.let {
        it.moveTo(listCoef.first.first * rec.width(), listCoef.first.second * rec.height())
        it.quadTo(
            pointBottom.x.toFloat(),
            pointBottom.y.toFloat(),
            listCoef.second.first * rec.width(),
            listCoef.second.second * rec.height()
        )
        it.lineTo(listCoef.third.first * rec.width(), listCoef.third.second * rec.height())
        it.quadTo(
            pointTop.x.toFloat(),
            pointTop.y.toFloat(),
            listCoef.first.first * rec.width(),
            listCoef.first.second * rec.height()
        )
    }
}