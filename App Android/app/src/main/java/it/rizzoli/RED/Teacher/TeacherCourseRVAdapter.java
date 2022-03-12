package it.rizzoli.RED.Teacher;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.rizzoli.RED.R;
import it.rizzoli.RED.UpdateCourseActivity;

public class TeacherCourseRVAdapter extends RecyclerView.Adapter<TeacherCourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private final ArrayList<TeacherCourseModal> teacherCourseModalArrayList;
    private final Context context;

    // constructor
    public TeacherCourseRVAdapter(ArrayList<TeacherCourseModal> teacherCourseModalArrayList, Context context) {
        this.teacherCourseModalArrayList = teacherCourseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        TeacherCourseModal modal = teacherCourseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseDurationTV.setText(modal.getCourseDuration());
        holder.courseTracksTV.setText(modal.getCourseTracks());
        holder.courseDescTV.setText(modal.getCourseDescription());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(v -> {

            // on below line we are calling an intent.
            Intent i = new Intent(context, UpdateCourseActivity.class);

            // below we are passing all our values.
            i.putExtra("name", modal.getCourseName());
            i.putExtra("duration", modal.getCourseDuration());
            i.putExtra("tracks", modal.getCourseTracks());
            i.putExtra("description", modal.getCourseDescription());

            // starting our activity.
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return teacherCourseModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private final TextView courseNameTV;
        private final TextView courseDescTV;
        private final TextView courseDurationTV;
        private final TextView courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDurationTV = itemView.findViewById(R.id.nome_cognomeset);
            courseTracksTV = itemView.findViewById(R.id.moduloset);
            courseDescTV = itemView.findViewById(R.id.votoset);
        }
    }
}
