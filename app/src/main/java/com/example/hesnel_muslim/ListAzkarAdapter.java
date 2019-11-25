package com.example.hesnel_muslim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAzkarAdapter extends ArrayAdapter {
    ArrayList<String> arrayList;
    Context context;

    public ListAzkarAdapter(Context context, ArrayList<String> arrayList) {
        super(context, R.layout.list_azkar, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    private class ViewHolder {
        TextView txt;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        final View view;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_azkar, parent, false);
            viewHolder.txt = convertView.findViewById(R.id.zekr);
            view = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }
        viewHolder.txt.setText(Data.azkar.get(position));
        return view;
    }
}
