package com.tony.smit.core.entities

import java.util.*

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class User(val id: Long,
                val name: String,
                val surName: String,
                val email: String,
                val birthDate: Date,
                val sex: Int,
                val city: String,
                val country: String,
                val avatarUrl: String) {
}