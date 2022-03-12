package it.rizzoli.RED.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.rizzoli.RED.R;

public class StudentCalendarFragment extends Fragment {
    private final static String MY_PREFERENCES = "MyPref";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_student_calendar, container, false);


        return view;
    }
}
