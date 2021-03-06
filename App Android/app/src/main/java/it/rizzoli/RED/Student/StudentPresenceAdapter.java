package it.rizzoli.RED.Student;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.rizzoli.RED.R;

public class StudentPresenceAdapter extends RecyclerView.Adapter<CardViewHolderPresence> {

    List<RecyclerViewPresenceStudent> items;

    public StudentPresenceAdapter(List<RecyclerViewPresenceStudent> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolderPresence onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_presence_recyclerview, parent, false);
        return new CardViewHolderPresence(view).linkAdapter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolderPresence holder, int position) {
        holder.textViewDate.setText(items.get(position).getDate());
        holder.textViewTitle.setText(items.get(position).getTitle());
        if(items.get(position).getPresence()){
            holder.textViewPresence.setText("Presente");
            holder.textViewPresence.setTextColor(0xFF00FF00);
        } else {
            holder.textViewPresence.setText("Assente");
            holder.textViewPresence.setTextColor(0xFFFF0000);
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

    public CardViewHolderPresence(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.date);
        textViewTitle = itemView.findViewById(R.id.title);
        textViewPresence = itemView.findViewById(R.id.presence);
    }

    public CardViewHolderPresence linkAdapter(){
        return this;
    }
}
