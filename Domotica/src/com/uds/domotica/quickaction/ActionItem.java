package com.uds.domotica.quickaction;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ActionItem {
	private Drawable icon;
    private Bitmap thumb;
    private String title;
    private boolean selected;
     
    public ActionItem() {}
    public ActionItem(Drawable icon) {
        this.icon = icon;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
    public Drawable getIcon() {
        return this.icon;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public boolean isSelected() {
        return this.selected;
    }
    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }
    public Bitmap getThumb() {
        return this.thumb;
    }
}
