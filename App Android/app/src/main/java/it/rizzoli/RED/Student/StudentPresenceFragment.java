package it.rizzoli.RED.Student;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.AsynkTaskApp;
import it.rizzoli.RED.Connection.StudentWebInterface;
import it.rizzoli.RED.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentPresenceFragment extends Fragment {

    RecyclerView recyclerView = null;
    int textId = 0;
    private final static String MY_PREFERENCES = "MyPref";
    private final static String TEXT_ID_KEY = "textId";
    Activity activity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_presence, container, false);

        SharedPreferences preferiti = requireActivity().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        textId = preferiti.getInt(TEXT_ID_KEY, 0);

        AsynkTaskApp app = (AsynkTaskApp) requireActivity().getApplication();
        StudentWebInterface apiService = app.retrofit.create(StudentWebInterface.class);
        Call<List<RecyclerViewPresenceStudent>> call = apiService.showPresence(textId);

        call.enqueue(new Callback<List<RecyclerViewPresenceStudent>>() {
            @Override
            public void onResponse(@NonNull Call<List<RecyclerViewPresenceStudent>> call, @NonNull Response<List<RecyclerViewPresenceStudent>> response) {
                if(response.code() == 500) {
                    Toast.makeText(requireActivity().getApplicationContext(), "Errore inaspettato!", Toast.LENGTH_LONG).show();
                } else{
                    recyclerView = view.findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity));

                    List<RecyclerViewPresenceStudent> presence = response.body();

                    StudentPresenceAdapter spa = new StudentPresenceAdapter(presence);
                    recyclerView.setAdapter(spa);

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RecyclerViewPresenceStudent>> call, @NonNull Throwable t) {
                Log.e("Fallito! ", t.getMessage());
            }
        });

        return view;
    }
}
