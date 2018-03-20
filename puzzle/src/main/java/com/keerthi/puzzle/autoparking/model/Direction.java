package com.keerthi.puzzle.autoparking.model;

public enum Direction {
	North, East, South, West;
	
	public int getIndex(Direction direction){
		return direction.ordinal();
	}
	public static Direction getCorrectDirection(int index){
		if(index > 3){
			index = 0;
		}
		if(index < 0){
			index = 3;
		}
		return Direction.values()[index];
	}

}
