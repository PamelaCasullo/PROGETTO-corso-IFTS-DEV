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

public class PresenceActivity extends AppCompatActivity {

    ListView lp = null;
    ListViewPresenceAdapter lvpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence);

        lp = findViewById(R.id.listaPresence);
        Presence[] presence = new Presence[] {
                new Presence("08/02/2022", "Traore Adama Emmanuel", "P", "/", "/"),
                new Presence("18/01/2022", "Pamela Casullo Maura", "P", "/", "/"),
                new Presence("11/12/2021", "Lorenzo Passoni", "/", "A", "/"),
                new Presence("22/11/2021", "Dorjan Curtis", "P", "/", "/"),
                new Presence("04/11/2021", "Pablo Escobar", "/", "/", "R: 20min"),
                new Presence("17/10/2021", "Luciano Pelato", "/", "/", "R: 2ore")
        };

        lvpa = new ListViewPresenceAdapter(this, R.layout.colonne_presence, presence);
        lp.setAdapter(lvpa);

        lp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Presence p = lvpa.getItem(pos);
                Toast.makeText(PresenceActivity.this, p.data + " " + p.nome_cognome + " " + p.presente + " " + p.ritardo + " " + p.assente, Toast.LENGTH_LONG).show();
            }
        });
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.PRESENCE);
        item.setVisible(false);

        return true;
    }


//eseguiamo operazioni nel menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id_item = item.getItemId();

        switch (id_item) {
            case R.id.HOMEPAGE:
                Intent intentHome = new Intent(this, HomepageActivity.class);
                startActivity(intentHome);
                break;
            case R.id.LOGOUT:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.CALENDAR:
                Intent intentCalendar = new Intent(this, CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.PROFILE:
                Intent intentProfile = new Intent(this, ProfileActivity.class);
                startActivity(intentProfile);
                break;
            case R.id.VOTE:
                Intent intentVote = new Intent(this, VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }
}