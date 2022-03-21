package it.rizzoli.RED.Student;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import it.rizzoli.RED.R;

public class StudentCalendarAdapter extends RecyclerView.Adapter<CardViewHolderLesson> {

    List<RecyclerViewLesson> items;

    public StudentCalendarAdapter(List<RecyclerViewLesson> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderLesson onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_lesson_recyclerview, parent, false);
        return new CardViewHolderLesson(view).linkAdapter();
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderLesson holder, int position) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(items.get(position).getDate());
        holder.textViewDate.setText(strDate);
        holder.textViewTitle.setText(items.get(position).getTitle());
        holder.textViewFirstNameLastName.setText(String.format("%s %s", items.get(position).getFirst_name(), items.get(position).getLast_name()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class CardViewHolderLesson extends RecyclerView.ViewHolder{

    TextView textViewDate;
    TextView textViewTitle;
    TextView textViewFirstNameLastName;

    public CardViewHolderLesson(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
        textViewFirstNameLastName = itemView.findViewById(R.id.first_name_last_name);
    }

    public CardViewHolderLesson linkAdapter(){
        return this;
    }
}


