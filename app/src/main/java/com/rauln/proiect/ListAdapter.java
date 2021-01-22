package com.rauln.proiect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyListClass> myList;

    public ListAdapter(Context c, ArrayList<MyListClass> l){
        context = c;
        myList = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.myitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemname.setText(myList.get(position).getItemname());
        holder.descitem.setText(myList.get(position).getDescitem());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemname, descitem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = (TextView) itemView.findViewById(R.id.itemname);
            descitem = (TextView) itemView.findViewById(R.id.descitem);
        }
    }
}
