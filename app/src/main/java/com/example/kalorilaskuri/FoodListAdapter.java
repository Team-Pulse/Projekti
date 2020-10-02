package com.example.kalorilaskuri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {
    private ArrayList<Food> mAddedFoods;
    private FoodListViewHolder.OnFoodListListener mOnFoodListListener;

    public FoodListAdapter(ArrayList<Food> AddedFoods, FoodListViewHolder.OnFoodListListener onFoodListListener) {
        this.mAddedFoods = AddedFoods;
        this.mOnFoodListListener = onFoodListListener;
    }

    public static class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nimi;
        public TextView kcal;
        public ImageView mImageView;
        OnFoodListListener onFoodListListener;

        public FoodListViewHolder(@NonNull View itemView, OnFoodListListener onFoodListListener) {
            super(itemView);
            nimi = itemView.findViewById(R.id.textViewNimi);
            kcal = itemView.findViewById(R.id.textViewKcal);
            mImageView = itemView.findViewById(R.id.imageView);
            this.onFoodListListener = onFoodListListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFoodListListener.onFoodListClick(getAdapterPosition());
        }

        public interface OnFoodListListener {
            void onFoodListClick(int position);
        }
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.addedfoods_item, parent, false);
        FoodListViewHolder flvh = new FoodListViewHolder(v, mOnFoodListListener);
        return flvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder holder, int position) {
        Food currentItem = mAddedFoods.get(position);

        holder.nimi.setText(currentItem.getName());
        holder.kcal.setText(currentItem.getKcalString());
        holder.mImageView.setImageResource(currentItem.getmImageResource());
    }

    @Override
    public int getItemCount() {
        return mAddedFoods.size();
    }


}
