package com.example.deskar.recipesapp.response;

import com.example.deskar.recipesapp.pojo.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("recipes")
    private List<Recipe> recipeList;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

}
