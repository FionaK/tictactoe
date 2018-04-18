package com.tictac.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.FontMetrics; 
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

public class ThreeByThree extends View {

	private static final String TAG = ThreeByThree.class.getSimpleName();
	private final GameActivity gameActivity;
    private boolean isFirstSelect=true;
    private boolean isSecondSelect=false;
	private float width; // width of one tile
	private float height; // height of one tile
	private int selX; // X index of selection
	private int selY; // Y index of selection
	private final Rect selRect = new Rect();
    private int count=0;
    private String player="";
	public ThreeByThree(Context context,String player) {
		super(context);
		this.gameActivity = (GameActivity) context;
		this.player=player;
		setFocusable(true);
		setFocusableInTouchMode(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.board_background));
		canvas.drawRect(0, 0, getWidth(), getHeight(), background);

		Paint dark = new Paint();
		dark.setColor(getResources().getColor(R.color.board_dark));

		Paint hilite = new Paint();
		hilite.setColor(getResources().getColor(R.color.board_foreground));

		Paint light = new Paint();
		light.setColor(getResources().getColor(R.color.board_light));

		Paint winner = new Paint();
		winner.setColor(getResources().getColor(R.color.board_hint_0));
		winner.setStrokeWidth(10);
		winner.setStrokeCap(Paint.Cap.ROUND);

		for (int i = 0; i < 3; i++) {
			// horizontal

			canvas.drawLine(0, i * height, getWidth(), i * height, dark);
			canvas.drawLine(0, i * height + 1, getWidth(), i * height + 1, hilite);
			// vertical
			canvas.drawLine(i * width, 0, i * width, getHeight(), dark);
			canvas.drawLine(i * width + 1, 0, i * width + 1, getHeight(), hilite);
		}

		if (gameActivity.getSession().isGameOver() && gameActivity.getSession().isWinner()) {
			WinningLine line = new WinningLine(getWidth(), getHeight(), gameActivity.getSession().getWinningSeries());
			canvas.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2(), winner);
		}

		// Define color and style for 'X' and 'O'
		Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
		foreground.setColor(getResources().getColor(R.color.board_foreground));
		foreground.setStyle(Style.FILL);
		foreground.setTextSize(height / 3 * 1.25f);
		foreground.setTextScaleX(width / height);
		foreground.setTextAlign(Paint.Align.CENTER);

		// Draw the number in the center of the tile
		FontMetrics fm = foreground.getFontMetrics();
		// Centering in Y: measure ascent/descent first
		float y = height / 2 - (fm.ascent + fm.descent) / 2;

		if (gameActivity.getSession().isUserSelected() && !gameActivity.getSession().isGameOver() && player.equals("one")) {
          gameActivity.compSelect();
		invalidate();
		}

		int[] offset = new int[] { 1, 3, 5};
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				canvas.drawText(gameActivity.getSqureString(i, j), offset[i] * width / 2, (j) * height + y, foreground);
			}
		}

		// Draw the selection...
		if (gameActivity.getUnselectedCount() < 9) {
			Paint selected = new Paint();
			selected.setColor(getResources().getColor(R.color.board_selected));
			canvas.drawRect(selRect, selected);
		}

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		width = w / 3f;
		height = h / 3f;
		getRect(selX, selY, selRect);
		Log.d(TAG, "onSizeChanged: width " + width + ", height " + height);
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		count=count+1;
		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return super.onTouchEvent(event);


		if(gameActivity.getSession().isUserSelected() && !gameActivity.getSession().isGameOver() && player.equals("two") ){
			secondSelect(event);

		}

		else if(!gameActivity.getSession().isGameOver()) {
			firstSelect(event);


		}



		return true;
	}


	public  void secondSelect(MotionEvent event){

		select((int) (event.getX() / width), (int) (event.getY() / height));
		Log.d(TAG, "onTouchEvent: x " + selX + ", y " + selY);
		setUserTwoSelectedTile(selY * 3 + selX);

	}

	public void firstSelect(MotionEvent event){

		select((int) (event.getX() / width), (int) (event.getY() / height));
		Log.d(TAG, "onTouchEvent: x " + selX + ", y " + selY);
		setSelectedTile(selY * 3 + selX);


	}
	public void setSelectedTile(int tile) {
		if (gameActivity.setSquareIfValid(selX, selY, tile)) {
			invalidate();// may change hints
		} else {
			Log.d(TAG, "setSelectedTile: invalid: " + tile);
			startAnimation(AnimationUtils.loadAnimation(gameActivity, R.anim.shake));
		}
	}


	public void setUserTwoSelectedTile(int tile){

		if (gameActivity.setSquareIfValidTwo(selX, selY, tile)) {
			invalidate();// may change hints
		} else {
			Log.d(TAG, "setSelectedTile: invalid: " + tile);
			startAnimation(AnimationUtils.loadAnimation(gameActivity, R.anim.shake));
		}
	}


	private void select(int x, int y) {
		invalidate(selRect);
		selX = Math.min(Math.max(x, 0), 8);
		selY = Math.min(Math.max(y, 0), 8);
		getRect(selX, selY, selRect);
		invalidate(selRect);
	}

	private void getRect(int x, int y, Rect rect) {
		float big_width = width;
		float big_height = height;
		rect.set((int) (x * big_width), (int) (y * big_height), (int) (x * big_width + big_width),
				(int) (y * big_height + big_height));
	}

}
