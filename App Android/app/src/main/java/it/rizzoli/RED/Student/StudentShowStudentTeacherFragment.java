package it.rizzoli.RED.Student;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentShowStudentTeacherFragment extends Fragment {

    RecyclerView recyclerView = null;
    Activity activity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }   

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_show_student_teacher, container, false);

        AsynkTaskApp app = (AsynkTaskApp)getActivity().getApplication();
        StudentWebInterface apiService = app.retrofit.create(StudentWebInterface.class);
        Call<List<Student>> call = apiService.showAllStudent();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.code() == 500){
                    Toast.makeText(getActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    recyclerView = view.findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    List<Student> students = response.body();

                    StudentShowStudentTeacherAdapter spa = new StudentShowStudentTeacherAdapter(students);
                    recyclerView.setAdapter(spa);

                    Toast.makeText(getActivity().getApplicationContext(), students.get(2).getFirst_name(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.e("Fallito! ", t.getMessage());
            }
        });

        return view;
    }
}
