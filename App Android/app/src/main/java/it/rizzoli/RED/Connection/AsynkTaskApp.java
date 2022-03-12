package it.rizzoli.RED.Connection;

import android.app.Application;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsynkTaskApp extends Application {

    public static final String BASE_URL = "http://192.168.178.23:9090/"; //TODO Cambiare sempre nell'indirizzo IP della propria macchina, altrimenti non funziona
    public Retrofit retrofit;

    public AsynkTaskApp(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
