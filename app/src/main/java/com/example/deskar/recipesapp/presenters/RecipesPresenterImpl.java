package com.example.deskar.recipesapp.presenters;

import com.example.deskar.recipesapp.interactors.RecipeInteractor;
import com.example.deskar.recipesapp.networking.BackendFactory;
import com.example.deskar.recipesapp.response.RecipeResponse;
import com.example.deskar.recipesapp.ui.RecipesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesPresenterImpl implements RecipesPresenter {

    RecipesView view;
    RecipeInteractor recipeInteractor = BackendFactory.getRecipeInteractor();

    @Override
    public void setBaseView(RecipesView view) {
        this.view = view;
    }

    @Override
    public void getRecipes() {

        recipeInteractor.getRecipes(getRecipesCallback());
    }

    private Callback<RecipeResponse> getRecipesCallback() {
        return new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getRecipeList() != null) {
                        view.addRecipes(response.body().getRecipeList());
                    } else {
                        view.nullListMessage();
                    }
                } else {
                    view.unsuccessfulResponseMessage();
                }

            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                view.failureMessage();
            }
        };
    }
}
