package com.personal.twoPlayerGame;

public interface Game {
	void player1Turn();
	void player2Turn();
	boolean isGameOver();
	Player findWinner();
	void initialize();
}
