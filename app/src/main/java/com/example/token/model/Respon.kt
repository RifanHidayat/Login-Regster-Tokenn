package com.example.token.model

import com.google.gson.annotations.SerializedName

data class Respon
    (
     val statusCode: String,
     val message:String,
     val username:String,
     val email:String,
     val password:String

    )
