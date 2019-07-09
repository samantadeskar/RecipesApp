package com.example.deskar.recipesapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.deskar.recipesapp.R;
import com.example.deskar.recipesapp.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private List<Recipe> recipeList;

    public RecipeAdapter() {
        recipeList = new ArrayList<>();
    }

    public RecipeAdapter(List<Recipe> recipes) {
        this.recipeList = recipes;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);
        holder.setData(recipe);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView_Recipe)
        ImageView imageView_Recipe;
        @BindView(R.id.textView_RecipeName)
        TextView textView_RecipeName;
        @BindView(R.id.textView_SocialRank)
        TextView textView_SocialRank;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Recipe recipe) {

            textView_RecipeName.setText(recipe.getRecipeName());
            textView_SocialRank.setText("Social Rank: " + recipe.getSocialRank());
            Glide.with(itemView)
                    .load(recipe.getRecipeImage())
                    .apply(RequestOptions.placeholderOf(R.drawable.noimage))
                    .into(imageView_Recipe);

        }
    }
}
