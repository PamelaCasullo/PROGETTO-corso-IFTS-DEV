package it.rizzoli.RED.Connection;

import it.rizzoli.RED.Student.StudentUpdateProfile;
import it.rizzoli.RED.Teacher.TeacherUpdateProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TeacherWebInterface {

    @POST("/Teachers/login")
    Call<Teacher> login(@Body Credential credential);

    @PUT("/Teachers/search/{id_teacher}")
    Call<Teacher> searchById(@Path("id_teacher") long id);

    @PUT("/Teachers/update")
    Call<Teacher> updateElementById(@Body TeacherUpdateProfile teacherUpdateProfile);
}
