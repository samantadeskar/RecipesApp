package com.example.deskar.recipesapp.presenters;

import com.example.deskar.recipesapp.ui.RecipesView;

public interface RecipesPresenter {

    void setBaseView(RecipesView view);

    void getRecipes();

}
