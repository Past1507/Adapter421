package com.example.adapter421;

public class Item {
    private String title;
    private String subtitle;
    private int img_srs;
    private boolean checked;

    public Item(String title, String subtitle, int img_srs, boolean checked) {
        this.title = title;
        this.subtitle = subtitle;
        this.img_srs = img_srs;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getImg_srs() {
        return img_srs;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImg_srs(int img_srs) {
        this.img_srs = img_srs;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
