package it.rizzoli.RED.Student;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class StudentDBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "votodb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myvoto";
    private static final String ID_COL = "id";
    private static final String DATA_COL = "data"; //DATA
    private static final String NOME_COL = "nome"; //NOME E COGNOME
    private static final String VOTO_COL = "voto"; //VOTO
    private static final String MODULO_COL = "modulo"; //MODULO

    public StudentDBHandler(Context context) {
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

    // METODO PER VEDERE TUTTI I VOTI
    public ArrayList<StudentCourseModal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<StudentCourseModal> studentCourseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                studentCourseModalArrayList.add(new StudentCourseModal(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(4),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return studentCourseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
