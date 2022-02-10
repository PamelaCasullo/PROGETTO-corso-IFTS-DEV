package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


public class HomepageActivity extends AppCompatActivity {

    ListView lv = null;

    //TODO METTERE OVUNQUE LA LOGOUT FUNZIONANTE(vedere commit 31/01/2022)
    SharedPreferences sharedpreferences;
    String email, password;

    Button bv;

    // key for storing email.
    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    // key for storing password.
    public static final String PASSWORD_KEY = "textPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        lv = findViewById(R.id.listaVoti);
        Vote[] vote = new Vote[] {
                new Vote("08/02/2022", "Applicationi Mobile Android", 18),
                new Vote("18/01/2022", "Tecnologie Web per la UI ed il Back-End", 30),
                new Vote("11/12/2021", "Gestione di dati e DataBase", 28),
                new Vote("22/11/2021", "Realizzazione di applicazioni Java", 26),
                new Vote("04/11/2021", "Processo di sviluppo del software", 23),
                new Vote("17/10/2021", "Architetture e Sistemi", 21)
        };

        ListViewVotoAdapter lvva = new ListViewVotoAdapter(this, R.layout.activity_colonne_voti, vote);
        lv.setAdapter(lvva);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Vote v = lvva.getItem(pos);
                Toast.makeText(HomepageActivity.this, v.data + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });

    bv = findViewById(R.id.buttonVoti);
        bv.setOnClickListener(new View.OnClickListener() {
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
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.HOMEPAGE);
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
                Intent intentCalendar = new Intent(this,CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.PROFILE:
                Intent intentProfile = new Intent(this,ProfileActivity.class);
                startActivity(intentProfile);
                break;
            case R.id.COMMUNICATION:
                Intent intentCommunication = new Intent(this,CommunicationActivity.class);
                startActivity(intentCommunication);
                break;
            case R.id.VOTE:
                Intent intentVote = new Intent(this,VoteActivity.class);
                startActivity(intentVote);
                break;
        }

        return false;
    }




}