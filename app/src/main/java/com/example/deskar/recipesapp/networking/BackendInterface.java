package com.example.deskar.recipesapp.networking;

import com.example.deskar.recipesapp.response.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BackendInterface {

    @GET("?key=2ec03547f9f9b18368c34fac5579f848")
    Call<RecipeResponse> getAllPost();

}
