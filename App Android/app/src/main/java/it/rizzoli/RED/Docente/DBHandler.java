package it.rizzoli.RED.Docente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "votodb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myvoto";
    private static final String ID_COL = "id";
    private static final String DATA_COL = "data"; //DATA
    private static final String NOME_COL = "nome"; //NOME E COGNOME
    private static final String VOTO_COL = "voto"; //VOTO
    private static final String MODULO_COL = "modulo"; //MODULO

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREAZIONE DELLA TABELLA
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DATA_COL + " TEXT,"
                + NOME_COL + " TEXT,"
                + VOTO_COL + " TEXT,"
                + MODULO_COL + " TEXT)";

        // ESEGUI LA TABELLA SQL
        db.execSQL(query);
    }

    // METODO PER AGGIUNGERE VOTI
    public void addNewCourse(String courseName, String courseDuration, String courseDescription, String courseTracks) {

        // CREAZIONE DI UNA VARIABILE PER LA SCRITTURA DEL DB
        SQLiteDatabase db = this.getWritableDatabase();

        // CREAZIONE VARIABILE PER IL CONTENTVALUES(I VALORI DA INSERIRE NEL DB)
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DATA_COL, courseName);
        values.put(NOME_COL, courseDuration);
        values.put(VOTO_COL, courseDescription);
        values.put(MODULO_COL, courseTracks);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // METODO PER VEDERE TUTTI I VOTI
    public ArrayList<CourseModal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(4),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    // METODO PER AGGIORNARE UN VOTO
    public void updateCourse(String originalCourseName, String courseName, String courseDescription,
                             String courseTracks, String courseDuration) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DATA_COL, courseName);
        values.put(NOME_COL, courseDuration);
        values.put(VOTO_COL, courseDescription);
        values.put(MODULO_COL, courseTracks);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]{originalCourseName});
        db.close();
    }

    // METODO PER ELIMINARE UN VOTO
    public void deleteCourse(String courseName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{courseName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
