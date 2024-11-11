package com.example.ppapb_p11_api.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppapb_p11_api.model.Data
import com.example.ppapb_p11_api.model.Users
import com.example.ppapb_p11_api.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>> get() = _data

    private var page1Loaded = false
    private var page2Loaded = false

    fun loadPage1() {
        if (!page1Loaded) {
            ApiClient.getInstance().getAllUsers(1).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            _data.value = it
                            page1Loaded = true
                        }
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }

    fun loadPage1And2() {
        if (page1Loaded && !page2Loaded) {
            ApiClient.getInstance().getAllUsers(2).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            _data.value = _data.value?.plus(it)
                            page2Loaded = true
                        }
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }
}
