package com.example.recyclerviewlearn.model

import java.io.Serializable

data class User(var profile: Int = 0, var fullName: String = "", var isOnline: Boolean = false): Serializable