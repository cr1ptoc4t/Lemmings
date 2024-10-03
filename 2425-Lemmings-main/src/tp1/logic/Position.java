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

		int x= this.col+d.getX();;
		int y = this.row+d.getY();

		//if(valid_position(x,y)){
			this.col= x;
			this.row=y;
		//} else if (!valid_x(x)){
			//mirar tema paredes!!!

		//}

	}

	private boolean valid_position(int x, int y) {
		return x>0 && x<Game.DIM_X && y>0 && y<Game.DIM_Y;
	}

	private boolean valid_x(int x) {
		return x>0 && x<Game.DIM_X;
	}

	public boolean vertical_border(){
		return col==0|| col== Game.DIM_Y-1;
	}

	public boolean isOver(Position p) {
		return col==p.col && row-1==p.row;
	}
	public static Position over(Position p) {
		return new Position(p.col, p.row+1);
	}
	public static Position left(Position p) {
		return new Position(p.col-1, p.row);
	}
	public static Position right(Position p) {
		return new Position(p.col+1, p.row);
	}
}