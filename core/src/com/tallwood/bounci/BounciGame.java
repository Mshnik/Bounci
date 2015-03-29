package com.tallwood.bounci;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tallwood.bounci.puzzle.Board;
import com.tallwood.bounci.puzzle.BTile;

public class BounciGame extends ApplicationAdapter {
	BounciCanvas canvas;
	Board b;
	
	@Override
	public void create () {
		canvas = new BounciCanvas();
		BTile.tex = new Texture("tile/Tile.png");
		b = new Board(5,10);
		
		for(int i = 0; i < 5; i++){
			for(int c = 0; c < 10; c++){
				if(i * c != 6)
					b.add(new BTile(i,c));
			}
		}
		
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		canvas.renderBoard(b);
	}
}
