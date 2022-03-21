package it.rizzoli.RED.Teacher;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.R;

public class TeacherLessonAdapter extends RecyclerView.Adapter<CardViewHolderLesson>{
    List<RecyclerViewShowLessonTeacher> items;

    public TeacherLessonAdapter(List<RecyclerViewShowLessonTeacher> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderLesson onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_lesson_recyclerview, parent, false);
        return new CardViewHolderLesson(view).linkAdapter();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolderLesson holder, int position) {
        holder.textViewDate.setText(items.get(position).getDate());
        holder.textViewTitle.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
class CardViewHolderLesson extends RecyclerView.ViewHolder{

    TextView textViewDate;
    TextView textViewTitle;

    public CardViewHolderLesson(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
    }

    public CardViewHolderLesson linkAdapter(){
        return this;
    }
}
