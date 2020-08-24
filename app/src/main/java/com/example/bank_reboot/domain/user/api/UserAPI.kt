package com.example.bank_reboot.domain.user.api

import com.example.bank_reboot.domain.user.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {
    @GET("user/{id}")
    fun getUserByID(@Path("id") id : Int): Call<User>
}