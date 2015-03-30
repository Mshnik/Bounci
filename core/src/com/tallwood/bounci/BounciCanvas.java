package com.tallwood.bounci;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tallwood.bounci.puzzle.BTile;
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
	
	
	/** Margin on edges of tiles, as a percentage */
	public static float TILE_MARGIN = 0.025f;
	
	public void renderBoard(Board b){
		batch.begin();
		active = true;
		float tileWidth = Gdx.graphics.getWidth() /	b.getWidth();
		float tileHeight = Gdx.graphics.getHeight() / b.getHeight();

		for(BTile t : b){
			if(t.needsLocUpdate){
				t.graphX = tileWidth * t.getX() + tileWidth * TILE_MARGIN;
				t.graphY = tileHeight * t.getY() + tileHeight * TILE_MARGIN;
				t.width = tileWidth * (1 - TILE_MARGIN * 2);
				t.height = tileHeight * (1 - TILE_MARGIN * 2);
				t.needsLocUpdate = false;
			}
			batch.draw(BTile.tex, t.graphX, t.graphY, t.width, t.height);
		}		
		batch.end();
		active = false;
	}
	
}
