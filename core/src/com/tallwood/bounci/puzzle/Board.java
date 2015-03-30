package com.tallwood.bounci.puzzle;

import grid.Grid;

public class Board extends Grid<BTile>{	

	public Board(Integer height, Integer width){
		super(height, width);
	}
	
	public int getHeight(){
		return bounds[0];
	}
	
	public int getWidth(){
		return bounds[1];
	}
	
	public void reset(){
		for (BTile t : this){
			t.reset();
		}
	}
	
	public void step(){
		for(BTile t : this){
			t.step();
		}
	}
	
}
