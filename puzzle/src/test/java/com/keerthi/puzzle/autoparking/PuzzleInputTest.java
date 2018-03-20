package com.keerthi.puzzle.autoparking;

import java.util.Scanner;

import org.junit.Test;

import com.keerthi.puzzle.autoparking.model.CarParkingSystmeGrid;
import com.keerthi.puzzle.autoparking.model.Coordinate;
import com.keerthi.puzzle.autoparking.service.Car;
import com.keerthi.puzzle.autoparking.service.ICoordinate;
import com.keerthi.puzzle.autoparking.service.IGrid;

public class PuzzleInputTest {
	
	IGrid grid = new CarParkingSystmeGrid(15,15);
	
		   @Test
		   public void testShowUsageWhenCommandLineArgumentsSupplied() {
			// create a scanner so we can read the command-line input
			    Scanner scanner = new Scanner(System.in);

			    //  prompt for the Coordinates
			    System.out.print("Enter your Car coordinates: ");
			    ICoordinate coordinate = new Coordinate(scanner.next(),"North");
			     
			    Car car = new Car(coordinate,grid);
			    
			    //  prompt for the Coordinates
			    System.out.print("Enter your Command: ");
			    car.move(scanner.next());
			    scanner.close();
			    //Output
			    System.out.println("We should get the position '"+car.getCoordinate().toString()+"'");
		   }
}
