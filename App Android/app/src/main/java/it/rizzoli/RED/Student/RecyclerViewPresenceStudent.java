package it.rizzoli.RED.Student;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecyclerViewPresenceStudent implements Serializable {

    @SerializedName("presence")
    @Expose
    private boolean presence;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;

    public RecyclerViewPresenceStudent(boolean presence, String title, String date) {
        this.presence = presence;
        this.title = title;
        this.date = date;
    }

    public boolean getPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
