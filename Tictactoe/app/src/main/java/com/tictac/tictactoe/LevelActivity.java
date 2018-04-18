package com.tictac.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    Button three;
    Button five;
    String typeOfPlayer;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                typeOfPlayer = null;
            } else {
                typeOfPlayer = extras.getString("player");
            }
        } else {
            typeOfPlayer = (String) savedInstanceState.getSerializable("player");
        }

        three= findViewById(R.id.three);
        five= findViewById(R.id.five);




        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LevelActivity.this,GameActivity.class);
                intent.putExtra("board","three");
                intent.putExtra("player",typeOfPlayer);
                startActivity(intent);
            }
        });




        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LevelActivity.this,GameActivity.class);
                intent.putExtra("board","five");
                intent.putExtra("player",typeOfPlayer);
                startActivity(intent);
            }
        });


    }

}
