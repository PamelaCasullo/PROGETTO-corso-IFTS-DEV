package it.rizzoli.RED;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

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


        // SERVE A VISUALIZZARE L'ANIMAZIONE FIGA DEL MENU APRI/CHIUDI

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getBackground().setAlpha(120);

        // SERVE PER COLLEGARSI CON IL LAYOUT DELL'AMBURGER MENU (PER APRIRE E CHIUDERE)
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                    new HomepageFragment()).commit();
            navigationView.setCheckedItem(R.id.HOMEPAGE);
        }

        // SERVE PER FAR APPARIRE L'AMBURGER MENU
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // SERVE A APRIRE E CHIUDERE IL MENU
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // SERVE A, QUANDO CLICCO SU UNA VOCE DEL MENU SI APRE E FUNZIONAAAAAA!!!
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CALENDAR:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new CalendarFragment()).commit();
                break;
            case R.id.HOMEPAGE:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new HomepageFragment()).commit();
                break;
            case R.id.PRESENCE:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new AbsenceFragment()).commit();
                break;
            case R.id.PROFILE:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new ProfileFragment()).commit();
                break;
            case R.id.VOTE:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new VoteFragment()).commit();
                break;
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
            case R.id.PERSONAL_PROFILE:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new PersonalProfileFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Sei sicuro/a di voler uscire?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}