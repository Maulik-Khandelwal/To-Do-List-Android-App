package com.example.todoapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private Context mContext;
    private List<FoodData> myFoodList;


    public MyAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);

        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHolder holder, int position) {



        holder.imageView.setImageResource(myFoodList.get(position).getItemImage());
        holder.mTitle.setText(myFoodList.get(position).getItemName());
        holder.mDescription.setText(myFoodList.get(position).getItemDescription());
        holder.mPrice.setText(myFoodList.get(position).getItemPrice());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Image", myFoodList.get(holder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description", myFoodList.get(holder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }

//    public void filteredList(ArrayList<FoodData> filterList) {
//    }

    public void filteredList(ArrayList<FoodData> filterList) {

        myFoodList = filterList;
        notifyDataSetChanged();

    }
}


class FoodViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView mTitle, mDescription, mPrice;
    CardView mCardView;


    public FoodViewHolder( View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mPrice = itemView.findViewById(R.id.tvPrice);
        mCardView = itemView.findViewById(R.id.myCardView);
    }
}

