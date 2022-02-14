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

public class ListViewComunicazioniAdapter extends ArrayAdapter<Communication> {
    Context ctx = null;
    int res = 0;
    ArrayList<Communication> communications = new ArrayList<>();

    public class viewHolder {
        TextView dataTextView;
        TextView comunicationTextView;
    }

    public ListViewComunicazioniAdapter(Context context, int resource, Communication[] object) {
        super(context, resource, object);
        ctx = context;
        res = resource;
        for (int i = 0; i < object.length; i++)
            communications.add(object[i]);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(res, parent, false);

            ListViewComunicazioniAdapter.viewHolder vh = new ListViewComunicazioniAdapter.viewHolder();
            vh.dataTextView = convertView.findViewById(R.id.data);
            vh.comunicationTextView = convertView.findViewById(R.id.comunicazioni);
            convertView.setTag(vh);
        }
        ListViewComunicazioniAdapter.viewHolder vh = (ListViewComunicazioniAdapter.viewHolder) convertView.getTag();
        Communication c = getItem(position);
        vh.dataTextView.setText(c.data);
        vh.comunicationTextView.setText(c.comunicazioni);

        return convertView;
    }
}
