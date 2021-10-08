package umn.ac.id.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private TextView inputName;
    private ArrayList<Music> judulList;
    private RecyclerView recyclerView;
    private recyclerAdapter adapter;
    private recyclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Intent libIntent = getIntent();
        String name = libIntent.getStringExtra("InputName");
        getSupportActionBar().setTitle(name);
        recyclerView = findViewById(R.id.recyclerview);
        judulList = new ArrayList<>();

        setMusicInfor();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        adapter = new recyclerAdapter(judulList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),DetailLib.class);
                intent.putExtra("judul", judulList.get(position).getJudul());
                intent.putExtra("kategori",judulList.get(position).getKategori());
                startActivity(intent);
            }
            @Override
            public void onDeleteClick(int position){
                deletelist(position);
            }
        };
    }

    private void setMusicInfor() {
        judulList.add(new Music("Never Gonna Give You UP", "Song", R.raw.nevergonnagiveyouup));
        judulList.add(new Music("Windah Basudara Yuzhong", "Meme", R.raw.windahbasudarayuzhong));
        judulList.add(new Music("Safe And Sound", "Song", R.raw.safeandsound));
        judulList.add(new Music("Roblox Death","Meme", R.raw.roblox_death));
        judulList.add(new Music("Ba dum Tss","SFX", R.raw.badumm));
        judulList.add(new Music("Jojo Adventure", "Anime", R.raw.jojo_adventure));
        judulList.add(new Music("Dio", "Anime", R.raw.dio));
        judulList.add(new Music("Movie 1", "SFX", R.raw.movie_1));
        judulList.add(new Music("Please NO", "Meme", R.raw.no_god));
        judulList.add(new Music("SpongeBob Fail", "Meme", R.raw.sponge_fail));
        judulList.add(new Music("Tom Scream", "SFX", R.raw.tom));
    }
    private void deletelist(int position){
        judulList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intenta = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(intenta);
                return true;
            case R.id.item2:
                Intent intentb = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(intentb);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}