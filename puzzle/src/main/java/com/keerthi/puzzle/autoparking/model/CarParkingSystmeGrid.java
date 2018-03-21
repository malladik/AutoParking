package com.keerthi.puzzle.autoparking.model;

import java.util.stream.Stream;

import com.keerthi.puzzle.autoparking.service.IGrid;
/**
 * @author keerthi
 * Model for Grid
 */
public class CarParkingSystmeGrid implements IGrid {

	private int width;
	private int height;
	
	public CarParkingSystmeGrid(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public CarParkingSystmeGrid(String s) {
		int [] temp = toArray(s);
		this.width = temp[0];
		this.height =temp[1];
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(int width) {
		this.width = width;		
	}

	public void setHeight(int height) {
		this.height = height;		
	}
	
	private int[] toArray(String s){
		int[] array = Stream.of(s.split(" |,"))
                .mapToInt(token -> Integer.parseInt(token))
                .toArray();
		return array;		
	}

}

