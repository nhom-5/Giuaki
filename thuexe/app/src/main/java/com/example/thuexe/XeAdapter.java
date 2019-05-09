package com.example.thuexe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class XeAdapter extends ArrayAdapter<Xe> {
    Context context;
    int layoutResourceId;
    ArrayList<Xe> data = null;

    public XeAdapter(Context context, int layoutResourceId, ArrayList<Xe> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        XeHolder holder = null;
        if(row==null){

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new XeHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imageIcon);
            holder.text1 = (TextView)row.findViewById(R.id.text1);
            holder.text2 = (TextView)row.findViewById(R.id.text2);
            holder.text3 = (TextView)row.findViewById(R.id.text3);

            row.setTag(holder);

        }
        else {
            holder = (XeHolder) row.getTag();

        }
        Xe item = data.get(position);
        holder.text1.setText(item.title1);
        holder.text2.setText(item.title2);
        holder.text3.setText(item.title3);
        holder.imgIcon.setImageResource(item.icon);
        return  row;
    }

    static class XeHolder{
        ImageView imgIcon;
        TextView text1;
        TextView text3;
        TextView text2;
    }
}
