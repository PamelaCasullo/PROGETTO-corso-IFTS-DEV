package it.rizzoli.RED.Student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.Connection.Teacher;
import it.rizzoli.RED.LoginActivity;
import it.rizzoli.RED.R;
import it.rizzoli.RED.TeacherMainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentPersonalProfileFragment extends Fragment {

    int textId = 0;
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza
    String textEmail, textPassword = null;
    private final static String TEXT_ID_KEY = "textId";
    private final static String TEXT_PW_KEY = "textPassword";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_profile, container, false);

        // LEGGIAMO LA PREFERENZA
        SharedPreferences preferiti = getActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla proprietà TEXT_DATA
        textId = preferiti.getInt(TEXT_ID_KEY, 0);
        textPassword = preferiti.getString(TEXT_PW_KEY, null);

        AsynkTaskApp app = (AsynkTaskApp)getActivity().getApplication();
        StudentWebInterface apiService = null;
        apiService = app.retrofit.create(StudentWebInterface.class);

        Call<Student> call = apiService.searchById(textId);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call call, Response response) {
                Student student = (Student) response.body();
                if(response.code() == 500) {
                    Toast.makeText(getActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    TextView textViewFirstName = (TextView)view.findViewById(R.id.editTextFirstName);
                    textViewFirstName.setText(student.getFirst_name(), TextView.BufferType.SPANNABLE);
                    /*
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);
                    EditText editText = (EditText)view.findViewById(R.id.editTextFirstName);
                    editText.setText(student.getFirst_name(), TextView.BufferType.EDITABLE);


                    */
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Fallito! ", t.getMessage());
            }
        });

        return view;
    }

}
