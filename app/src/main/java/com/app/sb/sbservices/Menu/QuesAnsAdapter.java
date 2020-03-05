package com.app.sb.sbservices.Menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sb.sbservices.R;

import java.util.ArrayList;

public class QuesAnsAdapter extends RecyclerView.Adapter<QuesAnsAdapter.SingleItemRowHolder> {

    private ArrayList<FaqsModel> itemsList;
    private Context mContext;




    public QuesAnsAdapter(Context context, ArrayList<FaqsModel> itemsList) {

        this.mContext = context;
        this.itemsList = itemsList;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quesans_layout, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        FaqsModel singleItem = itemsList.get(i);
        String question = (itemsList.get(i).getQuestion());
        String answer = (itemsList.get(i).getAnswer());



    }

    @Override
    public int getItemCount() {
        return (itemsList.size());
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
TextView question,answer;
        public SingleItemRowHolder(View view) {
            super(view);
            question = view.findViewById(R.id.question);
            answer = view.findViewById(R.id.answer);


        }
    }
}