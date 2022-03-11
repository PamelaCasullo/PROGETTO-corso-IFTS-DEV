package it.rizzoli.RED.Connection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StudentWebInterface {

    @POST("/Students/login")
    Call<Student> login(@Body Credential credential);
}
