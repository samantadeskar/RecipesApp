package com.example.deskar.recipesapp.ui;

import com.example.deskar.recipesapp.pojo.Recipe;

import java.util.List;

public interface RecipesView {


    void addRecipes(List<Recipe> recipeList);

    void nullListMessage();

    void unsuccessfulResponseMessage();

    void failureMessage();
}
