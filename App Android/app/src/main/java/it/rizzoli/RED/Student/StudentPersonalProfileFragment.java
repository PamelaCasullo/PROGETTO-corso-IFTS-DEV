package it.rizzoli.RED.Student;

import android.content.Context;
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
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentPersonalProfileFragment extends Fragment {

    int textId = 0;
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza
    private final static String TEXT_ID_KEY = "textId";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_personal_profile, container, false);

        // LEGGIAMO LA PREFERENZA
        SharedPreferences preferiti = getActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla proprietà TEXT_DATA
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp)getActivity().getApplication();
        StudentWebInterface apiService;
        apiService = app.retrofit.create(StudentWebInterface.class);

        Call<Student> call = apiService.searchById(textId);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call call, Response response) {
                Student student = (Student) response.body();
                if(response.code() == 500) {
                    Toast.makeText(getActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    TextView textViewFirstName = view.findViewById(R.id.textViewDataFirstName);
                    textViewFirstName.setText(student.getFirst_name());
                    TextView textViewLastName = view.findViewById(R.id.textViewDataLastName);
                    textViewLastName.setText(student.getLast_name());
                    TextView editText = view.findViewById(R.id.textViewDataInstitutionalEmail);
                    editText.setText(student.getInstitutional_email());
                    EditText editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber);
                    editTextPhoneNumber.setText(student.getPhone_number());
                    EditText editTextPersonalEmail = view.findViewById(R.id.editTextPersonalEmail);
                    editTextPersonalEmail.setText(student.getPersonal_email());
                    TextView textViewDateOfBirth = view.findViewById(R.id.textViewDataDateOfBirth);
                    textViewDateOfBirth.setText(student.getDate_of_birth().toString());
                    EditText editTextPassword = view.findViewById(R.id.editTextDataPassword);
                    editTextPassword.setText(student.getPassword());
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
