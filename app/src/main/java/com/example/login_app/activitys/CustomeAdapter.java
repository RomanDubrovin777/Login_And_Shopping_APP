package com.example.login_app.activitys;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_app.R;
import com.example.login_app.modles.DataModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewAmount;
        ImageView imageView;
        Button buttonAdd, buttonRemove;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.TextviewCardNameOfProduct);
            textViewAmount = itemView.findViewById(R.id.TextViewAmountOfProduct);
            imageView = itemView.findViewById(R.id.imageViewCardView);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);
            buttonRemove = itemView.findViewById(R.id.SubtractButton);
        }
    }

    @NonNull
    @Override

    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_new, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        DataModel ShoppingCart = dataSet.get(position);
        holder.textViewName.setText(dataSet.get(position).getProductName());
        holder.textViewAmount.setText(String.valueOf(dataSet.get(position).getAmountOfProduct()));
        holder.imageView.setImageResource(dataSet.get(position).getImage());
        holder.imageView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), dataSet.get(position).getProductName(), Toast.LENGTH_LONG).show();
        });

        holder.buttonAdd.setOnClickListener(v -> {
            ShoppingCart.setAmountOfProduct(ShoppingCart.getAmountOfProduct() + 1);
            holder.textViewAmount.setText(String.valueOf(ShoppingCart.getAmountOfProduct()));
            addProductToDatabase(ShoppingCart);
        });

        holder.buttonRemove.setOnClickListener(v -> {
            if (ShoppingCart.getAmountOfProduct() > 0) {
                ShoppingCart.setAmountOfProduct(ShoppingCart.getAmountOfProduct() - 1);
                holder.textViewAmount.setText(String.valueOf(ShoppingCart.getAmountOfProduct()));
                removeProductFromDatabase(ShoppingCart);
            } else {
                Toast.makeText(v.getContext(), "Cannot reduce below 0", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void addProductToDatabase(DataModel product) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ShoppingCart");
        databaseReference.child(product.getProductName()).setValue(product)
                .addOnSuccessListener(aVoid -> {
                })
                .addOnFailureListener(e -> {

                });
    }

    private void removeProductFromDatabase(DataModel product) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ShoppingCart");
        if (product.getAmountOfProduct() == 0) {
            databaseReference.child(product.getProductName()).removeValue()
                    .addOnSuccessListener(aVoid -> {

                    })
                    .addOnFailureListener(e -> {

                    });
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}