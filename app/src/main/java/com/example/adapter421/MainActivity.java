package com.example.adapter421;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView mMainContent;
    private LinearLayout mAddLayout;
    private FloatingActionButton fab;
    private Button mAddTask;
    private EditText inputTitle;
    private EditText inputSubtitle;
    private Spinner mListTask;

    private ItemAdapter adapter;
    private int[] image_src = {android.R.drawable.ic_dialog_alert, android.R.drawable.ic_input_get};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        adapter = new ItemAdapter(this, null);
        mMainContent.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                mAddLayout.setVisibility(view.VISIBLE);
                fab.setVisibility(view.GONE);
                toolbar.setTitle(getString(R.string.new_task));
            }
        });

        mAddTask.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                String title = inputTitle.getText().toString();
                String subtitle = inputSubtitle.getText().toString();
                int param_task = (int) mListTask.getSelectedItemId();
                if (title.equals("") && subtitle.equals("")) {
                    Toast.makeText(MainActivity.this, getString(R.string.errorMessage), Toast.LENGTH_LONG).show();
                } else {
                    adapter.addItem(new Item(title, subtitle, image_src[param_task], true));
                    inputTitle.setText("");
                    inputSubtitle.setText("");
                    mListTask.setSelection(0);
                    mAddLayout.setVisibility(view.GONE);
                    fab.setVisibility(view.VISIBLE);
                    toolbar.setTitle(getString(R.string.app_name));
                }
                }
            });
    }

    @Override
    public void onBackPressed() {
        adapter.notifyDataSetChanged();
        super.onBackPressed();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMainContent = findViewById(R.id.main_content);
        mAddLayout = findViewById(R.id.add_layout);
        fab = findViewById(R.id.fab);
        mAddTask = findViewById(R.id.add_task);
        inputTitle = findViewById(R.id.input_title);
        inputSubtitle = findViewById(R.id.input_subtitle);
        mListTask = findViewById(R.id.list_task);
    }
}
