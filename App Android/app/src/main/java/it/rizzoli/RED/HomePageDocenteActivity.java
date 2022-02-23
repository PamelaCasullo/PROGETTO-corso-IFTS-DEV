package it.rizzoli.RED;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class HomePageDocenteActivity extends AppCompatActivity {
    ListView lv;
    ListViewVotoDocenteAdapter lvvad;
    Button bvd;

    //TODO METTERE OVUNQUE LA LOGOUT FUNZIONANTE(vedere commit 31/01/2022)
    SharedPreferences sharedpreferences;
    String email, password;

    // key for storing email.
    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    // key for storing password.
    public static final String PASSWORD_KEY = "textPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_docente);

        lv = findViewById(R.id.listaVotiDocente);
        VoteDocente[] vote = new VoteDocente[]{
                new VoteDocente("08/02/2022", "Traore Adama Emmanuel", "Applicationi Mobile Android", 25),
                new VoteDocente("18/01/2022", "Pamela Casullo Maura", "Applicationi Mobile Android", 30),
                new VoteDocente("11/12/2021", "Lorenzo Passoni", "Applicationi Mobile Android", 28),
                new VoteDocente("22/11/2021", "Dorjan Curtis", "Applicationi Mobile Android", 26),
                new VoteDocente("04/11/2021", "Pablo Escobar", "Applicationi Mobile Android", 23),
                new VoteDocente("17/10/2021", "Luciano Pelato", "Applicationi Mobile Android", 21)
        };

        lvvad = new ListViewVotoDocenteAdapter(this, R.layout.activity_colonne_voti_docente, vote);
        lv.setAdapter(lvvad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                VoteDocente v = lvvad.getItem(pos);
                Toast.makeText(HomePageDocenteActivity.this, v.data + " " + v.nome_cognome + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });

        bvd = findViewById(R.id.buttonVotiDocente);
        bvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent va = new Intent(getApplicationContext(), VoteActivity.class);
                startActivity(va);
            }
        });

    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_docente,menu);

        MenuItem item = menu.findItem(R.id.HOMEPAGEDOC);
        item.setVisible(false);

        return true;
    }
    //eseguiamo operazioni nel menu
//TODO 1 Aggiungere toast ovunque nei menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // super.onOptionsItemSelected(item);
        int id_item = item.getItemId();
        switch (id_item) {
            case R.id.LOGOUT:
                sharedpreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
                email = sharedpreferences.getString(EMAIL_KEY, null);
                password = sharedpreferences.getString(PASSWORD_KEY, null);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                MenuCreationClass menuCreationClass = new MenuCreationClass();
                menuCreationClass.Logout(editor);

                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);

                finish();
                break;
            case R.id.CALENDAR:
                Intent intentCalendar = new Intent(this, CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
                startActivity(intentRegister);
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
