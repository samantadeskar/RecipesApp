package com.example.deskar.recipesapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.deskar.recipesapp.R;
import com.example.deskar.recipesapp.pojo.Recipe;
import com.example.deskar.recipesapp.presenters.RecipesPresenter;
import com.example.deskar.recipesapp.presenters.RecipesPresenterImpl;
import com.example.deskar.recipesapp.ui.adapter.RecipeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity implements RecipesView {

    @BindView(R.id.recycler_Recipes)
    RecyclerView recyclerView_Recipes;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textView_Loading)
    TextView textView_Loading;
    @BindView(R.id.textView_CantLoad)
    TextView textView_CantLoad;

    RecipesPresenter presenter = new RecipesPresenterImpl();

    RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);
        presenter.setBaseView(this);
        presenter.getRecipes();

        recipeAdapter = new RecipeAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_Recipes.setLayoutManager(linearLayoutManager);
        recyclerView_Recipes.setItemAnimator(new DefaultItemAnimator());
        recyclerView_Recipes.setAdapter(recipeAdapter);
    }

    @Override
    public void addRecipes(List<Recipe> recipeList) {


        recipeAdapter= new RecipeAdapter(recipeList);
        recyclerView_Recipes.setAdapter(recipeAdapter);
        progressBar.setVisibility(View.GONE);
        textView_Loading.setVisibility(View.GONE);
        recyclerView_Recipes.setVisibility(View.VISIBLE);

    }

    @Override
    public void nullListMessage() {
        progressBar.setVisibility(View.GONE);
        textView_Loading.setVisibility(View.GONE);
        textView_CantLoad.setText(R.string.listEmpty);
        textView_CantLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void unsuccessfulResponseMessage() {
        progressBar.setVisibility(View.GONE);
        textView_Loading.setVisibility(View.GONE);
        textView_CantLoad.setText(R.string.tryAgain);
        textView_CantLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void failureMessage() {
        progressBar.setVisibility(View.GONE);
        textView_Loading.setVisibility(View.GONE);
        textView_CantLoad.setText(R.string.internetConnection);
        textView_CantLoad.setVisibility(View.VISIBLE);

    }
}
