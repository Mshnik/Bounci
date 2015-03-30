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
			batch.draw(BTile.tex, 
					tileWidth * t.getX() + tileWidth * TILE_MARGIN, 
					tileHeight * t.getY() + tileHeight * TILE_MARGIN, 
					tileWidth * (1 - TILE_MARGIN * 2), tileHeight * (1 - TILE_MARGIN * 2));
		}		
		batch.end();
		active = false;
	}
	
}
