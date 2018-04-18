package com.tictac.tictactoe;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoard extends Activity {
	private SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stats);
		preferences = getSharedPreferences(getString(R.string.scoreboard), 0);
		((TextView) findViewById(R.id.won)).setText(preferences.getLong(getString(R.string.won_statX), 0) + "");
		((TextView) findViewById(R.id.loss)).setText(preferences.getLong(getString(R.string.loss_statX), 0) + "");
		((TextView) findViewById(R.id.tie)).setText(preferences.getLong(getString(R.string.tie_statX), 0) + "");
		((TextView) findViewById(R.id.wonO)).setText(preferences.getLong(getString(R.string.won_statO), 0) + "");
		((TextView) findViewById(R.id.lossO)).setText(preferences.getLong(getString(R.string.loss_statO), 0) + "");
		((TextView) findViewById(R.id.tieO)).setText(preferences.getLong(getString(R.string.tie_statO), 0) + "");
	}
}
