package com.keerthi.puzzle.autoparking.service;

import com.keerthi.puzzle.autoparking.model.Direction;

public interface ICoordinate {
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public Direction getDirection();
	public void setDirection(Direction direction);

}
