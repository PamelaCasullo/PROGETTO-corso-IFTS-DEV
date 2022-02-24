package it.rizzoli.RED;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


public class AbsenceDocenteFragment extends Fragment {
    ListView lp = null;
    ListViewAbsenceAdapter lvpa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presence_docente, container, false);

        // CODICE PER L'ANIMAZIONE DI BACKGROUNG
        DrawerLayout drawerLayout = view.findViewById(R.id.my_drawer_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) drawerLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        // CODICE PER LA VISUALIZZAZIONE DELLA LISTVIEW
        lp = view.findViewById(R.id.listaPresence);
        Absence[] absence = new Absence[] {
                new Absence("08/02/2022", "Traore Adama Emmanuel", "P", "/", "/"),
                new Absence("18/01/2022", "Pamela Casullo Maura", "P", "/", "/"),
                new Absence("11/12/2021", "Lorenzo Passoni", "/", "A", "/"),
                new Absence("22/11/2021", "Dorjan Curtis", "P", "/", "/"),
                new Absence("04/11/2021", "Pablo Escobar", "/", "/", "R: 20min"),
                new Absence("17/10/2021", "Luciano Pelato", "/", "/", "R: 2ore")
        };

        lvpa = new ListViewAbsenceAdapter(getActivity(), R.layout.colonne_absence, absence);
        lp.setAdapter(lvpa);

        lp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Absence p = lvpa.getItem(pos);
                Toast.makeText(getActivity(), p.data + " " + p.nome_cognome + " " + p.presente + " " + p.ritardo + " " + p.assente, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}