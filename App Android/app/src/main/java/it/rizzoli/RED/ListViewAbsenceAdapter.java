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

public class ListViewAbsenceAdapter extends ArrayAdapter<Absence> {
    Context ctx = null;
    int res = 0;
    ArrayList<Absence> absence = new ArrayList<>();

    public class viewHolder {
        TextView dataTextView;
        TextView nome_cognomeTextView;
        TextView presenteTextView;
        TextView ritardoTextView;
        TextView assenteTextView;
    }

    public ListViewAbsenceAdapter(Context context, int resource, Absence[] object) {
        super(context, resource, object);
        ctx = context;
        res = resource;
        for (int i = 0; i < object.length; i++)
            absence.add(object[i]);
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
            vh.presenteTextView = convertView.findViewById(R.id.presente);
            vh.ritardoTextView = convertView.findViewById(R.id.ritardo);
            vh.assenteTextView = convertView.findViewById(R.id.assente);
            convertView.setTag(vh);
        }
        viewHolder vh = (viewHolder) convertView.getTag();
        Absence p = getItem(position);
        vh.dataTextView.setText(p.data);
        vh.nome_cognomeTextView.setText(p.nome_cognome);
        vh.presenteTextView.setText(p.presente);
        vh.ritardoTextView.setText(p.ritardo);
        vh.assenteTextView.setText(p.assente);

        return convertView;
    }
}