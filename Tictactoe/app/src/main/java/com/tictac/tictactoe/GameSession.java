package com.tictac.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class GameSession {
	public static final int CENTER_SQUARE = 4;
	private static final String TAG = GameSession.class.getSimpleName();
	private boolean userSelected;
	private boolean isGameOver;
	private boolean isWinner;

	private Difficulty difficulty;
	private int puzzle[];
	private int userPicks[];
	private int compPicks[];
	private int winningSeries[];
	private int userPickCount;
	private int compPickCount;

	private ArrayList<Integer> unselected;
	
	public boolean isCenterOpen(){
		return getPuzzle()[CENTER_SQUARE]==0;
	}

	public GameSession(Difficulty difficulty,int puzzlesize) {
		setDifficulty(difficulty);
		setGameOver(false);
		puzzle = new int[puzzlesize];
		userPicks = new int[5];
		compPicks = new int[5];
		winningSeries = new int[3];
		initPickArrays();
		userPickCount = 0;
		compPickCount = 0;
		unselected = new ArrayList<Integer>();
		for (int i = 0; i < puzzle.length; i++) {
			unselected.add(new Integer(i));
		}
		setUserSelected(false);
	}

	private void initPickArrays() {
		Arrays.fill(userPicks, 99);
		Arrays.fill(compPicks, 99);

	}

	public boolean isUserSelected() {
		return userSelected;
	}

	public void setUserSelected(boolean userSelected) {
		this.userSelected = userSelected;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public int[] getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(int[] puzzle) {
		this.puzzle = puzzle;
	}

	public int[] getUserPicks() {
		return userPicks;
	}

	public void setUserPicks(int[] userPicks) {
		this.userPicks = userPicks;
	}

	public int[] getCompPicks() {
		return compPicks;
	}

	public void setCompPicks(int[] compPicks) {
		this.compPicks = compPicks;
	}

	public int getUserPickCount() {
		return userPickCount;
	}

	public void setUserPickCount(int userPickCount) {
		this.userPickCount = userPickCount;
	}

	public ArrayList<Integer> getUnselected() {
		return unselected;
	}

	public void setUnselected(ArrayList<Integer> unselected) {
		this.unselected = unselected;
	}

	public int getCompPickCount() {
		return compPickCount;
	}

	public void setCompPickCount(int compPickCount) {
		this.compPickCount = compPickCount;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public int[] getWinningSeries() {
		return winningSeries;
	}

	public void setWinningSeries(int[] winningSeries) {
		this.winningSeries = winningSeries;
	}

	public void setWinningSeries(int[] series, int pick) {
		this.winningSeries[0] = pick;
		this.winningSeries[1] = series[0];
		this.winningSeries[2] = series[1];
		Arrays.sort(this.winningSeries);
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

}
