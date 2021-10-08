package umn.ac.id.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailLib extends AppCompatActivity {
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lib);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView judultxt = findViewById(R.id.judul);
        TextView kategoritxt = findViewById(R.id.kategori);

        String judul = "Judul belom ada";
        String kategori = "Belom ada";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
           judul = extras.getString("judul");
           kategori = extras.getString("kategori");
        }
        getSupportActionBar().setTitle(judul);

        judultxt.setText(judul);
        kategoritxt.setText(kategori);


        if(judul.equals("Never Gonna Give You UP")){
            player = MediaPlayer.create(DetailLib.this, R.raw.nevergonnagiveyouup);
        }
        else if(judul.equals("Windah Basudara Yuzhong")){
            player = MediaPlayer.create(DetailLib.this, R.raw.windahbasudarayuzhong);
        }
        else if(judul.equals("Safe And Sound")){
            player = MediaPlayer.create(DetailLib.this, R.raw.safeandsound);
        }else if(judul.equals("Ba dum Tss")){
            player = MediaPlayer.create(DetailLib.this, R.raw.badumm);
        }else if(judul.equals("Dio")){
            player = MediaPlayer.create(DetailLib.this, R.raw.dio);
        }else if(judul.equals("Jojo Adventure")){
            player = MediaPlayer.create(DetailLib.this, R.raw.jojo_adventure);
        }else if(judul.equals("Movie 1")){
            player = MediaPlayer.create(DetailLib.this, R.raw.movie_1);
        }else if(judul.equals("Please NO")){
            player = MediaPlayer.create(DetailLib.this, R.raw.no_god);
        }else if(judul.equals("Roblox Death")){
            player = MediaPlayer.create(DetailLib.this, R.raw.roblox_death);
        }else if(judul.equals("SpongeBob Fail")){
            player = MediaPlayer.create(DetailLib.this, R.raw.sponge_fail);
        }else if(judul.equals("Tom Scream")){
            player = MediaPlayer.create(DetailLib.this, R.raw.tom);
        }
        else{
            player = null;
        }


    }
    public void setPlay(View view){
        player.start();
    }

    public void stopPlay(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                stopPlay();
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}