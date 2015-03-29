package com.tallwood.bounci.puzzle;

import grid.Grid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board extends Grid<BTile>{	

	public Board(Integer height, Integer width){
		super(height, width);
	}
	
	/** Margin on edges of tiles, as a percentage */
	public static float margin = 0.05f;
	
	public void render(SpriteBatch batch, float width, float height){
		float tileWidth = width / this.bounds[1];
		float tileHeight = height / this.bounds[0];

		for(BTile t : this){
			batch.draw(BTile.tex, 
					tileWidth * t.getX() + tileWidth * margin, 
					tileHeight * t.getY() + tileHeight * margin, 
					tileWidth * (1 - margin), tileHeight * (1 - margin));
		}
	}


}
