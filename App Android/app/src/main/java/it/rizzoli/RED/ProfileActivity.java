package it.rizzoli.RED;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    RadioButton studenteButton, docenteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.PROFILE);
        item.setVisible(false);

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
            case R.id.LOGOUT:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.CALENDAR:
                Intent intentCalendar = new Intent(this, CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.VOTE:
                Intent intentVote = new Intent(this, VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }
}