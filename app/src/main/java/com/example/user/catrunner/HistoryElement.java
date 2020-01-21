package com.example.user.catrunner;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.GregorianCalendar;

public class HistoryElement {
//    private Drawable imgMap;
    private GregorianCalendar txtDate;
    private Double txtDistance;

    public HistoryElement(GregorianCalendar date, Double distance) {
//        Resources myResources = Resources.getSystem();
//        this.imgMap = myResources.getDrawable(R.drawable.img_earth);
        this.txtDate = date;
        this.txtDistance = distance;
    }

    public GregorianCalendar getDate() {
        return this.txtDate;
    }

    public Double getDistance() {
        return this.txtDistance;
    }
}
