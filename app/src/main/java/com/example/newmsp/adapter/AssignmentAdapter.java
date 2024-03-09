package com.example.newmsp.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.newmsp.R;
import com.example.newmsp.View_pdf;
import com.example.newmsp.model.Assignment;
import com.example.newmsp.ui.student.Student_Assignment;


import java.util.ArrayList;

public class AssignmentAdapter implements ListAdapter {

    ArrayList<Assignment> arrayList;
    Context context;

    public AssignmentAdapter(Context context, ArrayList<Assignment> arrayList) {
        this.arrayList=arrayList;
        this.context=(Context) context;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Assignment assignment = arrayList.get(position);

        if(convertView == null) {

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row_item, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            TextView textViewName = convertView.findViewById(R.id.textViewName);
            ImageView imageViewPdf = convertView.findViewById(R.id.imageViewPdf);
            CardView crad_view = convertView.findViewById(R.id.crad_view);

            textViewName.setText(assignment.name);
            imageViewPdf.setImageResource(R.drawable.pdf);

            crad_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(textViewName.getContext(), View_pdf.class);
                    intent.putExtra("name",assignment.getName());
                    intent.putExtra("url",assignment.getUrl());


                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    textViewName.getContext().startActivity(intent);

                }
            });

        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
