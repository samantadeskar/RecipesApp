package com.example.deskar.recipesapp.networking;

import com.example.deskar.recipesapp.constants.Constants;
import com.example.deskar.recipesapp.interactors.RecipeInteractor;
import com.example.deskar.recipesapp.interactors.RecipeInteractorImpl;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendFactory {

    private static Retrofit retrofit = null;

    private static Interceptor getInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build();
    }


    private static Retrofit createRetrofit() {

        retrofit = new Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            createRetrofit();
        }
        return
                retrofit;
    }


    private static BackendInterface getService() {
        return
                getClient().create(BackendInterface.class);
    }

    public static RecipeInteractor getRecipeInteractor() {
        return new RecipeInteractorImpl(
                getService());
    }

}
