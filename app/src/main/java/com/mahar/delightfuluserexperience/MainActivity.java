package com.mahar.delightfuluserexperience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;

    private TextView mScoreView1;
    private TextView mScoreView2;

    private ImageButton decreaseTeam1;
    private ImageButton decreaseTeam2;

    private ImageButton increaseTeam1;
    private ImageButton increaseTeam2;
    private String STATE_SCORE_2;
    private String STATE_SCORE_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView1=findViewById(R.id.score_1);
        mScoreView2=findViewById(R.id.score_2);



    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        int nightMode= AppCompatDelegate.getDefaultNightMode();
        Log.i("nightMode",String.valueOf(nightMode));
        if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle("Day Mode");
        }else{
            menu.findItem(R.id.night_mode).setTitle("Night Mode");
        }
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode=AppCompatDelegate.getDefaultNightMode();
            if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
//        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1,mScore1);
        outState.putInt(STATE_SCORE_2,mScore1);

        super.onSaveInstanceState(outState);
    }

    public void decreaseScore(View view){
        int viewId=view.getId();
        switch (viewId){
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreView1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreView2.setText(String.valueOf(mScore2));
        }
    }
    public void increaseScore(View view){
        int viewId=view.getId();
        switch (viewId){
            case R.id.increaseTeam1:
                mScore1++;
                mScoreView1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreView2.setText(String.valueOf(mScore2));
        }
    }

}