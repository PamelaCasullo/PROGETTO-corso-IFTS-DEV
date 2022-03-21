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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_student_teacher_recyclerview, parent, false);
        return new CardViewHolderShowStudentTeacher(view).linkAdapter();
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderShowStudentTeacher holder, int position){
        holder.textViewEmail.setText(items.get(position).getInstitutional_email());
        holder.textViewFirstNameLastName.setText(String.format("%s %s", items.get(position).getFirst_name(), items.get(position).getLast_name()));
        holder.textViewPhonenumber.setText(items.get(position).getPhone_number());
    }

    @Override
    public int getItemCount(){
        return items.size();
    }
}

class CardViewHolderShowStudentTeacher extends RecyclerView.ViewHolder{
    TextView textViewFirstNameLastName;
    TextView textViewEmail;
    TextView textViewPhonenumber;

    public  CardViewHolderShowStudentTeacher(@NonNull View itemView){
        super(itemView);
        textViewEmail = itemView.findViewById(R.id.email);
        textViewFirstNameLastName = itemView.findViewById(R.id.first_name_last_name);
        textViewPhonenumber = itemView.findViewById(R.id.phone_number);
    }

    public CardViewHolderShowStudentTeacher linkAdapter() {
        return this;
    }
}
