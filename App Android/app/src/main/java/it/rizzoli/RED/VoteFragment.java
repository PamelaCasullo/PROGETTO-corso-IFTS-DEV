package it.rizzoli.RED;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VoteFragment extends Fragment {
    ListView lv;
    ListViewVotoAdapter lvva;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vote, container, false);

        lv = view.findViewById(R.id.listaVoti);
        Vote[] vote = new Vote[] {
                new Vote("08/02/2022", "Applicationi Mobile Android", 18),
                new Vote("18/01/2022", "Tecnologie Web per la UI ed il Back-End", 30),
                new Vote("11/12/2021", "Gestione di dati e DataBase", 28),
                new Vote("22/11/2021", "Realizzazione di applicazioni Java", 26),
                new Vote("04/11/2021", "Processo di sviluppo del software", 23),
                new Vote("17/10/2021", "Architetture e Sistemi", 21)
        };

        lvva = new ListViewVotoAdapter(getActivity(), R.layout.activity_colonne_voti, vote);
        lv.setAdapter(lvva);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Vote v = lvva.getItem(pos);
                Toast.makeText(getActivity(), v.data + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
