package com.example.deskar.recipesapp.interactors;

import com.example.deskar.recipesapp.response.RecipeResponse;

import retrofit2.Callback;

public interface RecipeInteractor {

    void getRecipes(Callback<RecipeResponse> recipeResponseCallback);

}
