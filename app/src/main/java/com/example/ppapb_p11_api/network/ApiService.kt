package com.example.ppapb_p11_api.network

import com.example.ppapb_p11_api.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getAllUsers(): Call<Users>
}