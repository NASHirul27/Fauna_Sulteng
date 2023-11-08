package com.nashirul.faunasulteng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFauna;
    private ArrayList<Fauna> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvFauna = findViewById(R.id.rv_fauna);
        rvFauna.setHasFixedSize(true);

        list.addAll(getListFaunaes());
        showRecyclerList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.action_list){
            rvFauna.setLayoutManager(new LinearLayoutManager(this));
        } else if (item.getItemId() == R.id.action_grid) {
            rvFauna.setLayoutManager(new GridLayoutManager(this, 2));
        }
        return super.onOptionsItemSelected(item);
    }
    public ArrayList<Fauna> getListFaunaes(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Fauna> listFauna = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Fauna fauna = new Fauna();
            fauna.setName(dataName[i]);
            fauna.setDescription(dataDescription[i]);
            fauna.setPhoto(dataPhoto.getResourceId(i, -1));
            listFauna.add((fauna));
        }
        return  listFauna;
    }
    private void showRecyclerList(){
        rvFauna.setLayoutManager(new LinearLayoutManager(this));
        ListFaunaAdapter listFaunaAdapter = new ListFaunaAdapter(list);
        rvFauna.setAdapter(listFaunaAdapter);

        listFaunaAdapter.setOnItemClickCallback(this::showSelectedFauna);
    }
    private void showSelectedFauna (Fauna fauna){
        Intent intent = new Intent(MainActivity.this, Detail.class);

        intent.putExtra("fauna_name", fauna.getName());
        intent.putExtra("fauna_description", fauna.getDescription());
        intent.putExtra("fauna_photo", fauna.getPhoto());

        startActivity(intent);
    }
}