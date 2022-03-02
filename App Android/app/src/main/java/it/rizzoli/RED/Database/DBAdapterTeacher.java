package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAdapterTeacher {

    private static final String LOG_TAG = DbAdapterInstitution.class.getSimpleName();
    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    Connection connection = null;
    private final ConnectionHelper connectionHelper = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement st = null;
    private static final String DB_TABLE = "teacher";

    private static final String TB_F1_PK = "id_teacher";
    private static final String TB_F2 = "first_name";
    private static final String TB_F3 = "last_name";
    private static final String TB_F4 = "phone_number";
    private static final String TB_F5 = "personal_email";
    private static final String TB_F6 = "institutional_email";
    private static final String TB_F7 = "photo";
    private static final String TB_F8 = "password";

    public DBAdapterTeacher(Context context) {

        this.context = context;
       // dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValue(String first_name, String last_name,
                                             String phone_number, String personal_email, String istitutional_email,
                                             String photo, String password) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TB_F2, first_name);
        contentValues.put(TB_F3, last_name);
        contentValues.put(TB_F4, phone_number);
        contentValues.put(TB_F5, personal_email);
        contentValues.put(TB_F6, istitutional_email);
        contentValues.put(TB_F7, photo);
        contentValues.put(TB_F8, password);

        return contentValues;
    }

    //create

    public long createTeacher(String first_name, String last_name,
                              String phone_number, String personal_email, String istitutional_email,
                              String photo, String password) {
        ContentValues contentValues = createContentValue(first_name, last_name, phone_number, personal_email, istitutional_email, photo, password);

        return database.insertOrThrow(DB_TABLE, null, contentValues);
    }

    //update
    public boolean updateTeacher(long id_teacher, String first_name, String last_name,
                                 String phone_number, String personal_email, String istitutional_email,
                                 String photo, String password) {
        ContentValues contentValues = createContentValue(first_name, last_name,
                phone_number, personal_email, istitutional_email,
                photo, password);

        return database.update(DB_TABLE, contentValues, TB_F1_PK + "=" + id_teacher, null) > 0;
    }

    //delete
    public boolean deleteTeacher(long id_teacher) {
        return database.delete(DB_TABLE, TB_F1_PK + "=" + id_teacher, null) > 0;
    }

    //fetchAll
    public Cursor fetchAllTeacher() {
        return database.query(DB_TABLE, new String[]{TB_F7, TB_F2, TB_F3, TB_F6}, null, null, null, null, null);
    }

    //fetchById
    public Cursor fetchTeacherById(String id_teacher) {
        return database.query(DB_TABLE, new String[]{TB_F7, TB_F2, TB_F3, TB_F6}, TB_F1_PK + "=" + id_teacher, null, null, null, null);
    }



        public boolean Login (String email_db, String psw_db) throws java.sql.SQLException, SQLException  {
            String sql = "select * from "+DB_TABLE+" where institutional_email = ? and password=?";
            Cursor c = database.rawQuery(sql, new String[]{email_db, psw_db});

            if (c.getCount() <= 0) {
                Log.e("Info", "Non esiste nessuno docente del dbInterno");

                try {
                    connection = ConnectionHelper.getInstance().getConnection();
                    //database esterno
                    ps = connection.prepareStatement(sql);

                    ps.setString(1, email_db);
                    ps.setString(2, psw_db);
                    //select dbEsterno
                    rs = ps.executeQuery();

                    if (rs.first() && rs.getFetchSize() >= 1) {
                        DBAdapterTeacher newTeacher = new DBAdapterTeacher(context);
                        Log.e("Info", "rs != null");
                        while (rs.next()) {
                            TeacherBean teacherBean = new TeacherBean();

                            teacherBean.setFirstName(rs.getString("first_name"));
                            teacherBean.setLast_name(rs.getString("last_name"));
                            teacherBean.setPersonal_email(rs.getString("personal_email"));
                            teacherBean.setInstitutional_email(rs.getString("institutional_email"));
                            teacherBean.setPhoto(rs.getString("photo"));
                            teacherBean.setPassword(rs.getString("password"));

                            newTeacher.createContentValue(teacherBean.getFirstName(), teacherBean.getLast_name(),
                                    teacherBean.getPhone_number(), teacherBean.getPersonal_email(),
                                    teacherBean.getInstitutional_email(),
                                    teacherBean.getPhoto(), teacherBean.getPassword()
                            );

                        }
                        return true;
                    } else {
                        Log.e("Info", "rs = 0");
                        return false;
                    }

                } catch (SQLException exception) {
                    Log.e("Info", "ErroreLogin");
                    exception.printStackTrace();
                }
            } else {
                c.close();
                Log.e("Info", "Login Failed");
                return true;
            }
            Log.e("Info", "Login Failed 1");
            return false;
        }

    }

