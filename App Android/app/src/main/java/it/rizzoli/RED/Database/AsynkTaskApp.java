package it.rizzoli.RED.Database;

import android.app.Application;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsynkTaskApp extends Application {

    public static final String BASE_URL = "http://192.168.0.113:9090/";
    public Retrofit retrofit = null;

    public AsynkTaskApp(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /*
    private Retrofit retrofit = null;

    public AsynkTaskApp(){
        OkHttpClient okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }
    public Retrofit getRetrofit() {
        return this.retrofit;
    }

     */
}
