package com.nashirul.faunasulteng;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        int photoResource = getIntent().getIntExtra("fauna_photo", 0);
        String name = getIntent().getStringExtra("fauna_name");
        String description = getIntent().getStringExtra("fauna_description");

        ImageView imageView = findViewById(R.id.img_item_photo);
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView descTextView = findViewById(R.id.tv_item_description);

        imageView.setImageResource(photoResource);
        nameTextView.setText(name);
        descTextView.setText(description);
    }
}
