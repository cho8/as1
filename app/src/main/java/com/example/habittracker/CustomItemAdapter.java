package com.example.habittracker;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cho8 on 2016-09-26.
 */

// Idea for custom ArrayAdapter from here
// http://stackoverflow.com/questions/8166497/custom-adapter-for-list-view
public class CustomItemAdapter extends ArrayAdapter{

    public CustomItemAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CustomItemAdapter(Context context, int resource, List items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item, null);
        }

        Habit p = (Habit) getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.listItemText);
            tt1.setText(p.getContent());

            for (String s : p.getPastCompletesStrings()) {
                if (s.contains(date)) {
                    tt1.setPaintFlags(tt1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    tt1.setTextColor(Color.parseColor("#646464"));
                }
            }

        }

        return v;
    }

}
