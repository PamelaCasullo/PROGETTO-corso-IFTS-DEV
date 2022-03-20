package it.rizzoli.RED.Student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.R;

public class StudentPresenceAdapter extends RecyclerView.Adapter<CardViewHolder> {

    List<Presence> items;

    public StudentPresenceAdapter(List<Presence> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_presence_listview, parent, false);
        return new CardViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
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

class CardViewHolder extends RecyclerView.ViewHolder{

    TextView textViewDate;
    TextView textViewTitle;
    TextView textViewPresence;

    private StudentPresenceAdapter adapter;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
        textViewPresence = itemView.findViewById(R.id.presence);
    }

    public CardViewHolder linkAdapter(StudentPresenceAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
