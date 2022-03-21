package it.rizzoli.RED.Connection;

import java.util.List;

import it.rizzoli.RED.Student.RecyclerViewLessonStudent;
import it.rizzoli.RED.Student.RecyclerViewPresenceStudent;
import it.rizzoli.RED.Student.RecyclerViewVoteStudent;
import it.rizzoli.RED.Student.StudentUpdateProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
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
    Call<List<RecyclerViewPresenceStudent>> showPresence(@Header("id_student") int id_student);

    @GET("/Students/show/ElencoVoti")
    Call<List<RecyclerViewVoteStudent>> showVote(@Header("id_student") int id_student);

    @GET("/Students/showAll")
    Call<List<Student>> showAllStudent();

    @GET("/Students/show/ElencoLezioni")
    Call<List<RecyclerViewLessonStudent>> showAllLesson(@Header("id_student") int id_student);
}
