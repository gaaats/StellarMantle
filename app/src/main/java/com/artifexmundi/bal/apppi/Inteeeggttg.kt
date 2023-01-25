package com.artifexmundi.bal.apppi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getDataaaaaa(): Response<CountryCodeJSOIJJIJ>
}



class CountryRepo(private val hyjuuujujuj: ApiInterface) {
    suspend fun getDathyhyhy() = hyjuuujujuj.getDataaaaaa()
}
class DevRepo(private val hyhyhyhy: HostInterface) {
    suspend fun hyyhhyyhhy() = hyhyhyhy.getDataDevvvvv()
}

@Keep
data class CountryCodeJSOIJJIJ(
    @SerializedName("countryCode")
    val hyjuujujuj: String,
)

interface HostInterface {
    @GET("typo.json")
    suspend fun getDataDevvvvv(): Response<GeoDev>
}


@Keep
data class GeoDev(
    @SerializedName("geo")
    val jukiik: String,
    @SerializedName("view")
    val hujjiujuj: String,
    @SerializedName("appsChecker")
    val hujukiikoloolol: String,
)