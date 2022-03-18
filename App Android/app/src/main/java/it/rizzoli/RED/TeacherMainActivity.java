package it.rizzoli.RED;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Teacher;
import it.rizzoli.RED.Connection.TeacherWebInterface;
import it.rizzoli.RED.Teacher.TeacherCalendarFragment;
import it.rizzoli.RED.Teacher.TeacherHomepageFragment;
import it.rizzoli.RED.Teacher.TeacherMenuCreationClass;
import it.rizzoli.RED.Teacher.TeacherPersonalProfileFragment;
import it.rizzoli.RED.Teacher.TeacherPresenceFragment;
import it.rizzoli.RED.Teacher.TeacherProfileFragment;
import it.rizzoli.RED.Teacher.TeacherSetVoteFragment;
import it.rizzoli.RED.Teacher.TeacherVoteFragment;
import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    SharedPreferences sharedpreferences;
    String email, password;
    int textId = 0;

    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    public static final String PASSWORD_KEY = "textPassword";
    private final static String TEXT_ID_KEY = "textId";

    public void funzione(Bundle savedInstanceState){
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
                    new TeacherHomepageFragment()).commit();
            navigationView.setCheckedItem(R.id.HOMEPAGEDOC);
        }

        // SERVE PER FAR APPARIRE L'AMBURGER MENU
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);

        SharedPreferences preferiti = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp)getApplication();
        TeacherWebInterface apiService;
        apiService = app.retrofit.create(TeacherWebInterface.class);

        Call<Teacher> call = apiService.searchById(textId);

        call.enqueue(new Callback<Teacher>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call call, Response response) {
                Teacher teacher = (Teacher) response.body();
                if(response.code() == 500) {
                    Toast.makeText(getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    TextView textViewNameLastName = findViewById(R.id.textViewNameLastName);
                    String all = teacher.getFirst_name() + " " + teacher.getLast_name();
                    textViewNameLastName.setText(all);
                    TextView editText = findViewById(R.id.textViewDataInstitutionalEmail);
                    editText.setText(teacher.getInstitutional_email());
                    funzione(savedInstanceState);
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Fallito! ", t.getMessage());
            }
        });


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
            case R.id.CALENDARDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherCalendarFragment()).commit();
                break;
            case R.id.HOMEPAGEDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherHomepageFragment()).commit();
                break;
            case R.id.PRESENCEDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherPresenceFragment()).commit();
                break;
            case R.id.PROFILEDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherProfileFragment()).commit();
                break;
            case R.id.VOTEDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherVoteFragment()).commit();
                break;
            case R.id.LOGOUTDOC:
                sharedpreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
                email = sharedpreferences.getString(EMAIL_KEY, null);
                password = sharedpreferences.getString(PASSWORD_KEY, null);
                textId = sharedpreferences.getInt(TEXT_ID_KEY, 0);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                TeacherMenuCreationClass teacherMenuCreationClass = new TeacherMenuCreationClass();
                teacherMenuCreationClass.Logout(editor);

                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);

                finish();
                break;
            case R.id.PERSONAL_PROFILEDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherPersonalProfileFragment()).commit();
                break;
            case R.id.ASSEGNAVOTIDOC:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        new TeacherSetVoteFragment()).commit();
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
                .setPositiveButton("Si", (dialog, id) -> TeacherMainActivity.this.finish())
                .setNegativeButton("No", null)
                .show();
    }
}