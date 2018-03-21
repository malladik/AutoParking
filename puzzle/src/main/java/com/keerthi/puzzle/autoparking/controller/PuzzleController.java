package com.keerthi.puzzle.autoparking.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.keerthi.puzzle.autoparking.model.CarParkingSystmeGrid;
import com.keerthi.puzzle.autoparking.model.Coordinate;
import com.keerthi.puzzle.autoparking.service.Car;
import com.keerthi.puzzle.autoparking.service.ICoordinate;
import com.keerthi.puzzle.autoparking.service.IGrid;

@Controller
public class PuzzleController {
	
	private static  ApplicationContext applicationContext;

	@GetMapping(value = "/welcome")
	public ModelAndView welcomeController() {

		return new ModelAndView("hello");
	}
	
	@GetMapping(value = "/puzzle")
	public ModelAndView getPuzzleController( ModelMap model) {
		 return new ModelAndView("puzzle");
	}
	/**
	 * used GET request method with default values(For grid and coordinates) 
	 * if user sends with null values.
	 */
	@GetMapping(value = "/puzzleResult")
    public ModelAndView parkingController(@RequestParam(name="grid", defaultValue="15 15") String grid, 
    	@RequestParam(name="coordinate", defaultValue="1 1") String coord,@RequestParam("direction") String direction,
    	@RequestParam("commands") String command, ModelMap model){
		
        ModelAndView parkingModelView = new ModelAndView("puzzleResult");
        
        IGrid igrid = new CarParkingSystmeGrid(grid);
        ICoordinate coordinate = new Coordinate(coord,direction);
        Car car = new Car(coordinate,igrid);
        // Checking not to get to exception to UI
        if (command.toUpperCase().matches("^[RLF]+$")) {
        	car.move(command);
        }else{
        	command = "Wrong Command String";
        }
        model.addAttribute("Grid", grid);
        model.addAttribute("Direction", direction);
        model.addAttribute("Coordinates", coord);
        model.addAttribute("Command", command);
        model.addAttribute("Result", car.getCoordinate().toString());
         return parkingModelView;
    }
}
