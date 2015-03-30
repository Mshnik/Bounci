package com.tallwood.bounci;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.tallwood.bounci.puzzle.Ball;
import com.tallwood.bounci.puzzle.Board;
import com.tallwood.bounci.puzzle.BTile;
import com.tallwood.bounci.puzzle.Puzzle;

public class BounciGame implements Screen {
	BounciCanvas canvas;
	Puzzle p;
	MouseController m;
	
	public BounciGame(){
		System.out.println("Created");

		canvas = new BounciCanvas();
		m = new MouseController();
		BTile.tex = new Texture("tile/Tile.png");
		Ball.tex = new Texture("ball/ball.png");
		
		Board b = new Board(5,10);
		for(int i = 0; i < 5; i++){
			for(int c = 0; c < 10; c++){
				if(i * c != 6)
					b.add(new BTile(b, i,c));
			}
		}
		
		p = new Puzzle(b, new Ball(b.get(0,0), b.get(4,4)));
		
	
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		System.out.println("Rendered " + delta);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		canvas.renderBoard(p.board);		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
