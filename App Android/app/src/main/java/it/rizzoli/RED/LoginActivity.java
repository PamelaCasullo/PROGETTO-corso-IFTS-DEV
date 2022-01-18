package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button pulsanteLoginText = findViewById(R.id.loginButtonText);
        RadioButton studente_btn,docente_btn ;
        //singleton di controllo per simulare una autenticazione utente. Funziona su Emulatore pixel 2 API 19

<<<<<<< Updated upstream
        studente_btn = (RadioButton) findViewById(R.id.radio_studente);
        docente_btn = (RadioButton) findViewById(R.id.radio_docente);


=======
>>>>>>> Stashed changes
        pulsanteLoginText.setOnClickListener(v -> {
            EditText email_its = findViewById(R.id.email_its);
            EditText password_its = findViewById(R.id.password_its);

            if( //admin
                email_its.getText().toString().equals("admin@itsrizzoli.it") && password_its.getText().toString().equals("admin") && docente_btn.isChecked()){
                Toast.makeText(getApplicationContext(), "Benvenuto, Admin!",Toast.LENGTH_SHORT).show();
<<<<<<< Updated upstream

                Intent intentHome = new Intent(this, HomepageActivity.class);
                startActivity(intentHome);


            }else if( //docente
                email_its.getText().toString().equals("docente@itsrizzoli.it") && password_its.getText().toString().equals("admin")&& docente_btn.isChecked()){
                Toast.makeText(getApplicationContext(), "Benvenuto, Docente!",Toast.LENGTH_SHORT).show();

                Intent intentHome = new Intent(this, HomepageActivity.class);
                startActivity(intentHome);

            }else if( //studente
                email_its.getText().toString().equals("studente@itsrizzoli.it")&&password_its.getText().toString().equals("admin")&& studente_btn.isChecked()) {
                Toast.makeText(getApplicationContext(), "Benvenuto, Studente!",Toast.LENGTH_SHORT).show();

                Intent intentHome = new Intent(this, HomepageActivity.class);
                startActivity(intentHome);

            } else { //dati errati
                Toast.makeText(getApplicationContext(), "Dati Errati, Riprovare!",Toast.LENGTH_SHORT).show();

=======
            //corretto e admin
            }else{
                if(email_its.getText().toString().equals("docente@itsrizzoli.it") && password_its.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Benvenuto, Docente!",Toast.LENGTH_SHORT).show();
                    //corretto e docente

                }else{
                if(email_its.getText().toString().equals("studente@itsrizzoli.it")&&password_its.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Benvenuto, Studente!",Toast.LENGTH_SHORT).show();
                    //corretto e studente
                }
                else {
                    Toast.makeText(getApplicationContext(), "Dati Errati, Riprovare!",Toast.LENGTH_SHORT).show();
                    //dati errati
                }
                }
>>>>>>> Stashed changes
            }
        });
    }


    //@todo implementare RadioButton interaction
    public void onRadioButtonClicked(View v) {
        //is checked?
        boolean checked = ((RadioButton)v).isChecked();
        String selected = "" ;

        //switch for checked status

        switch (v.getId()) {
            case R.id.radio_docente: {
                //bla bla bla
                if(checked) {
                    selected = "Docente";
                    Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            case R.id.radio_studente: {
                //bla bla
                if(checked) {
                    selected = "Studente";
                    Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

<<<<<<< Updated upstream
/*
=======


>>>>>>> Stashed changes
    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

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
            case R.id.LOGIN:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.CALENDAR:
                Intent intentCalendar = new Intent(this,CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.REGISTER:
                Intent intentRegister = new Intent(this,RegisterActivity.class);
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

        }
        return false;
    }

*/

    //todo interazione coi pulsanti
}