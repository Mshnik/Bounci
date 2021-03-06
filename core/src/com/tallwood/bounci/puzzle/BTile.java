package com.tallwood.bounci.puzzle;

import grid._2D.Tile2D;

import com.badlogic.gdx.graphics.Texture;

import common.types.Tuple2;

public class BTile extends Tuple2<Integer, Integer> implements Tile2D {

	public static Texture tex;
	public final Board board;
	
	public boolean needsLocUpdate;
	public float graphX;
	public float graphY;
	public float width;
	public float height;
	
	
	public BTile(Board b, Integer first, Integer second) {
		super(first, second);
		this.board = b;
		needsLocUpdate = true;
	}
	
	public int getX(){
		return _2;
	}
	
	public int getY(){
		return _1;
	}
	
	public int getRow(){
		return _1;
	}
	
	public int getCol(){
		return _2;
	}

	@Override
	public Integer[] getLocation() {
		return new Integer[]{_1, _2};
	}

	public void reset(){
		
	}
	
	public void step(){
		
	}
	
	public boolean isAdjacent(BTile other){
		int diffX = Math.abs(getX() - other.getX());
		int diffY = Math.abs(getY() - other.getY());
		
		return diffX == 1 && diffY == 0 || diffY == 1 && diffX == 0;
	}
	
	public boolean containsPoint(int x, int y){
		return x >= graphX && y >= graphY && x <= graphX + width && y <= graphY + height;
	}
	
}
