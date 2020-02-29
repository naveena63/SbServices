package com.app.sb.sbservices.Menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sb.sbservices.Packages.PackagesActivity;
import com.app.sb.sbservices.R;
import com.app.sb.sbservices.Utils.GlobalVariable;
import com.app.sb.sbservices.Utils.PrefManager;
import com.app.sb.sbservices.services.HomeScreenListener;
import com.app.sb.sbservices.services.ServiceAdpter;
import com.app.sb.sbservices.services.ServicesListModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class FaqsAdapter extends RecyclerView.Adapter<FaqsAdapter.ViewHolder> {


    private Context context;
    private HomeScreenListener homeScreenListener;
    private List<ServicesListModel> servicesListModel;
    PrefManager prefManager;

    public FaqsAdapter(List<ServicesListModel> servicesList) {
        this.servicesListModel = servicesList;

    }

    @NonNull
    @Override
    public FaqsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.faq_item,viewGroup,false);

        prefManager = new PrefManager(context);
        return  new FaqsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
             holder.textServiceNAme.setText(servicesListModel.get(position).getServiceName());

        final ArrayList singleSectionItems = servicesListModel.get(position).getAllItemsInSection();

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setNestedScrollingEnabled(false);

        holder.recyclerView.setFocusable(false);
        QuesAnsAdapter itemListDataAdapter = new QuesAnsAdapter(context, singleSectionItems);
        holder.recyclerView.setAdapter(itemListDataAdapter);
    }
    @Override
    public int getItemCount() {
        return servicesListModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
     RecyclerView recyclerView;
        TextView textServiceNAme;

        ViewHolder(View itemView) {
            super(itemView);

          recyclerView=itemView.findViewById(R.id.recyclerView);
            textServiceNAme = itemView.findViewById(R.id.textviewserviceName);
        }
    }
}
