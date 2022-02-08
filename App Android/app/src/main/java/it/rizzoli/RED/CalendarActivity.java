package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendar ;
    TextView calendar_view;

    private final static String MY_PREFERENCES = "MyPref";

    Button closePopupBtn;
    PopupWindow popupWindow;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendar = findViewById(R.id.CALENDAR);
        calendar_view = findViewById(R.id.CALENDAR_TEXT_VIEW);

        closePopupBtn = findViewById(R.id.closePopupBtn);
        linearLayout = findViewById(R.id.LinearLayout);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    // Store the value of date with format in String type Variable
                    // Add 1 in month because month index is start with 0
                    String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                    // set this date in TextView for Display
                    calendar_view.setText(Date);

                }

            });
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.CALENDAR);
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
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
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
            case R.id.VOTE:
                Intent intentVote = new Intent(this,VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }

}