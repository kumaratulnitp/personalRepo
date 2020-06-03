package com.personal.twoPlayerGame;

import java.util.List;

public class ChessGame implements Game{
	
	private Player player1;
	private Player player2;
	private List<Move> player1moves;
	private List<Move> player2moves;
	
	
	@Override
	public void player1Turn() {
		//ask for a move
		Move move = new Move(new Position(), new Position(), new Piece());
		
		
	}

	@Override
	public void player2Turn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player findWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
