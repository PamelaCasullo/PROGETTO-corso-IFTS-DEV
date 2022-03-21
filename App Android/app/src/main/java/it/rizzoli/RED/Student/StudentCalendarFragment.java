package it.rizzoli.RED.Student;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentCalendarFragment extends Fragment {

    RecyclerView recyclerViewLesson = null;
    Activity activity = null;
    int textId = 0;
    private final static String MY_PREFERENCES = "MyPref";
    private final static String TEXT_ID_KEY = "textId";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_calendar, container, false);

        SharedPreferences preferiti = getActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp)getActivity().getApplication();
        StudentWebInterface apiService = app.retrofit.create(StudentWebInterface.class);
        Call<List<RecyclerViewLessonStudent>> call = apiService.showAllLesson(textId);

        call.enqueue(new Callback<List<RecyclerViewLessonStudent>>() {
            @Override
            public void onResponse(@NonNull Call<List<RecyclerViewLessonStudent>> call, @NonNull Response<List<RecyclerViewLessonStudent>> response) {
                if(response.code() == 500) {
                    Toast.makeText(getActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    recyclerViewLesson = view.findViewById(R.id.recyclerView);
                    recyclerViewLesson.setLayoutManager(new LinearLayoutManager(activity));
                    List<RecyclerViewLessonStudent> lessons = response.body();

                    StudentCalendarAdapter spa = new StudentCalendarAdapter(lessons);
                    recyclerViewLesson.setAdapter(spa);

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RecyclerViewLessonStudent>> call, @NonNull Throwable t) {

            }
        });

        return view;
    }
}
