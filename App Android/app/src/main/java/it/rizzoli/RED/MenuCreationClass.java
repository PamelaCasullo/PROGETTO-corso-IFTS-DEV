package it.rizzoli.RED;


import android.content.SharedPreferences;

//TODO FARE CLASSE GENERICA DEL MENU
public class MenuCreationClass{
    SharedPreferences sharedpreferences;
    String email, password;

    // key for storing email.
    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    // key for storing password.
    public static final String PASSWORD_KEY = "textPassword";
/*
    public boolean MenuItemOperations( int id_item) {

        switch (id_item) {
            case R.id.LOGOUT:
                Logout(SharedPreferences.Editor editor);

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

 */
    public void Logout(SharedPreferences.Editor editor) {
        editor.putString(EMAIL_KEY,null);
        editor.putString(PASSWORD_KEY,null);
        editor.apply();


    }



}
