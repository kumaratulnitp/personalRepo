package com.personal.twoPlayerGame;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private String name;
	private List<Piece> piece;
	public void playTurn(Move move) {
		//do something
	}
}
