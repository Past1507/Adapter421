package com.example.adapter421;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<Item> items;
    private LayoutInflater LayoutInflater;

    ItemAdapter(Context context, List<Item> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
        LayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(Item item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        if (i < items.size()) {
            return items.get(i);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.inflate(R.layout.item_list, viewGroup, false);
        }
        Item item = items.get(i);
        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.subtitle);
        ImageView img_src = view.findViewById(R.id.image);
        CheckBox checkBox = view.findViewById(R.id.checkBox);
        title.setText(item.getTitle());
        subtitle.setText(item.getSubtitle());
        img_src.setImageResource(item.getImg_srs());
        checkBox.setChecked(item.isChecked());
        return view;
    }
}
