package it.rizzoli.RED.Student;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.R;

public class StudentVoteAdapter extends RecyclerView.Adapter<CardViewHolderVote> {

    List<RecyclerViewVote> items;

    public StudentVoteAdapter(List<RecyclerViewVote> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderVote onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_vote_recyclerview, parent, false);
        return new CardViewHolderVote(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderVote holder, int position) {
        holder.textViewDate.setText(items.get(position).getDate());
        holder.textViewTitle.setText(items.get(position).getTitle());
        holder.textViewVote.setText("" + items.get(position).getGrade());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
class CardViewHolderVote extends RecyclerView.ViewHolder{

    TextView textViewDate;
    TextView textViewTitle;
    TextView textViewVote;

    private StudentVoteAdapter adapter;

    public CardViewHolderVote(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
        textViewVote = itemView.findViewById(R.id.vote);
    }

    public CardViewHolderVote linkAdapter(StudentVoteAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
