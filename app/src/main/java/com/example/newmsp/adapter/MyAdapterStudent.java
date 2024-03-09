package com.example.newmsp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newmsp.R;
import com.example.newmsp.model.MyItemsStudent;

import java.util.List;

public class MyAdapterStudent extends RecyclerView.Adapter<MyAdapterStudent.MyViewHolder> {

    private  final List<MyItemsStudent> itemsStudents; //item array list
    private  final Context context; //context

    //consttroctor
    public MyAdapterStudent(List<MyItemsStudent> itemsStudents, Context context) {
        this.itemsStudents = itemsStudents;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout_student,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //getting single item/user details from list
        MyItemsStudent myItemsStudent = itemsStudents.get(position);

        //seting user details to textViews
        holder.fullname.setText(myItemsStudent.getFullname());
        holder.email.setText(myItemsStudent.getEmail());
        holder.mobile.setText(myItemsStudent.getMobile());



    }

    @Override
    public int getItemCount() {
        return itemsStudents.size();
    }

    // MyViewHolder class to hold view refrence for every item in thee recyclearview
    static class MyViewHolder extends RecyclerView.ViewHolder{

        //declaring textview
        private  final TextView fullname, email, mobile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //getting  textviews from recyclearview_adapter_layout_student.xml file
            fullname=itemView.findViewById(R.id.fullnameTV);
            email=itemView.findViewById(R.id.emailTV);
            mobile=itemView.findViewById(R.id.mobileTV);
        }
    }
}
