package it.rizzoli.RED;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button pulsanteLoginText;
    RadioButton studente_btn,docente_btn;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pulsanteLoginText = findViewById(R.id.loginButtonText);

        //singleton di controllo per simulare una autenticazione utente. Funziona su Emulatore pixel 2 API 19

        studente_btn = findViewById(R.id.radio_studente);
        docente_btn = findViewById(R.id.radio_docente);

        pulsanteLoginText.setOnClickListener(v -> {
            EditText email_its = findViewById(R.id.email_its);
            EditText password_its = findViewById(R.id.password_its);

            if( //admin
                email_its.getText().toString().equals("admin@itsrizzoli.it") && password_its.getText().toString().equals("admin") && docente_btn.isChecked()){
                Toast.makeText(getApplicationContext(), "Benvenuto, Admin!",Toast.LENGTH_SHORT).show();

                

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

}