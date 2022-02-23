package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;

public class DbAdapterCourse {

    private static final String LOG_TAG = DbAdapterCourse.class.getSimpleName();
    private Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    ContentValues values;

    //dbCourseField
    private static final String DB_TABLE="course";

    private static final String TB_F1_PK="id_course";
    private static final String TB_F2="name";
    private static final String TB_F3="start_date";
    private static final String TB_F4_FK="institution_id_institution";

    public DbAdapterCourse(Context context) {
        this.context = context;
    }

    public DbAdapterCourse open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValue(String type_of_course, String name, Date start_date, int institution_id_institution) {
        ContentValues cv = new ContentValues();

        cv.put(TB_F2,name);
        cv.put(TB_F3, String.valueOf(start_date));
        cv.put(TB_F4_FK,institution_id_institution);

        return  cv;
    }

    //create course
    public long createCourse(String type_of_course, String name, Date start_date, int institution_id_institution) {
        values = createContentValue(type_of_course, name,  start_date,  institution_id_institution);
        return  database.insertOrThrow(DB_TABLE,null,values);
    }
    //update
    public boolean updateCourse(long id_course,String type_of_course, String name, Date start_date, int institution_id_institution){
        values = createContentValue(type_of_course, name,  start_date,  institution_id_institution);
        return database.update(DB_TABLE,values,TB_F1_PK+"="+id_course,null)>0;
    }

    //delete
    public boolean deleteCourse(long id_course) {
        return  database.delete(DB_TABLE,TB_F1_PK+"="+id_course,null)>0;
    }
    //fetchAll
    public Cursor fetchAllCourse() {
        return database.query(DB_TABLE,new String[] {TB_F1_PK,TB_F2,TB_F3,TB_F4_FK},null,null,null,null,null);
    }

    //fetch inst by String
    public Cursor fetchCourseByFilterName(String filter) {
        Cursor cursor = database.query(DB_TABLE,new String[] {TB_F1_PK,TB_F2,TB_F3,TB_F4_FK},TB_F2 + "like '%"+filter+"%'",null,null,null,null,null);
        return  cursor;
    }

}
