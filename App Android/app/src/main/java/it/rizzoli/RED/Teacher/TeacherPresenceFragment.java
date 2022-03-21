package it.rizzoli.RED.Teacher;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherPresenceFragment extends Fragment {

    RecyclerView recyclerView = null;
    Activity activity = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teacher_show_students, container, false);


        AsynkTaskApp app = (AsynkTaskApp) requireActivity().getApplication();
        StudentWebInterface apiService;
        apiService = app.retrofit.create(StudentWebInterface.class);

        Call<List<Student>> call = apiService.showAllStudent();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.code() == 500){
                    Toast.makeText(requireActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    recyclerView = view.findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    List<Student> students = response.body();
                    assert students != null;
                    TeacherShowStudentsAdapter spa = new TeacherShowStudentsAdapter(students);
                    recyclerView.setAdapter(spa);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }
        });



        return view;
    }
}