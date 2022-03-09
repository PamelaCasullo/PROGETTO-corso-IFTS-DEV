package it.rizzoli.RED.Database;

import it.rizzoli.RED.Studenti.Credenziali;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface WebInterface {

    @POST("/Students/login")
    Call<Student> login(@Body Credenziali credential);
}
