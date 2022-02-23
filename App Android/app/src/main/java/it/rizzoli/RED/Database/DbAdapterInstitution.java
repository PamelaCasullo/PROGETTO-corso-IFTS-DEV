package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

public class DbAdapterInstitution {


    private static final String LOG_TAG = DbAdapterInstitution.class.getSimpleName();
    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    //dbCourseField
    private static final String DB_TABLE="institution";

    private static final String TB_F1_PK="id_institution";
    private static final String TB_F2="name";

    public DbAdapterInstitution(Context context) {
        this.context = context;
    }

    public DbAdapterInstitution open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    @NonNull
    private ContentValues createContentValue(String name) {
        ContentValues cv = new ContentValues();

        cv.put(TB_F2,name);

        return  cv;
    }

    //create
    public long createInstitution(String name) {
        ContentValues inValue = createContentValue(name);
        return database.insertOrThrow(DB_TABLE,null,inValue);
    }
    //update
    public boolean updateInstitution(long id_institution, String name) {
        ContentValues cv = createContentValue(name);
        return database.update(DB_TABLE,cv,TB_F1_PK+"="+id_institution,null)>0;
    }
    //delete
    public boolean deleteInstitution(long id_institution ) {
        return database.delete(DB_TABLE,TB_F1_PK+"="+id_institution, null)>0;
    }
    //fetchAll
    public Cursor fetchAllInstitution() {
        return database.query(DB_TABLE,new String[] {TB_F1_PK,TB_F2},null,null,null,null,null);
    }

    //fetch inst by String

    public Cursor fetchInstitutionsByFilter(String filter) {
        Cursor cursor = database.query(DB_TABLE,new String[] {TB_F1_PK,TB_F2},TB_F2 + "like '%"+filter+"%'",null,null,null,null,null);
        return  cursor;
    }

}
