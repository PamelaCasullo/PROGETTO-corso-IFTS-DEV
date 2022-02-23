package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;

public class DBAdapterTeacher {
    private static final String LOG_TAG = DbAdapterInstitution.class.getSimpleName();
    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    private static final String DB_TABLE="teacher";

    private static final String TB_F1_PK="id_teacher";
    private static final String TB_F2="first_name";
    private static final String TB_F3="last_name";
    private static final String TB_F4="phone_number";
    private static final String TB_F5="personal_email";
    private static final String TB_F6="institutional_email";
    private static final String TB_F7="photo";
    private static final String TB_F8="password";

    public DBAdapterTeacher(Context context) {
        this.context = context;
    }
    public DBAdapterTeacher open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    private ContentValues createContentValue(String first_name, String last_name,
                                             String phone_number, String personal_email, String istitutional_email,
                                             String photo, String password) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TB_F2,first_name);
        contentValues.put(TB_F3,last_name);
        contentValues.put(TB_F4,phone_number);
        contentValues.put(TB_F5,personal_email);
        contentValues.put(TB_F6,istitutional_email);
        contentValues.put(TB_F7,photo);
        contentValues.put(TB_F8,password);

        return contentValues;
    }

    //create

    public long createTeacher(String first_name, String last_name,
                              String phone_number, String personal_email, String istitutional_email,
                              String photo, String password) {
        ContentValues contentValues = createContentValue(first_name,last_name,phone_number,personal_email,istitutional_email,photo,password);

        return  database.insertOrThrow(DB_TABLE,null,contentValues);
    }
    //update
    public boolean updateTeacher(long id_teacher, String first_name, String last_name,
                              String phone_number, String personal_email, String istitutional_email,
                              String photo, String password) {
        ContentValues contentValues = createContentValue(first_name, last_name,
                phone_number, personal_email, istitutional_email,
                photo, password);

        return database.update(DB_TABLE,contentValues,TB_F1_PK+"="+id_teacher,null)>0;
    }
    //delete
    public boolean deleteTeacher(long id_teacher) {
        return database.delete(DB_TABLE,TB_F1_PK+"="+id_teacher,null)>0;
    }
    //fetchAll
    public Cursor fetchAllTeacher() {
        return database.query(DB_TABLE, new String[] {TB_F7,TB_F2,TB_F3,TB_F6},null,null,null,null,null);
    }
    //fetchById
    public Cursor fetchTeacherById(String id_teacher) {
        Cursor c = database.query(DB_TABLE, new String[] {TB_F7,TB_F2,TB_F3,TB_F6},TB_F1_PK+"="+id_teacher,null,null,null,null);
        return c;
    }
}
