package it.rizzoli.RED.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.io.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbAdapterStudent {

    private static final String LOG_TAG = DbAdapterStudent.class.getSimpleName();

    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private ConnectionHelper connectionHelper;
    Connection connection;
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
    private static final String DB_TABLE = "student";

    private static final String TB_F1_PK = "id_student";
    private static final String TB_F2 = "first_name";
    private static final String TB_F3 = "last_name";
    private static final String TB_F4 = "date_of_birth";
    private static final String TB_F5 = "phone_number";
    private static final String TB_F6 = "personal_email";
    private static final String TB_F7 = "institutional_email";
    private static final String TB_F8 = "photo";
    private static final String TB_F9 = "password";

    public DbAdapterStudent(Context context) throws SQLException {
        this.context = context;
        //dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValue(String first_name, String last_name, Date date_of_birth,
                                             String phone_number, String personal_email, String institutional_email,
                                             String photo, String password) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TB_F2, first_name);
        contentValues.put(TB_F3, last_name);
        contentValues.put(TB_F4, date_of_birth.getTime());
        contentValues.put(TB_F5, phone_number);
        contentValues.put(TB_F6, personal_email);
        contentValues.put(TB_F7, institutional_email);
        contentValues.put(TB_F8, photo);
        contentValues.put(TB_F9, password);


        return contentValues;

    }
//create

    public long createStudent(String first_name, String last_name, Date date_of_birth,
                              String phone_number, String personal_email, String institutional_email,
                              String photo, String password) throws SQLException, java.sql.SQLException {
        ContentValues cv = createContentValue(first_name, last_name, date_of_birth, phone_number, personal_email, institutional_email, photo, password);
        String sql = "insert into " + DB_TABLE + " (first_name,last_name,phone_number,personal_email,institutional_email,photo,password) values (?,?,?,?,?,?,?)";
        rs = st.executeQuery(sql);

        try (Connection connection = connectionHelper.connectionClass();) {
            ps = connection.prepareCall(sql);

            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, String.valueOf(date_of_birth));
            ps.setString(4, phone_number);
            ps.setString(5, personal_email);
            ps.setString(6, institutional_email);
            ps.setString(7, photo);
            ps.setString(8, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return database.insertOrThrow(DB_TABLE, null, cv);
    }

    //update
    public boolean updateStudent(long id_student, String first_name, String last_name, Date date_of_birth,
                                 String phone_number, String personal_email, String institutional_email,
                                 String photo, String password) {
        ContentValues cv = createContentValue(first_name, last_name, date_of_birth,
                phone_number, personal_email, institutional_email,
                photo, password);

        return database.update(DB_TABLE, cv, TB_F1_PK + "=" + id_student, null) > 0;
    }

    //delete
    public boolean deleteStudent(long id_student) {
        return database.delete(DB_TABLE, TB_F1_PK + "=" + id_student, null) > 0;
    }

    //fetchAll
    public Cursor fetchAllStudent() {
        return database.query(DB_TABLE, new String[]{TB_F8, TB_F2, TB_F3, TB_F7, TB_F5}, null, null, null, null, null);
    }

    //fetchById
    public Cursor fetchStudentById(String id_student) {
        return database.query(DB_TABLE, new String[]{TB_F8, TB_F2, TB_F3, TB_F7, TB_F5}, TB_F1_PK + "=" + id_student, null, null, null, null);
    }

    public boolean Login(String email_db, String psw_db) throws SQLException, java.sql.SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + DB_TABLE + " WHERE institutional_email=? AND password=? ";
        Cursor c = database.rawQuery(sql, new String[]{email_db, psw_db});

        //doRetrieveByLogin

        if (c.getCount() <= 0) {
            Toast.makeText(context, "test1Login", Toast.LENGTH_SHORT).show();
            try (Connection conn = connectionHelper.connectionClass()) {

                ps = conn.prepareStatement(sql);
                ps.setString(1, email_db);
                ps.setString(2, psw_db);

                System.out.print("Login Studente" + ps.toString());

                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    DbAdapterStudent newStudent = new DbAdapterStudent(context);
                    while (rs.next()) {
                        StudentBean studentBean = new StudentBean();

                        studentBean.setFirstName(rs.getString("first_name"));
                        studentBean.setLast_name(rs.getString("last_name"));
                        studentBean.setPersonal_email(rs.getString("personal_email"));
                        studentBean.setInstitutional_email(rs.getString("institutional_email"));
                        studentBean.setPhoto(rs.getString("photo"));
                        studentBean.setPassword(rs.getString("password"));
                        studentBean.setDate_of_birth(rs.getDate("date_of_birth"));

                        newStudent.createContentValue(studentBean.getFirstName(), studentBean.getLast_name(), studentBean.getDate_of_birth(),
                                studentBean.getPhone_number(), studentBean.getPersonal_email(), studentBean.getInstitutional_email(),
                                studentBean.getPhoto(), studentBean.getPassword()
                        );

                    }
                    return true;
                } else return false;
            }
        }
        if (c.getCount() > 0) {
            c.close();
            Toast.makeText(context, "test2Login", Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context, "sono uscito", Toast.LENGTH_SHORT).show();
        return false;
    }

}
