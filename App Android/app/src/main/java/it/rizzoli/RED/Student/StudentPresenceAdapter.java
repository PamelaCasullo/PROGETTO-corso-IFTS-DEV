package it.rizzoli.RED.Student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.R;

public class StudentPresenceAdapter extends RecyclerView.Adapter<CardViewHolderPresence> {

    List<RecyclerViewPresence> items;

    public StudentPresenceAdapter(List<RecyclerViewPresence> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderPresence onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_presence_recyclerview, parent, false);
        return new CardViewHolderPresence(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderPresence holder, int position) {
        holder.textViewDate.setText(items.get(position).getDate());
        holder.textViewTitle.setText(items.get(position).getTitle());
        if(items.get(position).getPresence()){
            holder.textViewPresence.setText("Presente");
        } else {
            holder.textViewPresence.setText("Assente");
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class CardViewHolderPresence extends RecyclerView.ViewHolder{

    TextView textViewDate;
    TextView textViewTitle;
    TextView textViewPresence;

    private StudentPresenceAdapter adapter;

    public CardViewHolderPresence(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
        textViewPresence = itemView.findViewById(R.id.presence);
    }

    public CardViewHolderPresence linkAdapter(StudentPresenceAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
