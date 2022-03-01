package it.rizzoli.RED;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class LoginActivity extends AppCompatActivity {

    Button pulsanteLoginText;
    RadioButton studenteButton, docenteButton;
    boolean isStudent = true; //else is teacher
    boolean checked;
    EditText email;
    EditText password;
    String textEmail, textPassword = null;
    SharedPreferences sharedpreferences;
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza
    //private final static String TEXT_EMAIL_KEY = "textEMAIL";
    //private final static String TEXT_PW_KEY = "textPW";
    private final static String TEXT_EMAIL_KEY = "textEmail";
    private final static String TEXT_PW_KEY = "textPassword";
    private final static String TEXT_KIND_KEY = "radioBtnKind";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // CODICE PER L'ANIMAZIONE DI BACKGROUNG
        DrawerLayout drawerLayout = findViewById(R.id.my_drawer_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) drawerLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        pulsanteLoginText = findViewById(R.id.loginButtonText);

        //singleton di controllo per simulare una autenticazione utente. Funziona su Emulatore pixel 2 API 19

        studenteButton = findViewById(R.id.radio_studente);
        docenteButton = findViewById(R.id.radio_docente);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        pulsanteLoginText.setOnClickListener(v -> {

            if ( //admin
                    email.getText().toString().equals("admin@itsrizzoli.it") && password.getText().toString().equals("admin") && docenteButton.isChecked()) {
                Toast.makeText(getApplicationContext(), "Benvenuto, Admin!", Toast.LENGTH_SHORT).show();

                SavePreferencesData(v);

                Intent intentHome = new Intent(this, MainActivity.class);
                startActivity(intentHome);

                finish();


            } else if ( //docente
                    email.getText().toString().equals("docente@itsrizzoli.it") && password.getText().toString().equals("docente") && docenteButton.isChecked()) {
                Toast.makeText(getApplicationContext(), "Benvenuto, Docente!", Toast.LENGTH_SHORT).show();
                SavePreferencesData(v);

                Intent intentHome = new Intent(this, MainActivityDoc.class);
                startActivity(intentHome);

                finish();

            } else if ( //studente
                    email.getText().toString().equals("studente@itsrizzoli.it") && password.getText().toString().equals("studente") && studenteButton.isChecked()) {
                Toast.makeText(getApplicationContext(), "Benvenuto, Studente!", Toast.LENGTH_SHORT).show();

                SavePreferencesData(v);

                Intent intentHome = new Intent(this, MainActivity.class);
                startActivity(intentHome);

                finish();

            } else { //dati errati
                Toast.makeText(getApplicationContext(), "Dati Errati, Riprovare!", Toast.LENGTH_SHORT).show();
            }

        });
    }


    //@todo implements RadioButton interaction with database
    public void onRadioButtonClicked(View v) {
        //is checked?

        checked = ((RadioButton)v).isChecked();
        String selected ;

        //switch for checked status

        switch (v.getId()) {
            case R.id.radio_docente: {
                //bla bla bla
                if(checked) {
                    isStudent = false;
                    selected = "Docente";
                    Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            case R.id.radio_studente: {
                //bla bla
                if(checked) {
                    isStudent = true;
                    selected = "Studente";
                    Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void SavePreferencesData(View view) {
        // Otteniamo il riferimento alle preferenze
        SharedPreferences preference = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Otteniamo il corrispondente Editor
        SharedPreferences.Editor editor = preference.edit();
        // Modifichiamo il valore con quello inserito nell'EditText
        EditText outputViewEmail = (EditText) findViewById(R.id.email);
        EditText outputViewPassword = (EditText) findViewById(R.id.password);
        CharSequence textDataEmail = outputViewEmail.getText();
        CharSequence textDataPassword = outputViewPassword.getText();
        if (textDataEmail != null && textDataPassword != null) {
            // Lo salviamo nelle preferences
            editor.putString(TEXT_EMAIL_KEY, textDataEmail.toString());
            editor.putString(TEXT_PW_KEY, textDataPassword.toString());
            editor.putBoolean(TEXT_KIND_KEY, isStudent);
            editor.apply();

        }
        updatePreferencesData();
    }

    public void updatePreferencesData() {
        // LEGGIAMO LA PREFERENZA
        SharedPreferences preferiti = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla proprietà TEXT_DATA
        textEmail = preferiti.getString(TEXT_EMAIL_KEY, null);
        textPassword = preferiti.getString(TEXT_PW_KEY, null);
        isStudent = preferiti.getBoolean(TEXT_KIND_KEY, true);
        Toast.makeText(this, "E-mail: " + textEmail + " Password: " + textPassword, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updatePreferencesData();
        if(textEmail != null && textPassword != null) {
            if(isStudent) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

            else {
                Intent i = new Intent(LoginActivity.this, MainActivityDoc.class);
                startActivity(i);
                finish();
            }
        }

    }


}