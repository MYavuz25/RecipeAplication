package com.example.recipeapplication

import retrofit2.http.Url
data class Recipe_model(val Name:String,
                 val url: String,
                 val Description:String,
                 val Author:String,
                 val Ingredients:List<String>)