package com.tictac.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialog extends DialogFragment {

    Button button;
    Button scoreBoard;
    TextView textView;
    TextView textView2;
    String message;
    String message1;
      public  void setMessage(String message,String message1){

          this.message=message;
          this.message1=message1;

      }

    @NonNull
    public Dialog onCreateDialog(Bundle paramBundle)
    {

        Object localObject = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view= ((LayoutInflater)localObject).inflate(R.layout.dialog, null);
        button= view.findViewById(R.id.buttonRepeat);
        textView= view.findViewById(R.id.displayResult);
        textView2= view.findViewById(R.id.wonmessage);
        scoreBoard= view.findViewById(R.id.scoreBoard);
        textView2.setText(message1);
        textView.setText(message);

        scoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ScoreBoard.class);
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((GameActivity)getActivity()).startNewGame();
                dismiss();

            }
        });

        builder.setView(view);
        return builder.create();
    }



}
