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

public class PresenceFragment extends Fragment {
    ListView lp = null;
    ListViewPresenceAdapter lvpa;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presence, container, false);

        lp = view.findViewById(R.id.listaPresence);
        Presence[] presence = new Presence[] {
                new Presence("08/02/2022", "Traore Adama Emmanuel", "P", "/", "/"),
                new Presence("18/01/2022", "Pamela Casullo Maura", "P", "/", "/"),
                new Presence("11/12/2021", "Lorenzo Passoni", "/", "A", "/"),
                new Presence("22/11/2021", "Dorjan Curtis", "P", "/", "/"),
                new Presence("04/11/2021", "Pablo Escobar", "/", "/", "R: 20min"),
                new Presence("17/10/2021", "Luciano Pelato", "/", "/", "R: 2ore")
        };

        lvpa = new ListViewPresenceAdapter(getActivity(), R.layout.colonne_presence, presence);
        lp.setAdapter(lvpa);

        lp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Presence p = lvpa.getItem(pos);
                Toast.makeText(getActivity(), p.data + " " + p.nome_cognome + " " + p.presente + " " + p.ritardo + " " + p.assente, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
