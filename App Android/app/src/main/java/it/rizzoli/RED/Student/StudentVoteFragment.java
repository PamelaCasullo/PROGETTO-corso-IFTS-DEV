package it.rizzoli.RED.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.rizzoli.RED.R;

public class StudentVoteFragment extends Fragment {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<StudentCourseModal> studentCourseModalArrayList;
    private StudentDBHandler studentDBHandler;
    private StudentCourseRVAdapter studentCourseRVAdapter;
    private RecyclerView coursesRV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_vote, container, false);


        // initializing our all variables.
        studentCourseModalArrayList = new ArrayList<>();
        studentDBHandler = new StudentDBHandler(getActivity());

        // getting our course array
        // list from db handler class.
        studentCourseModalArrayList = studentDBHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        studentCourseRVAdapter = new StudentCourseRVAdapter(studentCourseModalArrayList, getActivity());
        coursesRV = view.findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(studentCourseRVAdapter);

        return view;
    }
}
