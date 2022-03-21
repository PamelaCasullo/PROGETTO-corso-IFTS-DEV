package it.rizzoli.RED.Teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.Connection.Student;
import it.rizzoli.RED.R;

public class TeacherShowStudentsAdapter extends RecyclerView.Adapter<CardViewHolderShowStudents> {

    List<Student> items;

    public TeacherShowStudentsAdapter(List<Student> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderShowStudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_students_recyclerview, parent, false);
        return new CardViewHolderShowStudents(view).linkAdapter();
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderShowStudents holder, int position){
        holder.textViewFirstNameLastName.setText(String.format("%s %s", items.get(position).getFirst_name(), items.get(position).getLast_name()));
    }

    @Override
    public int getItemCount(){
        return items.size();
    }
}

class CardViewHolderShowStudents extends RecyclerView.ViewHolder{
    TextView textViewFirstNameLastName;

    public  CardViewHolderShowStudents(@NonNull View itemView){
        super(itemView);
        textViewFirstNameLastName = itemView.findViewById(R.id.first_name_last_name);
    }

    public CardViewHolderShowStudents linkAdapter() {
        return this;
    }
}
