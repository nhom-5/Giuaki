package com.example.giuaky;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class KHAdapter extends ArrayAdapter<khachhang> {
    Activity context;
    int resource;
    List<khachhang> objects;

    /**
     * @param context
     * @param resource
     * @param objects
     */
    public KHAdapter(Activity context, int resource, List<khachhang> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtTitle = (TextView) row.findViewById(R.id.makh);
        TextView txtAuthor = (TextView) row.findViewById(R.id.tenkh);
        TextView txtPrice = (TextView) row.findViewById(R.id.sdt);
        /** Set data to row*/
        final khachhang kh = this.objects.get(position);
        txtTitle.setText(String.valueOf(kh.getMakh()));
        txtAuthor.setText(kh.getTenkh());
        txtPrice.setText(String.valueOf(kh.getSdt()));

        return row;
    }

}
