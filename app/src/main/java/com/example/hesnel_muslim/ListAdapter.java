package com.example.hesnel_muslim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {
    ArrayList arrayList;
    Context context;
    public ListAdapter(Context context, ArrayList arrayList) {
        super(context, R.layout.list_item,arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    private class ViewHolder{
        TextView title;
        ImageView logo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data data = (Data) getItem(position);
        ViewHolder viewHolder;
        final View view;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.logo = convertView.findViewById(R.id.book);
            view = convertView;
            convertView.setTag(viewHolder);
        }else {
           viewHolder = (ViewHolder) convertView.getTag();
           view = convertView;
        }
        viewHolder.title.setText(data.getTitle());
        viewHolder.logo.setImageResource(R.drawable.book);
        return view;
    }
}
