package com.keerthi.puzzle.autoparking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.keerthi.puzzle.autoparking.model.CarParkingSystmeGrid;
import com.keerthi.puzzle.autoparking.model.Coordinate;
import com.keerthi.puzzle.autoparking.model.Direction;
import com.keerthi.puzzle.autoparking.service.Car;
import com.keerthi.puzzle.autoparking.service.ICoordinate;
import com.keerthi.puzzle.autoparking.service.IGrid;

/**
 * @author keerthim
 *
 */
public class CarParkingSystemGridTest {
	
	IGrid grid = new CarParkingSystmeGrid(15,15);
	
	/********************************
	 * 		Edge case Test *
	 ********************************/
	
	@Test(expected = IllegalArgumentException.class)
	public void whenInitialCoordinatesLessThanMin() {
		ICoordinate coordinate = new Coordinate(1,-1,Direction.North);
		Car car = new Car(coordinate,grid);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenInitialCoordinatedGreaterThanMax() {
		ICoordinate coordinate = new Coordinate(16,1,Direction.North);
		Car car = new Car(coordinate,grid);
	}
	/**
	 * Edge Testing - when resulting coordinates go below
	 * [1,1] base coordinates
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenResultingCoordintesEndOutOfGrid() {
		ICoordinate coordinate = new Coordinate(1,1,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("LFFFF");
		car.getCoordinate().toString();
	}
	
	/**
	 * Edge Testing - when resulting coordinates end out of the Grid
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenResultingCoordintesEndOverTheGrid() {
		ICoordinate coordinate = new Coordinate(14,14,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("RFFF");
		car.getCoordinate().toString();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenWrongCommandGiven() {
		ICoordinate coordinate = new Coordinate(5,5,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("jkRFLF");
	}
	
	@Test
	public void when1stCommandGiven() {
		ICoordinate coordinate = new Coordinate(5,5,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("RFLFRFLF");
		assertEquals("7,7", car.getCoordinate().toString());
	}
	
	@Test
	public void when2ndCommandGiven() {
		ICoordinate coordinate = new Coordinate(6,6,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("FFLFFLFFLFF");
		assertEquals("6,6", car.getCoordinate().toString());
	}
	
	@Test
	public void when3rdCommandGiven() {
		ICoordinate coordinate = new Coordinate(5,5,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("FLFLFFRFFF");
		assertEquals("4,1", car.getCoordinate().toString());
	}
	
	//checking changing direction without forward command 
	@Test
	public void whenWithoutForwardCommandGiven() {
		ICoordinate coordinate = new Coordinate(5,5,Direction.North);
		Car car = new Car(coordinate,grid);
		car.move("RLLRLR");
		assertEquals("5,5", car.getCoordinate().toString());
	}
	
	@Test
	public void whenInitialDirectionChangedToEastGiven() {
		ICoordinate coordinate = new Coordinate(5,5,Direction.East);
		Car car = new Car(coordinate,grid);
		car.move("RFLFRFLF");
		assertEquals("3,7", car.getCoordinate().toString());
	}
	
}
