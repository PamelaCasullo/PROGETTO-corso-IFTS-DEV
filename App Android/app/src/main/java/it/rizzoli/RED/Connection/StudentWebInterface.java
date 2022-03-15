package it.rizzoli.RED.Connection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentWebInterface {

    @POST("/Students/login")
    Call<Student> login(@Body Credential credential);

    @PUT("/Students/search/{id_student}")
    Call<Student> searchById(@Path("id_student") long id);

    @PUT("/Students/update")
    Call<Student> updateElementById(@Body UpdateProfile updateProfile);

}
