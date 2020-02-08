package com.tony.smit.volleyballgames;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * This code is created by Kovaliov Anton on 2020-01-26.
 */
public class Test {

    Object o = new Object();
    ReferenceQueue<Object> referenceQueue =
            new ReferenceQueue<>();
    PhantomReference<Object> phantomReference =
            new PhantomReference<Object>(o,referenceQueue);

}
