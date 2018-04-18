package com.tictac.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity  {

    Button oneplayer;
    Button twoPlayer;
    private static String PLAYER="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);
        oneplayer= findViewById(R.id.oneplayer);
        twoPlayer= findViewById(R.id.twoplayer);


        oneplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ChooseActivity.this,LevelActivity.class);

                intent.putExtra("player","one");
                startActivity(intent);
            }
        });

        twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ChooseActivity.this,LevelActivity.class);

                intent.putExtra("player","two");

                startActivity(intent);

            }
        });

    }
}
