package it.rizzoli.RED.Student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.R;

public class StudentShowStudentTeacherAdapter extends RecyclerView.Adapter<CardViewHolderShowStudentTeacher> {

    List<Student> items;

    public StudentShowStudentTeacherAdapter(List<Student> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderShowStudentTeacher onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_show_student_teacher_recyclerview, parent, false);
        return new CardViewHolderShowStudentTeacher(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderShowStudentTeacher holder, int position){
        holder.textViewEmail.setText(items.get(position).getInstitutional_email());
        holder.textViewFirstName.setText(items.get(position).getFirst_name());
        holder.textViewLastName.setText(items.get(position).getLast_name());
    }

    @Override
    public int getItemCount(){
        return items.size();
    }
}

class CardViewHolderShowStudentTeacher extends RecyclerView.ViewHolder{
    TextView textViewFirstName;
    TextView textViewLastName;
    TextView textViewEmail;

    private StudentShowStudentTeacherAdapter adapter;

    public  CardViewHolderShowStudentTeacher(@NonNull View itemView){
     super(itemView);
     textViewEmail = itemView.findViewById(R.id.email);
     textViewFirstName = itemView.findViewById(R.id.first_name);
     textViewLastName = itemView.findViewById(R.id.last_name);
    }

    public CardViewHolderShowStudentTeacher linkAdapter(StudentShowStudentTeacherAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
}
