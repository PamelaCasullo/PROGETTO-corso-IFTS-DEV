package it.rizzoli.RED;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewVotoDocenteAdapter extends ArrayAdapter<VoteDocente> {
    Context ctx = null;
    int res = 0;
    ArrayList<VoteDocente> votiDocente = new ArrayList<>();

    public class viewHolder {
        TextView dataTextView;
        TextView nome_cognomeTextView;
        TextView materiaTextView;
        TextView votoTextView;
    }

    public ListViewVotoDocenteAdapter(Context context, int resource, VoteDocente[] object) {
        super(context, resource, object);
        ctx = context;
        res = resource;
        for (int i = 0; i < object.length; i++)
            votiDocente.add(object[i]);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(res, parent, false);

            viewHolder vh = new viewHolder();
            vh.dataTextView = convertView.findViewById(R.id.data);
            vh.nome_cognomeTextView = convertView.findViewById(R.id.nome_cognome);
            vh.materiaTextView = convertView.findViewById(R.id.materia);
            vh.votoTextView = convertView.findViewById(R.id.voto);
            convertView.setTag(vh);
        }
        viewHolder vh = (viewHolder) convertView.getTag();
        VoteDocente i = getItem(position);
        vh.dataTextView.setText(i.data);
        vh.nome_cognomeTextView.setText(i.nome_cognome);
        vh.materiaTextView.setText(i.materia);
        vh.votoTextView.setText(""+i.voto);

        return convertView;
    }
}
