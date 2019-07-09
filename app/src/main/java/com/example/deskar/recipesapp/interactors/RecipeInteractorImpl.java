package com.example.deskar.recipesapp.interactors;

import com.example.deskar.recipesapp.networking.BackendInterface;
import com.example.deskar.recipesapp.response.RecipeResponse;

import retrofit2.Callback;

public class RecipeInteractorImpl implements RecipeInteractor {

    private final BackendInterface backendInterface;

    public RecipeInteractorImpl(BackendInterface backendInterface) {
        this.backendInterface = backendInterface;
    }

    @Override
    public void getRecipes(Callback<RecipeResponse> recipeResponseCallback) {
        backendInterface.getAllPost().enqueue(recipeResponseCallback);
    }

}
