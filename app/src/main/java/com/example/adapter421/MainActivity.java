package com.example.adapter421;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView main_content;
    private LinearLayout add_layout;
    private FloatingActionButton fab;
    private Button add_task;
    private EditText input_title;
    private EditText input_subtitle;
    private Spinner list_task;

    private ItemAdapter adapter;
    private int[] image_src = {android.R.drawable.ic_dialog_alert, android.R.drawable.ic_input_get};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        adapter = new ItemAdapter(this, null);
        main_content.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                add_layout.setVisibility(view.VISIBLE);
                fab.setVisibility(view.GONE);
                toolbar.setTitle(getString(R.string.new_task));
            }
        });

        add_task.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                String title = input_title.getText().toString();
                String subtitle = input_subtitle.getText().toString();
                int param_task = (int) list_task.getSelectedItemId();
                adapter.addItem(new Item(title, subtitle, image_src[param_task], true));
                input_title.setText("");
                input_subtitle.setText("");
                list_task.setSelection(0);
                add_layout.setVisibility(view.GONE);
                fab.setVisibility(view.VISIBLE);
                toolbar.setTitle(getString(R.string.app_name));
                }
            });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        main_content = findViewById(R.id.main_content);
        add_layout = findViewById(R.id.add_layout);
        fab = findViewById(R.id.fab);
        add_task = findViewById(R.id.add_task);
        input_title = findViewById(R.id.input_title);
        input_subtitle = findViewById(R.id.input_subtitle);
        list_task = findViewById(R.id.list_task);
    }
}
