package com.app.sb.sbservices.TimeAndDate;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.sb.sbservices.R;
import com.app.sb.sbservices.Utils.AppConstants;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HorizontalPickerAdapter extends RecyclerView.Adapter<HorizontalPickerAdapter.ViewHolder> {

    private static final long DAY_MILLIS = AlarmManager.INTERVAL_DAY;
    private final int mBackgroundColor;
    private final int mDateSelectedTextColor;
    private final int mDateSelectedColor;
    private final int mTodayDateTextColor;
    private final int mTodayDateBackgroundColor;
    private final int mDayOfWeekTextColor;
    private final int mUnselectedDayTextColor;
    private int itemWidth;
    private final OnItemClickedListener listener;
    private ArrayList<Day> items;
    String stringblockedDate, status;
    Context context;
    private ArrayList<BlockedDates> blockedDates;

    public HorizontalPickerAdapter(int itemWidth, OnItemClickedListener listener, Context context, int daysToCreate, int offset, int mBackgroundColor, int mDateSelectedColor, int mDateSelectedTextColor, int mTodayDateTextColor, int mTodayDateBackgroundColor, int mDayOfWeekTextColor, int mUnselectedDayTextColor) {
        items = new ArrayList<>();
        blockedDates = new ArrayList<>();
        this.itemWidth = itemWidth;
        this.listener = listener;
        generateDays(daysToCreate, new DateTime().minusDays(offset).getMillis(), false);
        this.mBackgroundColor = mBackgroundColor;
        this.mDateSelectedTextColor = mDateSelectedTextColor;
        this.mDateSelectedColor = mDateSelectedColor;
        this.mTodayDateTextColor = mTodayDateTextColor;
        this.mTodayDateBackgroundColor = mTodayDateBackgroundColor;
        this.mDayOfWeekTextColor = mDayOfWeekTextColor;
        this.mUnselectedDayTextColor = mUnselectedDayTextColor;

    }

    public void generateDays(int n, long initialDate, boolean cleanArray) {
        if (cleanArray)
            items.clear();
        int i = 0;
        while (i < n) {
            DateTime actualDate = new DateTime(initialDate + (DAY_MILLIS * i++));
            items.add(new Day(actualDate));
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_day, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Day item = getItem(position);
        holder.tvDay.setText(item.getDay());
        holder.tvWeekDay.setText(item.getWeekDay());
        holder.tvWeekDay.setTextColor(mDayOfWeekTextColor);
        if (item.isSelected()) {
            holder.tvDay.setBackgroundDrawable(getDaySelectedBackground(holder.itemView));
            holder.tvDay.setTextColor(mDateSelectedTextColor);
        } else if (item.isToday()) {
             holder.tvDay.setBackgroundDrawable(getDayTodayBackground(holder.itemView));
              holder.tvDay.setTextColor(mTodayDateTextColor);
        } else {
            holder.tvDay.setBackgroundColor(mBackgroundColor);
            holder.tvDay.setTextColor(mUnselectedDayTextColor);
        }
/*
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://sbservices.in/api/get-blocked-booking-dates", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("df", "b,lockedresponse" + response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        stringblockedDate = jsonObject.getString("blockeddate");
                        status = jsonObject.getString("status");
                        String message = jsonObject.getString("message");

                        if (item.getDay().equalsIgnoreCase(stringblockedDate)) {
                            holder.tvDay.setText(stringblockedDate);
                            holder.tvDay.setTextColor(Color.BLACK);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("token", "c0304a62dd289bdc7364fb974c2091f6");
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);*/

    }


    private Drawable getDaySelectedBackground(View view) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.background_day_selected);
        DrawableCompat.setTint(drawable, mDateSelectedColor);
        return drawable;
    }

    private Drawable getDayTodayBackground(View view) {
        Drawable drawable = view.getResources().getDrawable(R.color.white);
        if (mTodayDateBackgroundColor != -1)
            DrawableCompat.setTint(drawable, mTodayDateBackgroundColor);
        return drawable;
    }

    public Day getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvDay, tvWeekDay;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDay = (TextView) itemView.findViewById(R.id.tvDay);
            tvDay.setWidth(itemWidth);
            tvWeekDay = (TextView) itemView.findViewById(R.id.tvWeekDay);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClickView(v, getAdapterPosition());
        }
    }


}