package com.example.ppapb_p11_api.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_name")
    val employeeName: String,

    @SerializedName("email")
    val employeeSalary: String,

    @SerializedName("last_name")
    val employeeAge: String,

    @SerializedName("avatar")
    val profileImage: String
)