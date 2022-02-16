package it.rizzoli.RED;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class VoteDocenteActivity extends AppCompatActivity {
    ListView lvd = null;
    ListViewVotoDocenteAdapter lvvad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_docente);

        lvd = findViewById(R.id.listaVotiDocente);
        VoteDocente[] vote = new VoteDocente[] {
                new VoteDocente("08/02/2022", "Traore Adama Emmanuel", "Applicationi Mobile Android", 25),
                new VoteDocente("18/01/2022", "Pamela Casullo Maura", "Applicationi Mobile Android", 30),
                new VoteDocente("11/12/2021", "Lorenzo Passoni","Applicationi Mobile Android", 28),
                new VoteDocente("22/11/2021", "Dorjan Curtis","Applicationi Mobile Android", 26),
                new VoteDocente("04/11/2021", "Pablo Escobar","Applicationi Mobile Android", 23),
                new VoteDocente("17/10/2021", "Luciano Pelato","Applicationi Mobile Android", 21)
        };

        lvvad = new ListViewVotoDocenteAdapter(this, R.layout.activity_colonne_voti_docente, vote);
        lvd.setAdapter(lvvad);

        lvd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                VoteDocente v = lvvad.getItem(pos);
                Toast.makeText(VoteDocenteActivity.this, v.data + " " + v.nome_cognome + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_docente,menu);

        MenuItem item = menu.findItem(R.id.VOTEDOC);
        item.setVisible(false);

        return true;
    }
    //eseguiamo operazioni nel menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id_item = item.getItemId();

        switch (id_item) {
            case R.id.HOMEPAGEDOC:
                Intent intentHome = new Intent(this, HomePageDocenteActivity.class);
                startActivity(intentHome);
                break;

        }
        return false;
    }
}
