package com.example.autohush;


import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
  private ArrayList<LocationData> mDataset;

  // Provide a reference to the views for each data item
  // Complex data items may need more than one view per item, and
  // you provide access to all the views for a data item in a view holder
  public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView txtHeader;
    public TextView txtFooter;

    public ViewHolder(View v) {
      super(v);
      txtHeader = (TextView) v.findViewById(R.id.firstline);
      txtFooter = (TextView) v.findViewById(R.id.secondline);
    }
  }

  public void add(int position, LocationData item) {
    mDataset.add(position, item);
    notifyItemInserted(position);
  }

  public void remove(LocationData item) {
    int position = mDataset.indexOf(item);
    mDataset.remove(position);
    notifyItemRemoved(position);
  }

  // Provide a suitable constructor (depends on the kind of dataset)
  public MyAdapter(ArrayList<LocationData> myDataset) {
	  Log.d("test", "MyAdapterjava reached");
    mDataset = myDataset;
  }

  // Create new views (invoked by the layout manager)
  @Override
  public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    // create a new view
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
    // set the view's size, margins, paddings and layout parameters
    ViewHolder vh = new ViewHolder(v);
    return vh;
  }

  // Replace the contents of a view (invoked by the layout manager)
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    final LocationData loc = mDataset.get(position);
    holder.txtHeader.setText("Lat" + String.valueOf(loc.latitude));
    holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              remove(loc);
            }
        });
    
    holder.txtFooter.setText("Long: " + String.valueOf(loc.longitude));
    

  }

  // Return the size of your dataset (invoked by the layout manager)
  @Override
  public int getItemCount() {
    return mDataset.size();
  }

} 