package it.rizzoli.RED.Docente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import it.rizzoli.RED.R;


public class HomepageDocenteFragment extends Fragment {
    Button bvd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage_docente, container, false);

        bvd = view.findViewById(R.id.buttonVotiDocente);
        bvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, VoteDocenteFragment.class, null).commit();
            }
        });

        return view;
    }
}