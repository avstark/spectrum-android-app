package com.ujjwalagrawal.spectrum.events.event_details.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeDateFragment extends Fragment {
    
    
    @BindView(R.id.time_textview)
    TextView timeTextview;
    @BindView(R.id.date_textview)
    TextView dateTextview;
    @BindView(R.id.location_textview)
    TextView locationTextview;
    
    String date = "";
    String time = "";
    String location = "";
    
    public TimeDateFragment() {
    }
    
    public static TimeDateFragment newInstance(String date,String time) {
        
        Bundle args = new Bundle();
        
        TimeDateFragment fragment = new TimeDateFragment();
        fragment.setArguments(args);
        args.putString("date",date);
        args.putString("time",time);
        return fragment;
    }
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_date, container, false);
        ButterKnife.bind(this, view);
//        date=;
//        time=;
        timeTextview.setText(time);
        dateTextview.setText(date);
        locationTextview.setText(location);
        
        return view;
    }
    
//    public void update(Event event) {
//        date = event.getDate();
//        time = event.getTime();
//        location = event.getLocation();
//
//        if(timeTextview == null){
//            return;
//        }
//
//        timeTextview.setText(time);
//        dateTextview.setText(date);
//        locationTextview.setText(location);
//    }
}
