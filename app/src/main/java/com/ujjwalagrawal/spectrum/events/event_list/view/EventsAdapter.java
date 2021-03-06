package com.ujjwalagrawal.spectrum.events.event_list.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;
import com.ujjwalagrawal.spectrum.events.event_details.view.EventDetailActivity;
import com.ujjwalagrawal.spectrum.events.event_list.data.EventData;
import com.ujjwalagrawal.spectrum.helper.image_loaders.GlideImageLoader;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
import com.ujjwalagrawal.spectrum.home.HomeActivity;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 5/8/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<EventData> data = new ArrayList<>();
    Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public EventsAdapter(Context context1) {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
       imageLoader = new GlideImageLoader(context);
    }
    void setData(List<EventData> data)
    {
        this.data = data;
    }


    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.events_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final EventData eventsData = data.get(position);
        imageLoader.loadImage(eventsData.getImage_url(),holder.event_image,holder.progressBar);
        holder.event_name.setText(eventsData.getName());

        if (!eventsData.getRound_name().equals("") || eventsData.getRound_name().equals(null)){
            holder.eventRoundName.setText(eventsData.getRound_name());
            holder.eventRoundName.setVisibility(View.VISIBLE);
        }else {
            holder.eventRoundName.setVisibility(View.INVISIBLE);
        }

        holder.time_textview.setText(eventsData.getTime());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentActivity activity = (FragmentActivity)(context);
//                FragmentManager fm = activity.getSupportFragmentManager();
//                EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("event_id",eventsData.getEvent_id());
                ((HomeActivity)context).startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView event_image;
        public RelativeLayout relativeLayout;
        public TextView event_name,time_textview,eventRoundName;
        public AVLoadingIndicatorView progressBar;
        public MyViewHolder(View itemView){
            super(itemView);
            event_image = (ImageView) itemView.findViewById(R.id.eventImg);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.event_relativeLayout);
            time_textview = (TextView) itemView.findViewById(R.id.time_textview);
            event_name = (TextView) itemView.findViewById(R.id.eventName);
            eventRoundName = (TextView) itemView.findViewById(R.id.eventRoundName);
            progressBar = (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_events);

        }
    }
}
