package com.nashirul.faunasulteng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFaunaAdapter extends RecyclerView.Adapter<ListFaunaAdapter.ListViewHolder> {
    private ArrayList<Fauna> listFauna;

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public ListFaunaAdapter(ArrayList<Fauna> list){
        this.listFauna = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Fauna fauna = listFauna.get(position);
        holder.imgPhoto.setImageResource(fauna.getPhoto());
        holder.tvName.setText(fauna.getName());
        holder.tvDescription.setText(fauna.getDescription());
        holder.itemView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(listFauna.get(holder.getAdapterPosition()));
        });

    }
    public interface OnItemClickCallback {
        void onItemClicked(Fauna data);
    }

    @Override
    public int getItemCount() {
        return listFauna.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
