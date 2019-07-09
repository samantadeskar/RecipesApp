package com.example.deskar.recipesapp.pojo;

import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("title")
    private String recipeName;

    @SerializedName("image_url")
    private String recipeImage;

    @SerializedName("social_rank")
    private String socialRank;

    public Recipe() {
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(String socialRank) {
        this.socialRank = socialRank;
    }

}
