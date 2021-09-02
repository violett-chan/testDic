package api.common

import api.retrofit.RetrofitClient
import api.DictonaryApi

object Common {
    private val BASE_URL = "https://dictionary.skyeng.ru"
    val dictonaryApi: DictonaryApi
        get() = RetrofitClient.getClient(BASE_URL).create(DictonaryApi::class.java)
}