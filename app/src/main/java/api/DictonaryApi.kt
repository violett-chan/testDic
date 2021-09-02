package api

import api.models.Word
import retrofit2.Call
import retrofit2.http.*


interface DictonaryApi{
    @GET("/api/public/v1/words/search")
    fun search(@Query("search") search: String): Call<List<Word>>
}