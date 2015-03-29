package com.tallwood.bounci;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tallwood.bounci.puzzle.Board;

public class BounciCanvas {

	protected SpriteBatch batch;
	
	/** True if this is currently drawing (between begin and end pair) */
	private boolean active;
	
	public BounciCanvas(){
		batch = new SpriteBatch();
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void renderBoard(Board b){
		batch.begin();
		active = true;
		b.render(batch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		active = false;
	}
	
	
}
