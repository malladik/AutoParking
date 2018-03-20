package com.keerthi.puzzle.autoparking.service;

import java.util.HashMap;
import java.util.Map;

import com.keerthi.puzzle.autoparking.model.Commands;
import com.keerthi.puzzle.autoparking.model.Direction;

public class Car implements ICommand{
	
	IGrid grid;
	ICoordinate coordinate;
	
	public Car(ICoordinate coordinate, IGrid grid) {
		this.grid = grid;
		this.coordinate = coordinate;
		if(this.coordinate.getX()>this.grid.getHeight() || 
				this.coordinate.getY()>this.grid.getWidth() ||
				this.coordinate.getX()<1 || this.coordinate.getY()<1){
			throw new IllegalArgumentException("Illegal coordinates");
		}
	}
	
	
	public ICoordinate getCoordinate()
	{
		if(this.coordinate.getX()<1 || this.coordinate.getY()<1 || 
				this.coordinate.getX()>this.grid.getHeight() ||
				this.coordinate.getY() >this.grid.getWidth()) {
			throw new IllegalArgumentException("Illegal coordinates");
		}
		return this.coordinate;
	}
	
	public void move(String strCommand)
	{
		for (int index = 0; index < strCommand.length(); index++) {
			Commands command = StringToCommandMapping().get(String.valueOf(strCommand.charAt(index)).toUpperCase());
			if(command ==null){
				throw new IllegalArgumentException("Illegal command");
			}
			move(command);
		}
	}


	public void move(Commands command)
	{
		if(command == null) {
						
		}
		if(command == Commands.Right)
		{
			int index = coordinate.getDirection().ordinal();
			coordinate.setDirection(Direction.getCorrectDirection(index+1));
		}
		if(command == Commands.Left)
		{
			int index = coordinate.getDirection().ordinal();
			coordinate.setDirection(Direction.getCorrectDirection(index-1));
		}
		if(command == Commands.Forward)
		{
			switch(coordinate.getDirection()){
			case North:
				coordinate.setX(coordinate.getX()+1);
				break;
			case East:
				coordinate.setY(coordinate.getY()+1);
				break;
			case South:
				coordinate.setX(coordinate.getX()-1);
				break;
			case West:
				coordinate.setY(coordinate.getY()-1);
			}
		}
	}
	
	private static Map<String, Commands> StringToCommandMapping() {
        final Map<String, Commands> map = new HashMap<String, Commands>();
        map.put("R", Commands.Right);
        map.put("F", Commands.Forward);
        map.put("L", Commands.Left);
        return map;
    }
	
}
