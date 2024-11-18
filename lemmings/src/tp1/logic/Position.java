package tp1.logic;

import java.util.Objects;

/**
 * Immutable class to encapsulate and manipulate positions in the game board
 */
public class Position {
	private int col;
	private int row;

	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	//duplicador de posicion
	public Position(Position pos) {
		this.col = pos.get_col();
		this.row = pos.get_row();
	}


	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}

	@Override
	public boolean equals(Object obj) {
		boolean b;
		if (this == obj)
			b = true;
		if (obj == null || getClass() != obj.getClass())
			b = false;
		else {
			Position other = (Position) obj;         //conversion explicita
			b = col == other.get_col() && row == other.get_row();
		}
		return b;
	}

	private int get_col() {
		return this.col;
	}

	private int get_row() {
		return this.row;
	}


	public void actualiza(Direction d) {
		this.col += d.getX();
		this.row += d.getY();
	}

	public boolean valid_position() {
		return col >= 0 && col < Game.DIM_X && row >= 0 && row < Game.DIM_Y;
	}

	public static Position debajo(Position p) {
		return new Position(p.get_col(), p.get_row() + 1);
	}


	public static int convert(char letter) {
		return letter - 'A';
	}

}