package com.kuce2k15.alert;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Friends> mlist;

    public RecyclerViewAdapter(List<Friends> mlist) {
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View root = inflater.inflate(R.layout.item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(root);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Friends friends = mlist.get(i);
        viewHolder.TV_Name.setText(friends.getmName());
        viewHolder.TV_Phone.setText(friends.getmPhone());


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{
    TextView TV_Name, TV_Phone;
    public ViewHolder(View itemView) {
        super(itemView);
        TV_Name=(TextView)itemView.findViewById(R.id.recycle_name);
        TV_Phone=(TextView)itemView.findViewById(R.id.recycle_phone);
    }
}
