package com.keerthi.puzzle.autoparking.service;

import com.keerthi.puzzle.autoparking.model.Commands;

public interface ICommand {
	public void move(Commands command);
}
