package com.tallwood.bounci.puzzle;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Ball {

	public static Texture tex;
	
	public final BTile start;
	public final BTile goal;
	private BTile current;
	
	private ArrayList<BTile> path;
	private int traveled;
	
	public Ball(BTile start, BTile goal){
		this.start = start;
		this.goal = goal;
		if(start.equals(goal))
			throw new IllegalArgumentException("Start equals Goal for Ball");
		path = new ArrayList<BTile>();
		reset();
	}
	
	public void reset(){
		current = start;
		path.clear();
		path.add(start);
		traveled = 0;
	}
	
	public BTile getEndOfPath(){
		return path.get(path.size() - 1);
	}
	
	public boolean addTile(BTile t){
		if(t == null || ! getEndOfPath().isAdjacent(t)) return false;
		path.add(t);
		return true;
	}
	
	public boolean isPathValid(){
		return getEndOfPath().equals(goal);
	}
	
	public BTile step(){
		if(traveled >= path.size()) return goal;
		traveled ++;
		current = path.get(traveled);
		return current;
	}
	
}
