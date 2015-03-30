package com.tallwood.bounci.puzzle;

import java.util.HashSet;

public class Puzzle {

	HashSet<Ball> balls;
	public final Board board;
	
	public Puzzle(Board board, Ball... balls){
		this.board = board;
		this.balls = new HashSet<Ball>();
		for(Ball b : balls){
			if(! board.contains(b.start))
				throw new IllegalArgumentException(b.start + " doesn't exist");
			if(! board.contains(b.goal))
				throw new IllegalArgumentException(b.goal + " doesn't exist");
			this.balls.add(b);
		}
	}
	
	public boolean isStartable(){
		for(Ball b : balls){
			if(! b.isPathValid())
				return false;
		}
		return true;
	}
	
	public void reset(){
		board.reset();
		for(Ball b : balls){
			b.reset();
		}
	}
	
	
}
