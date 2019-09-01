package com.tony.smit.core.entities

import java.util.*

data class User(val name: String,
                val surName: String,
                val email: String,
                val birthDate: Date,
                val sex: String,
                val city: String,
                val country: String,
                val avatarUrl: String) {
}