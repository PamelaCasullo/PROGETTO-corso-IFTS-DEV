package it.rizzoli.RED.Student;


import android.content.SharedPreferences;

//TODO FARE CLASSE GENERICA DEL MENU
public class StudentMenuCreationClass {

    // key for storing email.
    public static final String EMAIL_KEY = "textEmail";
    public final static String MY_PREFERENCES = "MyPref";
    // key for storing password.
    public static final String PASSWORD_KEY = "textPassword";

    
    public void Logout(SharedPreferences.Editor editor) {
        editor.putString(EMAIL_KEY,null);
        editor.putString(PASSWORD_KEY,null);
        editor.apply();


    }



}
