package com.example.giuaky;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class HDAdapter extends ArrayAdapter<chitiethopdongClass> {
    Activity context;
    int resource;
    List<chitiethopdongClass> objects;

    /**
     * @param context
     * @param resource
     * @param objects
     */
    public HDAdapter(Activity context, int resource, List<chitiethopdongClass> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.itemhd, null);

        TextView sohd = (TextView) row.findViewById(R.id.sohd);
        TextView maxe = (TextView) row.findViewById(R.id.maxe);
        TextView tenkh = (TextView) row.findViewById(R.id.tenkh);
        TextView ngayhd = (TextView) row.findViewById(R.id.ngayhd);
        TextView songaythue = (TextView) row.findViewById(R.id.songaythue);
        TextView gia = (TextView) row.findViewById(R.id.gia);
        /** Set data to row*/
        final chitiethopdongClass hd = this.objects.get(position);
        sohd.setText(String.valueOf(hd.getSoHD()));
        maxe.setText(String.valueOf(hd.getMaXe()));
//        tenkh.setText(hd.getTenKH());
//        ngayhd.setText(hd.getNgayHD());
        songaythue.setText(String.valueOf(hd.getSongaythue()));
        gia.setText(String.valueOf(hd.getGia()));

        return row;
    }
}
