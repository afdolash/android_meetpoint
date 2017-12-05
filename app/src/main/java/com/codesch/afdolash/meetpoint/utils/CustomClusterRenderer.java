package com.codesch.afdolash.meetpoint.utils;

import android.content.Context;

import com.codesch.afdolash.meetpoint.activity.MapsActivity;
import com.codesch.afdolash.meetpoint.model.Event;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

/**
 * Created by Afdolash on 11/17/2017.
 */

public class CustomClusterRenderer extends DefaultClusterRenderer<Event> {

    private final Context mContext;

    public CustomClusterRenderer(Context context, GoogleMap map, ClusterManager<Event> clusterManager) {
        super(context, map, clusterManager);
        mContext = context;
    }

    @Override
    protected void onBeforeClusterItemRendered(Event item, MarkerOptions markerOptions) {
        String sDate = null;
        String[] date = item.getDateStart_event().split("-");

        switch (date[1]) {
            case "01":
                sDate = date[2] +" Januari " + date[0];
                break;
            case "02":
                sDate = date[2] +" Februari " + date[0];
                break;
            case "03":
                sDate = date[2] +" Maret " + date[0];
                break;
            case "04":
                sDate = date[2] +" April " + date[0];
                break;
            case "05":
                sDate = date[2] +" Mei " + date[0];
                break;
            case "06":
                sDate = date[2] +" Juni " + date[0];
                break;
            case "07":
                sDate = date[2] +" Juli " + date[0];
                break;
            case "08":
                sDate = date[2] +" Agustus " + date[0];
                break;
            case "09":
                sDate = date[2] +" September " + date[0];
                break;
            case "10":
                sDate = date[2] +" Oktober " + date[0];
                break;
            case "11" :
                sDate = date[2] +" November " + date[0];
                break;
            case "12":
                sDate = date[2] +" Desember " + date[0];
                break;
        }

        markerOptions.snippet(sDate);
        markerOptions.title(item.getTitle_event());
        super.onBeforeClusterItemRendered(item, markerOptions);
    }
}