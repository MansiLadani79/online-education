package com.example.newmsp.ui.Notice;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newmsp.R;
import com.example.newmsp.model.NoticeModel;

import java.util.List;
import java.util.Random;

public class NoticeItemRecyclerView extends RecyclerView.Adapter {

    List<NoticeModel> noticeModelList;
    NoticeClickListener noticeClickListener;
    String[] color_list={"#8a7ba2"};


    public NoticeItemRecyclerView(List<NoticeModel> noticeModels,NoticeClickListener noticeClickListener){
        this.noticeModelList=noticeModels;
        this.noticeClickListener=noticeClickListener;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_row,null);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        NoticeViewHolder noticeViewHolder= (NoticeViewHolder) holder;
        noticeViewHolder.noteText.setText(noticeModelList.get(position).getNote_data());
        noticeViewHolder.create_time.setText(noticeModelList.get(position).getCreated_at());

        Random random=new Random();
        int randomNo=random.nextInt(color_list.length);

        noticeViewHolder.card_item.setCardBackgroundColor(Color.parseColor(color_list[randomNo]));

        noticeViewHolder.notice_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticeClickListener.onClickItem(noticeModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticeModelList.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        public TextView noteText,create_time;
        public CardView card_item;
        public RelativeLayout notice_parent;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            noteText=itemView.findViewById(R.id.notetext);
            create_time=itemView.findViewById(R.id.create_time);
            notice_parent=itemView.findViewById(R.id.notice_parent);
            card_item=itemView.findViewById(R.id.card_item);
        }
    }

}
