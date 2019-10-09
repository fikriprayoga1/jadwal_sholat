package com.jadwalshlat.www.jetpackcontroller

import com.jadwalshlat.www.model.PrayTime
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Webservice {
    @Headers("Content-Type: application/json")
    @GET("pray")
    fun getRoom(
        @Query("lat") lat: String,
        @Query("lng") lng: String
    ): Call<PrayTime>

    companion object Factory {
        fun create(url: String): Webservice {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Webservice::class.java)
        }
    }

}
