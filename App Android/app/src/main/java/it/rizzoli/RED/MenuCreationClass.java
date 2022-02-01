package it.rizzoli.RED;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;

//TODO FARE CLASSE GENERICA DEL MENU
public class MenuCreationClass extends Activity {
    SharedPreferences sharedpreferences;
    String email, password;

    // key for storing email.
    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    // key for storing password.
    public static final String PASSWORD_KEY = "textPassword";
    public boolean MenuItemOperations( int id_item) {

        switch (id_item) {
            case R.id.LOGOUT:
                Logout();

                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);

                finish();
                break;
            case R.id.CALENDAR:
                Intent intentCalendar = new Intent(this,CalendarActivity.class);
                startActivity(intentCalendar);
                break;
            case R.id.REGISTER:
                Intent intentRegister = new Intent(this,RegisterActivity.class);
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
        }
        return true;
    }
    public void Logout() {
        sharedpreferences = getSharedPreferences(HomepageActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        email = sharedpreferences.getString(HomepageActivity.EMAIL_KEY, null);
        password = sharedpreferences.getString(HomepageActivity.PASSWORD_KEY, null);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(email,null);
        editor.putString(password,null);
        editor.apply();

    }



}
