package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

public class CalendarDocenteActivity extends AppCompatActivity {

    private final static String MY_PREFERENCES = "MyPref";

    WebView webView;
    public String fileName = "TimeTable.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_docente);

        // INIZIALIZZA WEBVIEW
        webView = (WebView) findViewById(R.id.webview_docente);

        // VISUALIZZA IL CONTENUTO DELLA WEBVIEW DAL FILE HTML CHE STA NELL'ASSETS
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_docente,menu);

        MenuItem item = menu.findItem(R.id.CALENDARDOC);
        item.setVisible(false);

        return true;
    }
    //eseguiamo operazioni nel menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id_item = item.getItemId();

        switch (id_item) {
            case R.id.HOMEPAGEDOC:
                Intent intentHome = new Intent(this, HomePageDocenteActivity.class);
                startActivity(intentHome);
                break;
            case R.id.LOGOUTDOC:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.PROFILEDOC:
                Intent intentProfile = new Intent(this, ProfileActivity.class);
                startActivity(intentProfile);
                break;
            case R.id.VOTEDOC:
                Intent intentVote = new Intent(this, VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }

}