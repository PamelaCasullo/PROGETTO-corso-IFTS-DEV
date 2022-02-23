package it.rizzoli.RED.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RED";
    private static final int DATABASE_VERSION= 1;

    //statement creation db
    private static final String DATABASE_CREATE_T_INSTITUTION ="create table institution(_id_institution integer primary key autoincrement ," +
            "id_institution INT(11) NOT NULL ," +
            "name VARCHAR(50) NOT NULL);";
    private static final String DATABASE_CREATE_T_TEACHER ="create table teacher(_id_teacher integer primary key autoincrement," +
            "id_teacher INT(11) NOT NULL ," +
            "  `first_name` VARCHAR(50) NOT NULL,\n" +
            "  `last_name` VARCHAR(50) NOT NULL,\n" +
            "  `phone_number` VARCHAR(15) NOT NULL,\n" +
            "  `personal_email` VARCHAR(320) NOT NULL,\n" +
            "  `institutional_email` VARCHAR(320) NOT NULL," +
            " `photo` TEXT DEFAULT 'UklGRvwHAABXRUJQVlA4IPAHAAAwYQCdASrCAcIBPlEokkYjoqGhJDjoKHAKCWlu7mB0ycc+3LPaP+GOTy+5/T/OPgYsHrjbRjsr/hOPIe6+n8Hv6nXqT13/4FAEaZ+GMMYYwxhjDGGMMYYwxhjDGGMMYYwxhjDGGMMXeP+c8tZDU+N5OKi8kaf7P5NCjLgjTPwxhi7wA8d1yOZ//bcUkbMVnwwV78D3yhSC37snZOydk6M8S8nTfm68Lzurn4nzFZhBMfCZvQIU6qMA/11D28Vl1me7J2Tsl8RDrhYLpzSbmhDbfMxj1Mul3X/JOAd50t/64xQ1/dPn0OmUZcEaZSCt9rwExYJ3DsmZSGtNwCLrPfGebhVQi2HRKAQmRlwAxG8n5EKDyw/C/8KRGXBBvphwcva1KbpUwWEgIzIELDn2rRR+W2QgJAMbuANFeExqx6hVrlBGkW1FgZSZrVin6FxWJ2TpS9o/fbBNLRfDy5e4CPy3fk1NkwsO7Zh7snSfuOmXWLC9oh/n5kXrqE1aDKKYre87bMjLZsVKgrBkeJA1uHxjIuphqtSoaa+e3IyuWmfd5kJshayQA7BsReN5R2IPdi1Pc0mAoy4APqfZZdGUn3EBCdZrZhuqfLS+d52YUvDdPVmLwFAxJh1i6ejTWzD02FmlxH/q0Thm90bbZWd2MuAP1j9fH2LTPAepR+EzerQdgQ8GkhAoWdY6szWHIzBTIuvA6zsDbDGItM48SFc9aJH4UKt3vGMeZGUmfbc35R919KOSBpr6K/oxxDwai3Jib2mRdJ8bFP7o1RAr5OGubJb2QC7Jr0Rsc9iwEra3yayXEeV8gd2NVqTD//c7h4g9kZbNJum+0vUZPown+oskWnlTrHWOyjrw4ezVTdP/p1dn+EIzrIEgJForfOMarsBlJhlG4VYT9uRmYwxdjT1XPWaA5ZxsCQEgJRLikxq2OdC4YwxhjDGGMMYYwxhjkXWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOsdY6x1jrHWOrAAA/v2MAAAAAD5YH0rBNZ1vQTR1wxC1lunlj713bR8uzLidFvcmXSBbHK93K58hW7eosB+U1BbhUn8AbzIvCjDN+eKGxouI5/HFERlHLAOxi+UStMFAhsEZAw2oqySTd0aK55h04CjWSAkK+/aqMcVuNIhWiYM6WdjlVgYb21H2q108vpL/yzcSvmO+3s9I/Vv/wHz4BN0nXdg/vvd/GLW5Y7alR3OQjKQMp3Pb18+dSyzbssJksZytPvc+N4zC4NGCItvQhW9mLmcRRXeN+GQwMqxeBOPUvFO5Uo9J1g+YVYh2q/tcm89VIaqlgwrZMnmR/goEoJj71pIIk6ezliJx/EzZPpzyN2rfesUq8ucWFK9I9JpewvH4q2BfqxmIKMbYJ/vbHWwojyeKcnXjOXbLhMUNpSqBxolsoiuEzqFHFTGz3Dv96+JSYt6QxPmnLj3CsbE86a0o7qtPuvHyyBdUVUXwWBFJVOIZSKpOS3FCYfLq5GzbfboDNWoQq/MYye7/i8NS+XLky86cVJDHOjW/SP1Nyk1gAseP5wL4oVa396Rm0QhtxDcHzZ5P63uyBBNj9keIxZN78jV8//ushQPARt41YkGFCRmimERlQYBBtUoeqZZJmkK3UFe4Avh3ILBD1L8LGtMFPDiTgXHidb7tgRiLB3kE+ZCex4M6uFyPxxFEIvuA1GmGGwtB0Z+1/HjPPgUznIU3hnPgM4WBvjHJxQlzjgON1udkGEIHmR3Qv70pNIht3zrY9EkmVpkENtAkWB7ZdITiwaJUcOSMgpx0ClF9RbHhTvX4Djv4HC45duJmh06Hcr+7DMf/NbzDowObfUYYwVS9x5GBp2wLE+AuwGMdMkRdmfHcm5jRb6+F9kuwMDlbIKqZik2vjaFcPLZSfEasW4hJ02lPneZoLS8ifNcTcxtFIvwohZS52ony8V51iMcdofFQ1RnjgT3EFEW2hbiApye+eL44YSW+0Lea6WBTDQWpFPvpS+cdxmv/xF7vqDZvla1uJAo2ulBENhY9Sxxa3drW9xKHdfrEaWxPC1+po970U/5pPztUkpkWopHfAQy7xtqOAqqpewvaRpo71W75mdzckR2PnHab1x50xfDBy+MOFgr+wIQJ4/8E7GEHTgtGBNCoSXnJ/FscZmdEnAdnxahMoziCjXpU64s2Kh3LJWIa+pFT+JsR1nGuvj7nxn6NwsnLDAj3iaAkS4hlsv6tX3h0eBi56TqkWj53oLH3uYF5UZLOyfeGspFF9Fa7/kUT+5MynDFtDMFtmzXeUXmxX2Rm+iEJ1N7GVeSaM7KHxtI9QIdlAM33czseeFixkWMBdOrnjkn4hO0id9IIIwHMB4BrPuDKdwp9+NcVEP7WuV/dEwLiIAeYZNaRJ0WtbCnzjzEOA7/XPd3FSQG935/lVorP5jK5Ticc7huzyCxWhxe8KpRcI93Mwd9AI/+pJ24lbqEzzjTMmVs9DK/iaxUzjuqfHBjsmueJvHZjBnhNupo67embFUktWG5lYwar9Pb+HlVOcB7Tx7FQ5A7IG9Xli6I5T+gPHGlXebmHI89QzGuAPUuFhtTPhFk4zwJsOsP/Y0GEfaVqyo/kgIh1uShdiym6hmODnIoPoUObeZXhsIrgnKikWwBWZFfzvigAAAAAAAAAAAAAAAAA'," +
            "  `password` VARCHAR(256) NOT NULL);";
    private static final String DATABASE_CREATE_T_STUDENT ="create table student(_id_student integer primary key autoincrement," +
            " `id_student` INT(11) NOT NULL ," +
            "  `first_name` VARCHAR(50) NOT NULL," +
            "  `last_name` VARCHAR(50) NOT NULL," +
            "  `date_of_birth` DATE NOT NULL," +
            "  `phone_number` VARCHAR(15) NOT NULL," +
            "  `personal_email` VARCHAR(320) NOT NULL," +
            "  `institutional_email` VARCHAR(320) NOT NULL," +
            "  `photo` TEXT  DEFAULT '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'," +
            "  `password` VARCHAR(256) NOT NULL);";
    private static final String DATABASE_CREATE_T_LESSON ="create table lesson(_id_lesson integer primary key autoincrement," +
            "`id_lesson` INT(11) NOT NULL ," +
            "  `presence` TINYINT(4) NOT NULL," +
            "  `grade` INT(11)  DEFAULT NULL," +
            "  `agenda_id_agenda` INT(11) NOT NULL," +
            "  `student_id_student` INT(11) NOT NULL," +
            " FOREIGN KEY (`agenda_id_agenda`)" +
            "    REFERENCES agenda (`id_agenda`)," +
            "  FOREIGN KEY (`student_id_student`)\n" +
            "    REFERENCES student (`id_student`));";
    private static final String DATABASE_CREATE_T_MODULE ="create table module(_id_module integer primary key autoincrement," +
            " id_module INT(11) NOT NULL ,\n" +
            "  title VARCHAR(50)  DEFAULT NULL,\n" +
            "  program VARCHAR(1000)  DEFAULT NULL,\n" +
            "  duration INT(11)  DEFAULT NULL,\n" +
            "  course_id_course INT(11) NOT NULL,\n" +
            "  FOREIGN KEY (course_id_course)" +
            "  REFERENCES course (id_course));";
    private static final String DATABASE_CREATE_T_COURSE ="create table course(_id_course integer primary key autoincrement," +
            " id_course INT(11) NOT NULL, " +
            " type_of_course CHAR(4)  DEFAULT NULL ," +
            " name VARCHAR(50)  DEFAULT NULL ," +
            " start_date DATE DEFAULT NULL ," +
            " institution_id_institution INT(11) NOT NULL ," +
            " FOREIGN KEY (institution_id_institution)" +
            " REFERENCES institution(id_institution));";
    private static final String DATABASE_CREATE_T_AGENDA ="create table agenda(_id_agenda integer primary key autoincrement," +
            " id_agenda INT(11) NOT NULL," +
            "  date DATE NOT NULL," +
            "  description VARCHAR(1000) NOT NULL," +
            " module_id_module INT(11) NOT NULL," +
            "  teacher_id_teacher INT(11) NOT NULL," +
            " FOREIGN KEY (module_id_module)" +
            " REFERENCES module (id_module)," +
            " FOREIGN KEY (teacher_id_teacher)" +
            " REFERENCES teacher (id_teacher));";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_T_INSTITUTION);
        db.execSQL(DATABASE_CREATE_T_COURSE);
        db.execSQL(DATABASE_CREATE_T_STUDENT);
        db.execSQL(DATABASE_CREATE_T_MODULE);
        db.execSQL(DATABASE_CREATE_T_TEACHER);
        db.execSQL(DATABASE_CREATE_T_AGENDA);
        db.execSQL(DATABASE_CREATE_T_LESSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

        db.execSQL("DROP TABLE if exists institution");
        onCreate(db);
    }
}
