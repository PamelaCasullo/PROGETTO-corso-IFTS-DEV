package it.rizzoli.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CommunicationActivity extends AppCompatActivity {

    ListView lvc;
    ListViewComunicazioniAdapter lvca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        lvc = findViewById(R.id.listaComu);
        Communication[] comu = new Communication[] {
                new Communication("08/02/2022", "Salve ragazzi, domani le lezioni saranno sospese a causa dei sciopperi dei mezzi, grazie e buona serata"),
                new Communication("18/01/2022", "Salve ragazzi, domani ci sara l'esame parziale di DataBase, grazie e buona serata"),
                new Communication("11/12/2021", "Salve ragazzi, da domani ci sarà obbligatorio essere in possesso del greenpass per partecipare alle lezioni, grazie e buona serata"),
                new Communication("22/11/2021", "Salve ragazzi, da domani le lezioni proseguiranno in FAD a causa dei positivi segnalati, grazie e buona serata")
        };
        lvca = new ListViewComunicazioniAdapter(this, R.layout.activity_colonne_communication, comu);
        lvc.setAdapter(lvca);

        lvc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Communication c = lvca.getItem(pos);
                Toast.makeText(CommunicationActivity.this, c.data + " " + c.comunicazioni, Toast.LENGTH_LONG).show();
            }
        });
    }

    //istanziamo un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.COMMUNICATION);
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
                Intent intentCalendar = new Intent(this,CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.PRESENCE:
                Intent intentRegister = new Intent(this, PresenceActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.PROFILE:
                Intent intentProfile = new Intent(this,ProfileActivity.class);
                startActivity(intentProfile);
                break;
            case R.id.VOTE:
                Intent intentVote = new Intent(this,VoteActivity.class);
                startActivity(intentVote);
                break;
        }
        return false;
    }
}