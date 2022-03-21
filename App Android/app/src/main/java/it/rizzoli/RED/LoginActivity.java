package it.rizzoli.RED;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.Connection.Credential;
import it.rizzoli.RED.Connection.Teacher;
import it.rizzoli.RED.Connection.TeacherWebInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class LoginActivity extends AppCompatActivity {

    //altro
    Button pulsanteLoginText;
    RadioButton studenteButton, docenteButton;
    boolean isStudent = true; //else is teacher
    boolean checked;
    EditText email;
    EditText password;
    String textEmail, textPassword = null;
    int textId = 0;
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza

    private final static String TEXT_EMAIL_KEY = "textEmail";
    private final static String TEXT_PW_KEY = "textPassword";
    private final static String TEXT_ID_KEY = "textId";
    private final static String TEXT_KIND_KEY = "radioBtnKind";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pulsanteLoginText = findViewById(R.id.loginButtonText);

        studenteButton = findViewById(R.id.radio_studente);
        docenteButton = findViewById(R.id.radio_docente);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        pulsanteLoginText.setOnClickListener(v -> {
            try {
                String email = this.email.getText().toString();
                String password = this.password.getText().toString();
                if ( //docente
                        docenteButton.isChecked()){
                    if (!email.equals("") && !password.equals("")){
                        AsynkTaskApp app = (AsynkTaskApp)getApplication();
                        TeacherWebInterface apiService = app.retrofit.create(TeacherWebInterface.class);
                        Credential credential = new Credential(email, password);
                        Call<Teacher> call = apiService.login(credential);

                        call.enqueue(new Callback<Teacher>() {
                            @EverythingIsNonNull
                            @Override
                            public void onResponse(Call call, Response response) {
                                int statusCode = response.code();
                                Teacher teacher = (Teacher) response.body();
                                if(statusCode == 500) {
                                    Toast.makeText(getApplicationContext(), "Dati Errati, Riprovare!", Toast.LENGTH_LONG).show();
                                } else {
                                    assert teacher != null;
                                    SavePreferencesData(teacher.getId_teacher());
                                    Toast.makeText(LoginActivity.this, "Benvenuto Docente!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginActivity.this, TeacherMainActivity.class);
                                    startActivity(intent);
                                }

                            }
                            @EverythingIsNonNull
                            @Override
                            public void onFailure(Call call, Throwable t) {
                                Log.e("Fallito! ", t.getMessage());
                            }
                        });
                    }

                } else if ( //studente
                        studenteButton.isChecked()) {
                    if (!email.equals("") && !password.equals("")){
                        AsynkTaskApp app = (AsynkTaskApp)getApplication();
                        StudentWebInterface apiService = app.retrofit.create(StudentWebInterface.class);
                        Credential credential = new Credential(email, password);
                        Call<Student> call = apiService.login(credential);

                        call.enqueue(new Callback<Student>() {
                            @EverythingIsNonNull
                            @Override
                            public void onResponse(Call call, Response response) {
                                int statusCode = response.code();
                                Student student = (Student) response.body();
                                if(statusCode == 500) {
                                    Toast.makeText(getApplicationContext(), "Dati Errati, Riprovare!", Toast.LENGTH_LONG).show();
                                } else {
                                    assert student != null;
                                    SavePreferencesData(student.getId_student());
                                    Toast.makeText(LoginActivity.this, "Benvenuto Studente!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginActivity.this, StudentMainActivity.class);
                                    startActivity(intent);
                                }
                            }
                            @EverythingIsNonNull
                            @Override
                            public void onFailure(Call call, Throwable t) {
                                Log.e("Fallito! ", t.getMessage());
                            }
                        });
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Selezionare il tipo di utente e riprovare!", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception exceptionx) {
                Log.e("Error", exceptionx.getMessage());
            }

        });
    }



    @SuppressLint("NonConstantResourceId")
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

    public void SavePreferencesData(int id) {
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
            editor.putInt(TEXT_ID_KEY, id);
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
        textId = preferiti.getInt(TEXT_ID_KEY, 0);
        isStudent = preferiti.getBoolean(TEXT_KIND_KEY, true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updatePreferencesData();
        if(textEmail != null && textPassword != null && textId != 0) {
            Intent i;
            if(isStudent) {
                i = new Intent(LoginActivity.this, StudentMainActivity.class);
            }

            else {
                i = new Intent(LoginActivity.this, TeacherMainActivity.class);
            }
            startActivity(i);
            finish();
        }

    }


}