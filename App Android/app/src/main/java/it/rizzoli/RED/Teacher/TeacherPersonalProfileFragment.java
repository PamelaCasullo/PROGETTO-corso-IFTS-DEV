package it.rizzoli.RED.Teacher;

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

import androidx.fragment.app.Fragment;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Teacher;
import it.rizzoli.RED.Connection.TeacherWebInterface;
import it.rizzoli.RED.R;
import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherPersonalProfileFragment extends Fragment {

    int textId = 0;
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza
    private final static String TEXT_ID_KEY = "textId";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_personal_profile, container, false);

        // LEGGIAMO LA PREFERENZA
        SharedPreferences preferiti = getActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla proprietà TEXT_DATA
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp)getActivity().getApplication();
        TeacherWebInterface apiService;
        apiService = app.retrofit.create(TeacherWebInterface.class);

        Call<Teacher> call = apiService.searchById(textId);

        call.enqueue(new Callback<Teacher>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call call, Response response) {
                Teacher teacher = (Teacher) response.body();
                if(response.code() == 500) {
                    Toast.makeText(getActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else {
                    TextView textViewFirstName = view.findViewById(R.id.textViewDataFirstName);
                    textViewFirstName.setText(teacher.getFirst_name());
                    TextView textViewLastName = view.findViewById(R.id.textViewDataLastName);
                    textViewLastName.setText(teacher.getLast_name());
                    TextView editText = view.findViewById(R.id.textViewDataInstitutionalEmail);
                    editText.setText(teacher.getInstitutional_email());
                    EditText editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber);
                    editTextPhoneNumber.setText(teacher.getPhone_number());
                    EditText editTextPersonalEmail = view.findViewById(R.id.editTextPersonalEmail);
                    editTextPersonalEmail.setText(teacher.getPersonal_email());
                    EditText editTextPassword = view.findViewById(R.id.editTextDataPassword);
                    editTextPassword.setText(teacher.getPassword());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Fallito! ", t.getMessage());
            }
        });
        return view;
    }
}