package com.example.apicompose_put

import retrofit2.Call
import retrofit2.http.*

interface RetrofitAPI {

    @POST("produk")
    fun // on below line we are creating a method to post our data.
            postData(@Body dataModel: DataModel?): Call<DataModel?>?

    @PUT("produk/{id}")
    // in the below line, we are creating a method to put our data.
    fun updateData(@Path("id") id: String, @Body dataModel: DataModel?): Call<DataModel?>?

    @DELETE("produk/{id}")
    // in the below line, we are creating a method to put our data.
    fun deleteData(@Path("id") id: String): Call<DataModel?>?

}