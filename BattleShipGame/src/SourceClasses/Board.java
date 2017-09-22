package SourceClasses;

public class Board {
	String[][] squares = new String[10][10];

	Board(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				squares[i][j]="empty";
			}
		}
	}
	public String[][] getSquares() {
		return squares;
	}

	public void setSquares(String[][] squares) {
		this.squares = squares;
	}

	
}
