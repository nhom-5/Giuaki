package com.example.giuaky;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class XeAdapter extends ArrayAdapter<xe> {
    Activity context;
    int resource;
    List<xe> objects;

    /**
     * @param context
     * @param resource
     * @param objects
     */
    public XeAdapter(Activity context, int resource, List<xe> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.itemxe, null);

        TextView txtTitle = (TextView) row.findViewById(R.id.tenXe);
        TextView txtAuthor = (TextView) row.findViewById(R.id.xuatXU);
        TextView txtPrice = (TextView) row.findViewById(R.id.gia);
        ImageView txtImg = (ImageView) row.findViewById(R.id.imageIcon);
        /** Set data to row*/
        final xe xe = this.objects.get(position);
        txtTitle.setText(xe.getTenXe());
        txtAuthor.setText(xe.getXuatXu());
        txtPrice.setText(String.valueOf(xe.getGia()));
        txtImg.setImageResource(xe.getIcon());

        return row;
    }
}
