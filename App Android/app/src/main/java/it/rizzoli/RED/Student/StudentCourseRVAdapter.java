package it.rizzoli.RED.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.rizzoli.RED.R;

public class StudentCourseRVAdapter extends RecyclerView.Adapter<StudentCourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<StudentCourseModal> studentCourseModalArrayList;
    private Context context;

    // constructor
    public StudentCourseRVAdapter(ArrayList<StudentCourseModal> studentCourseModalArrayList, Context context) {
        this.studentCourseModalArrayList = studentCourseModalArrayList;
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
        StudentCourseModal modal = studentCourseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseDurationTV.setText(modal.getCourseDuration());
        holder.courseTracksTV.setText(modal.getCourseTracks());
        holder.courseDescTV.setText(modal.getCourseDescription());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return studentCourseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

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
