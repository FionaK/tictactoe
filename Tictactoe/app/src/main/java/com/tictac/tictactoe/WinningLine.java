package com.tictac.tictactoe;


public class WinningLine {
	private static final String TAG = WinningLine.class.getSimpleName();
	private float x1;
	private float x2;
	private float y1;
	private float y2;
	private float second;

	public WinningLine(float width, float height, int[] series) {
		second = series[1];
		switch (series[0]) {
		case 0:
			if (second == 1) {
				x1 = getStart(width);
				x2 = getEnd(width);
				y1 = y2 = height / 6;
			} else if (second == 3) {
				y1 = getStart(height);
				y2 = getEnd(height);
				x1 = x2 = width / 6;
			} else {
				x1 = getStart(width);
				y1 = getStart(height);
				x2 = getEnd(width);
				y2 = getEnd(height);
			}
			break;
		case 1:
			y1 = getStart(height);
			y2 = getEnd(height);
			x1 = x2 = width / 2;
			break;
		case 2:
			if (second == 4) {
				x1 = getEnd(width);
				y1 = getStart(height);
				x2 = getStart(width);
				y2 = getEnd(height);
			} else {
				y1 = getStart(height);
				y2 = getEnd(height);
				x1 = x2 = width / 6 * 5;
			}
			break;
		case 3:
			x1 = getStart(width);
			x2 = getEnd(width);
			y1 = y2 = height / 2;
			break;
		case 6:
			x1 = getStart(width);
			x2 = getEnd(width);
			y1 = y2 = height / 6 * 5;
			break;
		default:
			break;
		}
	}

	private float getStart(float value) {
		return (float) (value * .15);
	}

	private float getEnd(float value) {
		return (float) (value * .85);
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public float getY2() {
		return y2;
	}

	public void setY2(float y2) {
		this.y2 = y2;
	}

}
