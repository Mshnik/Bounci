package com.tallwood.bounci.puzzle;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Ball {

	public static Texture tex;
	
	final BTile start;
	final BTile goal;
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
	
	public boolean addTile(BTile t){
		if(! path.get(path.size() - 1).isAdjacent(t)) return false;
		path.add(t);
		return true;
	}
	
	public boolean isPathValid(){
		return path.get(path.size() - 1).equals(goal);
	}
	
	public BTile step(){
		if(traveled >= path.size()) return goal;
		traveled ++;
		current = path.get(traveled);
		return current;
	}
	
}
