package com.furkankurt.apigetretrofitdata.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.furkankurt.apigetretrofitdata.Model.UserModel;
import com.furkankurt.apigetretrofitdata.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    public RecyclerviewAdapter(List<UserModel> dataModelList, Activity activity) {
        this.dataModelList = dataModelList;
        this.activity = activity;
    }

    private List<UserModel> dataModelList;
    Activity activity;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.row_layout,parent,false);
        final ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textId.setText(String.valueOf(dataModelList.get(position).getId()));
            holder.textEmail.setText(String.valueOf(dataModelList.get(position).getEmail()));
            holder.textFirstName.setText(String.valueOf(dataModelList.get(position).getFirstName()));
            holder.textLastName.setText(String.valueOf(dataModelList.get(position).getLastName()));
            Picasso.get().load(dataModelList.get(position).getAvatar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textId;
        private TextView textEmail;
        private TextView textFirstName;
        private TextView textLastName;
        private  ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textId =itemView.findViewById(R.id.textId);
            textEmail = itemView.findViewById(R.id.textEmail);
            textFirstName = itemView.findViewById(R.id.textFirstname);
            textLastName = itemView.findViewById(R.id.textLastName);
            imageView=itemView.findViewById(R.id.imageViewPhoto);

        }
    }
}
