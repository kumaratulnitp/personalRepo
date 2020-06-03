package com.personal.twoPlayerGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Move {
	private Position from;
	private Position to;
	private Piece piece;
}
