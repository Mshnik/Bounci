package com.tallwood.bounci;


import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.tallwood.bounci.puzzle.BTile;
import com.tallwood.bounci.puzzle.Ball;
import com.tallwood.bounci.puzzle.Board;

public class MouseController implements InputProcessor{

	private Ball selected;
	
	public MouseController(){
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		if(selected == null) return false;
		Board b = selected.start.board;
		if(character == Keys.LEFT){
			return selected.addTile(b.getNeighbor(selected.getEndOfPath(), 0, -1));
		}
		if(character == Keys.RIGHT){
			return selected.addTile(b.getNeighbor(selected.getEndOfPath(), 0, 1));
		}
		if(character == Keys.UP){
			return selected.addTile(b.getNeighbor(selected.getEndOfPath(), -1, 0));
		}
		if(character == Keys.DOWN){
			return selected.addTile(b.getNeighbor(selected.getEndOfPath(), 1, 0));
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(button != Buttons.LEFT) return false;
		
		
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
