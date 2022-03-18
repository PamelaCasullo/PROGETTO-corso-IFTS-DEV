package it.rizzoli.RED.Teacher;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.Connection.Teacher;
import it.rizzoli.RED.Connection.TeacherWebInterface;
import it.rizzoli.RED.R;
import it.rizzoli.RED.Student.StudentUpdateProfile;
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
        Button updateDataButton;
        // LEGGIAMO LA PREFERENZA
        SharedPreferences preferiti = requireActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla proprietà TEXT_DATA
        textId = preferiti.getInt(TEXT_ID_KEY, 0);
        updateDataButton = view.findViewById(R.id.updateButton);

        AsynkTaskApp app = (AsynkTaskApp) requireActivity().getApplication();
        TeacherWebInterface apiService;
        apiService = app.retrofit.create(TeacherWebInterface.class);

        Call<Teacher> call = apiService.searchById(textId);

        call.enqueue(new Callback<Teacher>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call call, Response response) {
                Teacher teacher = (Teacher) response.body();
                if(response.code() == 500) {
                    Toast.makeText(requireActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
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

        updateDataButton.setOnClickListener(v -> {

            EditText personalEmail = view.findViewById(R.id.editTextPersonalEmail);
            EditText phoneNumber = view.findViewById(R.id.editTextPhoneNumber);
            EditText password = view.findViewById(R.id.editTextDataPassword);

            TeacherUpdateProfile teacherUpdateProfile = new TeacherUpdateProfile(textId, personalEmail.getText().toString(), phoneNumber.getText().toString(), password.getText().toString());

            try {
                Call<Teacher> updateData = apiService.updateElementById(teacherUpdateProfile);

                updateData.enqueue(new Callback<Teacher>() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        phoneNumber.setText(teacherUpdateProfile.getPhone_number());
                        personalEmail.setText(teacherUpdateProfile.getPersonal_email());
                        password.setText(teacherUpdateProfile.getPassword());
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.e("Fallito! ", t.getMessage());
                    }
                });
            } catch (Exception exceptionx) {
                Log.e("Error", exceptionx.getMessage());
            }
        });
        return view;
    }
}