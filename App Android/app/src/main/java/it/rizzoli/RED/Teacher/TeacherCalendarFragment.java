package it.rizzoli.RED.Teacher;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.TeacherWebInterface;
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherCalendarFragment extends Fragment {

    RecyclerView recyclerView = null;
    Activity activity = null;
    int textId = 0;
    private final static String MY_PREFERENCES = "MyPref";
    private final static String TEXT_ID_KEY = "textId";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_calendar, container, false);

        SharedPreferences preferiti = requireActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp) requireActivity().getApplication();
        TeacherWebInterface apiService = app.retrofit.create(TeacherWebInterface.class);
        Call<List<RecyclerViewShowLessonTeacher>> call = apiService.showLessonTeacher(textId);

        call.enqueue(new Callback<List<RecyclerViewShowLessonTeacher>>() {
            @Override
            public void onResponse(@NonNull Call<List<RecyclerViewShowLessonTeacher>> call, @NonNull Response<List<RecyclerViewShowLessonTeacher>> response) {
                if(response.code() == 500){
                    Toast.makeText(requireActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    recyclerView = view.findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity));

                    List<RecyclerViewShowLessonTeacher> lessons = response.body();

                    TeacherLessonAdapter tla = new TeacherLessonAdapter(lessons);
                    recyclerView.setAdapter(tla);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RecyclerViewShowLessonTeacher>> call, @NonNull Throwable t) {

            }
        });

        return view;
    }
}