package it.rizzoli.RED.Teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import it.rizzoli.RED.R;


public class TeacherHomepageFragment extends Fragment {
    Button bvd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_homepage, container, false);

        bvd = view.findViewById(R.id.buttonVotiDocente);
        bvd.setOnClickListener(view1 -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, TeacherVoteFragment.class, null).commit());

        return view;
    }
}