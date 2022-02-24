package it.rizzoli.RED;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


public class HomepageDocenteFragment extends Fragment {
    ListView lv;
    ListViewVotoDocenteAdapter lvvad;
    Button bvd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage_docente, container, false);

        // CODICE PER L'ANIMAZIONE DI BACKGROUNG
        DrawerLayout drawerLayout = view.findViewById(R.id.my_drawer_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) drawerLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        // CODICE PER LA VISUALIZZAZIONE DELLA LISTVIEW
        lv = view.findViewById(R.id.listaVotiDocente);
        VoteDocente[] vote = new VoteDocente[]{
                new VoteDocente("08/02/2022", "Traore Adama Emmanuel", "Applicationi Mobile Android", 25),
                new VoteDocente("18/01/2022", "Pamela Casullo Maura", "Applicationi Mobile Android", 30),
                new VoteDocente("11/12/2021", "Lorenzo Passoni", "Applicationi Mobile Android", 28),
                new VoteDocente("22/11/2021", "Dorjan Curtis", "Applicationi Mobile Android", 26),
                new VoteDocente("04/11/2021", "Pablo Escobar", "Applicationi Mobile Android", 23),
                new VoteDocente("17/10/2021", "Luciano Pelato", "Applicationi Mobile Android", 21)
        };

        lvvad = new ListViewVotoDocenteAdapter(getActivity(), R.layout.activity_colonne_voti_docente, vote);
        lv.setAdapter(lvvad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                VoteDocente v = lvvad.getItem(pos);
                Toast.makeText(getActivity(), v.data + " " + v.nome_cognome + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });

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