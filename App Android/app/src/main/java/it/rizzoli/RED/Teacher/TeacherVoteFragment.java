package it.rizzoli.RED.Teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.rizzoli.RED.R;


public class TeacherVoteFragment extends Fragment {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<TeacherCourseModal> teacherCourseModalArrayList;
    private TeacherDBHandler teacherDBHandler;
    private TeacherCourseRVAdapter teacherCourseRVAdapter;
    private RecyclerView coursesRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_vote, container, false);

        // initializing our all variables.
        teacherCourseModalArrayList = new ArrayList<>();
        teacherDBHandler = new TeacherDBHandler(getActivity());

        // getting our course array
        // list from db handler class.
        teacherCourseModalArrayList = teacherDBHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        teacherCourseRVAdapter = new TeacherCourseRVAdapter(teacherCourseModalArrayList, getActivity());
        coursesRV = view.findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(teacherCourseRVAdapter);

        return view;
    }
}