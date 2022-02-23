package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;

public class DbAdapterStudent {

    private static final String LOG_TAG = DbAdapterStudent.class.getSimpleName();
    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    private static final String DB_TABLE="student";

    private static final String TB_F1_PK="id_student";
    private static final String TB_F2="first_name";
    private static final String TB_F3="last_name";
    private static final String TB_F4="date_of_birth";
    private static final String TB_F5="phone_number";
    private static final String TB_F6="personal_email";
    private static final String TB_F7="institutional_email";
    private static final String TB_F8="photo";
    private static final String TB_F9="password";

    public DbAdapterStudent(Context context) {
        this.context=context;
    }
    public DbAdapterStudent open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValue(String first_name, String last_name, Date date_of_birth,
                                             String phone_number, String personal_email, String istitutional_email,
                                             String photo, String password) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TB_F2,first_name);
        contentValues.put(TB_F3,last_name);
        contentValues.put(TB_F4,date_of_birth.getTime());
        contentValues.put(TB_F5,phone_number);
        contentValues.put(TB_F6,personal_email);
        contentValues.put(TB_F7,istitutional_email);
        contentValues.put(TB_F8,photo);
        contentValues.put(TB_F9,password);


        return contentValues;

    }
//create

    public long createStudent(String first_name, String last_name, Date date_of_birth,
                              String phone_number, String personal_email, String istitutional_email,
                              String photo, String password) {
        ContentValues cv = createContentValue(first_name,last_name,date_of_birth,phone_number,personal_email,istitutional_email,photo,password);

        return database.insertOrThrow(DB_TABLE,null,cv);
    }
//update
    public boolean updateStudent(long id_student, String first_name, String last_name, Date date_of_birth,
                                 String phone_number, String personal_email, String istitutional_email,
                                 String photo, String password) {
        ContentValues cv = createContentValue(first_name,  last_name,  date_of_birth,
                 phone_number,  personal_email,  istitutional_email,
                 photo, password);

        return database.update(DB_TABLE,cv,TB_F1_PK+"="+id_student,null)>0;
    }
 //delete
 public boolean deleteStudent(long id_student) {
     return database.delete(DB_TABLE,TB_F1_PK+"="+id_student, null)>0;
 }
//fetchAll
    public Cursor fetchAllStudent() {
        return database.query(DB_TABLE, new String[] {TB_F8,TB_F2,TB_F3,TB_F7,TB_F5},null,null,null,null,null);
    }
//fetchById
    public Cursor fetchStudentById(String id_student) {
        Cursor c = database.query(DB_TABLE, new String[] {TB_F8,TB_F2,TB_F3,TB_F7,TB_F5},TB_F1_PK+"="+id_student,null,null,null,null);
        return c;
    }

}
