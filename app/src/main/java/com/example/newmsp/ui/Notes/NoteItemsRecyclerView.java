package com.example.newmsp.ui.Notes;

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
import com.example.newmsp.model.NoteModel;

import java.util.List;
import java.util.Random;

public class NoteItemsRecyclerView extends RecyclerView.Adapter {

    List<NoteModel> noteModelList;
    NoteClickListener noteClickListener;
    String[] color_list={"#B3AAC3","#443b53","#67587d","#786792","#8a7ba2","#9d90b0","#afa5bf","#c2bace","#9B8FB0","#A398B6","#ABA1BC","#BBB3C9","#C3BCCF","#CBC5D6"};

    public NoteItemsRecyclerView(List<NoteModel> noteModels,NoteClickListener noteClickListener){
        this.noteModelList=noteModels;
        this.noteClickListener=noteClickListener;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView noteText,create_time;
        public CardView card_item;
        public RelativeLayout note_parent;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteText=itemView.findViewById(R.id.notetext);
            create_time=itemView.findViewById(R.id.create_time);
            note_parent=itemView.findViewById(R.id.note_parent);
            card_item=itemView.findViewById(R.id.card_item);
        }
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,null);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        NoteViewHolder noteViewHolder= (NoteViewHolder) holder;
        noteViewHolder.noteText.setText(noteModelList.get(position).getNote_data());
        noteViewHolder.create_time.setText(noteModelList.get(position).getCreated_at());

        Random random=new Random();
        int randomNo=random.nextInt(color_list.length);

        noteViewHolder.card_item.setCardBackgroundColor(Color.parseColor(color_list[randomNo]));

        noteViewHolder.note_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteClickListener.onClickItem(noteModelList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return noteModelList.size();
    }
}
