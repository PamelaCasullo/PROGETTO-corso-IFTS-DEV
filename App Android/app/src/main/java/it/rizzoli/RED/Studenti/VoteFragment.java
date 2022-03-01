package it.rizzoli.RED.Studenti;

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

public class VoteFragment extends Fragment {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandlerStudente dbHandlerStudente;
    private CourseRVStudenteAdapter courseRVStudenteAdapter;
    private RecyclerView coursesRV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vote, container, false);


        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandlerStudente = new DBHandlerStudente(getActivity());

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandlerStudente.readCourses();

        // on below line passing our array lost to our adapter class.
        courseRVStudenteAdapter = new CourseRVStudenteAdapter(courseModalArrayList, getActivity());
        coursesRV = view.findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVStudenteAdapter);

        return view;
    }
}
