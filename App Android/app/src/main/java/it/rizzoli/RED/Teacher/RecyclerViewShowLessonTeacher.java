package it.rizzoli.RED.Teacher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RecyclerViewShowLessonTeacher {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("title")
    @Expose
    private String title;

    public RecyclerViewShowLessonTeacher(String date, String title) {
        this.date=date;
        this.title=title;

    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

}
