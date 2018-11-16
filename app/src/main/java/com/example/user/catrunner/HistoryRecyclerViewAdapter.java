package com.example.user.catrunner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static com.example.user.catrunner.LoginActivity.typefaceOpenSansRegular;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder> {

    private List<HistoryElement> mData;
    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public HistoryRecyclerViewAdapter(Context context, List<HistoryElement> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.history_element_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryElement history = mData.get(position);
        DateFormat defaultDate = DateFormat.getDateTimeInstance();
        String text = defaultDate.format(history.getDate().getTime())+ "\n" + history.getDistance().toString() + "km";
        holder.myTextView.setText(text);
//        holder.myTextView.setText(hi.getName());
//        holder.myImageView.setImageDrawable(recipe.getImg());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.txt_history_info);
            myTextView.setTypeface(typefaceOpenSansRegular);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) {
//                mClickListener.onItemClick(view, getAdapterPosition());
//            }
//        }
    }

    // convenience method for getting data at click position
    Double getItemDistance(int id) {
        return mData.get(id).getDistance();
    }

    GregorianCalendar getItemDate(int id) {
        return mData.get(id).getDate();
    }

    // allows clicks events to be caught
//    void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }

    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
}