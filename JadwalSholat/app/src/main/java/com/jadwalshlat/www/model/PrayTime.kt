package com.jadwalshlat.www.model

data class PrayTime(
    val data: Data,
    val debug: Debug,
    val location: Location,
    val status: String,
    val time: Time
) {
    data class Debug(
        val sunrise: String,
        val sunset: String
    )

    data class Location(
        val latitude: String,
        val longitude: String
    )

    data class Time(
        val date: String,
        val offset: Int,
        val time: String,
        val timezone: String
    )

    data class Data(
        val Asr: String,
        val Dhuhr: String,
        val DuapertigaMalam: String,
        val Fajr: String,
        val Isha: String,
        val Maghrib: String,
        val SepertigaMalam: String,
        val Sunrise: String,
        val Sunset: String,
        val TengahMalam: String,
        val method: List<String>
    )
}