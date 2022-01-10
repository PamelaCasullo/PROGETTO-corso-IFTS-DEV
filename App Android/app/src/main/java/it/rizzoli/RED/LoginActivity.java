package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button pulsanteLoginText = findViewById(R.id.loginButtonText);
        //singleton di controllo per simulare una autenticazione utente. Funziona su Emulatore pixel 2 API 19

        pulsanteLoginText.setOnClickListener(v -> {
            EditText email_its = findViewById(R.id.email_its);
            EditText password_its = findViewById(R.id.password_its);

            if(email_its.getText().toString().equals("admin@itsrizzoli.it") && password_its.getText().toString().equals("admin")){
                Toast.makeText(getApplicationContext(), "Benvenuto, Admin!",Toast.LENGTH_SHORT).show();
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
            }
        });
    }



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
            case R.id.VOTE: //TODO REMOVE FROM ANY CLASS!!!
                Intent intentVote = new Intent(this,VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }



    //todo interazione coi pulsanti
}