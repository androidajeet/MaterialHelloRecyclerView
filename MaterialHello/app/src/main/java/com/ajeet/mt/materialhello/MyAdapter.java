/*
package com.ajeet.mt.materialhello;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ajeet.mt.model.Post;
import com.ajeet.mt.util.Common;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by kartik on 5/20/2015.
 *//*

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // private ArrayList<String> mDataset;

    private List<Post> posts;
    private static Context mContext;
    // private String[] mDataset;
    // private  TextView title;

   */
/* @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_drawer_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(title);
        return vh;
    }*//*


    */
/*@Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.mTextView.setText(mDataset[position]);
    }*//*


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_country, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       */
/* final String name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position));
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });

        holder.txtFooter.setText("Footer: " + mDataset.get(position));*//*

        Post p = posts.get(position);
        holder.userName.setText(p.getPostedBy());
        holder.postString.setText(p.getPostText());
        holder.createdDateString.setText(Common.getDifferenceBetweenDate(p.getCreatedDate(), Common.getCurrentLocalDateTime()));
        holder.noOfLikes.setText(p.getLikes() + "");


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //public TextView mTextView;
       */
/* public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }*//*

        public TextView userName, postString, createdDateString, noOfLikes, likebutton;
        public RelativeLayout countryImage;


        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            postString = (TextView) itemView.findViewById(R.id.dataTxt);
            noOfLikes = (TextView) itemView.findViewById(R.id.likeCountTxt);
            countryImage = (RelativeLayout) itemView.findViewById(R.id.letterImage);
            createdDateString = (TextView) itemView.findViewById(R.id.timeStamp);
            likebutton = (TextView) itemView.findViewById(R.id.like_icon);

            likebutton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //int count = Integer.parseInt(noOfLikes.toString());
                    //count++;

                    Toast.makeText(mContext, "No of likes", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public MyAdapter(List<Post> posts, Context context) {

        // Provide a suitable constructor (depends on the kind of dataset)
        this.posts = posts;
        this.mContext = context;
        //mDataset = myDataset;
    }


    */
/*public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }*//*



}
*/
