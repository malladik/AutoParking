package com.keerthi.puzzle.autoparking.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.keerthi.puzzle.autoparking.service.ICoordinate;

/**
 * @author keerthi
 * 
 */
public class Coordinate implements ICoordinate {

	private	int x;
	private	int y;
	private Direction direction;
	 
	public Coordinate(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	//converting string to object
	public Coordinate(String cor, String dir) {
		Direction d = StringToDirectionMapping().get(dir) ;
		int [] temp = toArray(cor);
		this.x = temp[0];
		this.y = temp[1];
		this.direction = d;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY( int y) {
		this.y = y;
	}
	
	public String toString()
	{
		return ""+x+","+y+"";
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		
	}
	
	private int[] toArray(String s){
		int[] array = Stream.of(s.split(" |,"))
                .mapToInt(token -> Integer.parseInt(token))
                .toArray();
		return array;		
	}
	
	//Created map to get the related mapping of direction 
	private static Map<String, Direction> StringToDirectionMapping() {
        final Map<String, Direction> map = new HashMap<String, Direction>();
        map.put("North", Direction.North);
        map.put("East", Direction.East);
        map.put("West", Direction.West);
        map.put("South", Direction.South);
        return map;
    }
}

