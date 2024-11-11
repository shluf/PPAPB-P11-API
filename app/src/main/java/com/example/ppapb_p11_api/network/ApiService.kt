package com.example.ppapb_p11_api.network

import com.example.ppapb_p11_api.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getAllUsers(@Query("page") page: Int): Call<Users>
}
