package com.example.recipeapplication

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("MYavuz25/service/main/recipes.json")
    //@GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    suspend fun getData():Response<List<Recipe_model>>


}