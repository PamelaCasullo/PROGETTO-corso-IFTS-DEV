package it.rizzoli.RED.Connection;

import java.util.List;

import it.rizzoli.RED.Teacher.TeacherShowGrades;
import it.rizzoli.RED.Teacher.RecyclerViewShowLessonTeacher;
import it.rizzoli.RED.Teacher.TeacherUpdateProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
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

    @GET("/Teacher/showAll")
    Call<List<Teacher>> showAllTeachers();

    @GET("/Teachers/show/ElencoLezioni")
    Call<List<RecyclerViewShowLessonTeacher>> showLessonTeacher(@Header("id_teacher") int id_teacher);

    @GET("/Teachers/show/ElencoVoti")
    Call<List<TeacherShowGrades>> showGradeTeacher(@Header("id_teacher") int id_teacher);

}
