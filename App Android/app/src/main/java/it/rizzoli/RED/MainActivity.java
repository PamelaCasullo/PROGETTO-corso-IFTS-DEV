package it.rizzoli.RED;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    ListView lv;
    Button bv;

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
        setContentView(R.layout.activity_main);

        // SERVE A VISUALIZZARE LA MINILISVIEW NELLA HOMEPAGE
        lv = findViewById(R.id.listaVoti);
        Vote[] vote = new Vote[]{
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
                Toast.makeText(MainActivity.this, v.data + " " + v.materia + " " + v.voto, Toast.LENGTH_LONG).show();
            }
        });

        // QUESTO E' IL BOTTONE DEI VOTI PER ACCEDERE ALL'ACTIVITY VOTI
        bv = findViewById(R.id.buttonVoti);
        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent va = new Intent(getApplicationContext(), VoteActivity.class);
                startActivity(va);
            }
        });

        // SERVE A VISUALIZZARE L'ANIMAZIONE FIGA DEL MENU APRI/CHIUDI

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // SERVE A, QUANDO CLICCO SUL MENU SI APRE
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // SERVE A, QUANDO CLICCO SU UNA VOCE DEL MENU SI APRE E FUNZIONAAAAAA!!!
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.HOMEPAGE) {
            Intent i = new Intent(this, HomepageActivity.class);
            startActivity(i);
        } else if (id == R.id.CALENDAR) {
            Intent i = new Intent(this, CalendarActivity.class);
            startActivity(i);
        } else if (id == R.id.PRESENCE) {
            Intent i = new Intent(this, PresenceActivity.class);
            startActivity(i);
        } else if (id == R.id.PROFILE) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        } else if (id == R.id.VOTE) {
            Intent i = new Intent(this, VoteActivity.class);
            startActivity(i);
        } else if (id == R.id.LOGOUT) {
            sharedpreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
            email = sharedpreferences.getString(EMAIL_KEY, null);
            password = sharedpreferences.getString(PASSWORD_KEY, null);

            SharedPreferences.Editor editor = sharedpreferences.edit();
            MenuCreationClass menuCreationClass = new MenuCreationClass();
            menuCreationClass.Logout(editor);

            Intent intentLogin = new Intent(this, LoginActivity.class);
            startActivity(intentLogin);

            finish();
        }
        return false;
    }
}