package it.rizzoli.RED.Connection;

import java.util.List;

import it.rizzoli.RED.Student.Presence;
import it.rizzoli.RED.Student.StudentUpdateProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentWebInterface {

    @POST("/Students/login")
    Call<Student> login(@Body Credential credential);

    @PUT("/Students/search/{id_student}")
    Call<Student> searchById(@Path("id_student") long id);

    @PUT("/Students/update")
    Call<Student> updateElementById(@Body StudentUpdateProfile studentUpdateProfile);

    @GET("/Students/show/ElencoPresenze")
    Call<List<Presence>> showPreferences(@Header("id_student") int id_student);

}
