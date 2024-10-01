package tp1.logic;

import java.util.Objects;
/**
 *
 * Immutable class to encapsulate and manipulate positions in the game board
 *
 */
public class Position {
	private int col;
	private int row;

	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	//duplicador de posicion
	public Position (Position posicion2){
		this.col = posicion2.col;
		this.row = posicion2.row;
	}


	//TODO fill your code


	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}
	@Override
	public boolean equals(Object obj) {
		boolean b;
		if (this == obj)
			b=true;
		if (obj == null || getClass() != obj.getClass())
			b=false;
		else {
			Position other = (Position) obj;		 //conversion explicita
			b = col == other.col && row == other.row;
		}
		return b;
	}


	public void actualiza(Direction d) {
		//revisar el tema de las paredes!!

		this.col+=d.getX();
		this.row+=d.getY();

		if(this.col>=Game.DIM_X) this.col=Game.DIM_X-1;
		else if (this.row>=Game.DIM_Y) this.row=Game.DIM_Y-1;
		else if (this.col<0) this.col=0;
		else if (this.row<0) this.row=0;

	}

	private boolean valid_position(int x, int y) {
		return x>0 && x<Game.DIM_X && y>0 && y<Game.DIM_Y;
	}

}