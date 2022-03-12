package it.rizzoli.RED.Teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import it.rizzoli.RED.R;


public class TeacherSetVoteFragment extends Fragment {
    // creating variables for our edittext, button and dbhandler
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn;
    private TeacherDBHandler teacherDBHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher_set_vote, container, false);

        // initializing all our variables.
        courseNameEdt = view.findViewById(R.id.idEdtCourseName);
        courseTracksEdt = view.findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = view.findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = view.findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = view.findViewById(R.id.idBtnAddCourse);
        readCourseBtn = view.findViewById(R.id.idBtnReadCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        teacherDBHandler = new TeacherDBHandler(getContext());

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(v -> {

            // below line is to get data from all edit text fields.
            String courseName = courseNameEdt.getText().toString();
            String courseTracks = courseTracksEdt.getText().toString();
            String courseDuration = courseDurationEdt.getText().toString();
            String courseDescription = courseDescriptionEdt.getText().toString();

            // validating if the text fields are empty or not.
            if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                Toast.makeText(getActivity(), "Per favore, inserire tutti i dati", Toast.LENGTH_SHORT).show();
                return;
            }

            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            teacherDBHandler.addNewCourse(courseName, courseDuration, courseDescription, courseTracks);

            // after adding the data we are displaying a toast message.
            Toast.makeText(getActivity(), "Voto aggiunto con successo", Toast.LENGTH_SHORT).show();
            courseNameEdt.setText("");
            courseDurationEdt.setText("");
            courseTracksEdt.setText("");
            courseDescriptionEdt.setText("");
        });

        readCourseBtn.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, TeacherVoteFragment.class, null).commit());

        return view;
    }
}