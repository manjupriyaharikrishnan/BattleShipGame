package SourceClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	String name;
	Board board = new Board();
	List<String> carrier = new ArrayList<String>(); //5spaces
	List<String> battleship = new ArrayList<String>(); //4spaces
	List<String> cruiser = new ArrayList<String>(); //3spaces
	List<String> submarine = new ArrayList<String>(); //3spaces
	List<String> destroyer = new ArrayList<String>(); //2spaces
	Scanner sc=new Scanner(System.in);
	
	Player(){
		this.setName();
		this.setCarrier();
		this.setBattleship();
		this.setCruiser();
		this.setSubmarine();
		this.setDestroyer();
	}
	
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = sc.nextLine();
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public List<String> getCarrier() {
		return carrier;
	}
	public void setCarrier() {
		System.out.println("Enter cordinates of 5 Carriers separated by a space: ");
		for(int i=0;i<5;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			this.board.squares[x][y] = "Carrier";
			this.carrier.add(x+""+y);
		}
	}
	public List<String> getBattleship() {
		return battleship;
	}
	public void setBattleship() {
		System.out.println("Enter cordinates of 4 Battle ships separated by a space: ");
		for(int i=0;i<4;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			this.board.squares[x][y] = "Battle";
			this.battleship.add(x+""+y);
		}
	}
	public List<String> getCruiser() {
		return cruiser;
	}
	public void setCruiser() {
		System.out.println("Enter cordinates of 3 Cruisers separated by a space: ");
		for(int i=0;i<3;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			this.board.squares[x][y] = "Cruiser";
			this.cruiser.add(x+""+y);
		}
	}
	public List<String> getSubmarine() {
		return submarine;
	}
	public void setSubmarine() {
		System.out.println("Enter cordinates of 3 Submarines separated by a space: ");
		for(int i=0;i<3;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			this.board.squares[x][y] = "Submarine";
			this.submarine.add(x+""+y);
		}
	}
	public List<String> getDestroyer() {
		return destroyer;
	}
	public void setDestroyer() {
		System.out.println("Enter cordinates of 2 Destroyers separated by a space: ");
		for(int i=0;i<2;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			this.board.squares[x][y] = "Destroyer";
			this.destroyer.add(x+""+y);
		}
	}
	public void updatePlayers(int x,int y){
		if(!this.carrier.isEmpty()){
			updateCarrier(x,y);
		}
		if(!this.submarine.isEmpty()){
			updateSubmarine(x,y);
		}
		if(!this.cruiser.isEmpty()){
			updateCruiser(x,y);
		}
		if(!this.battleship.isEmpty()){
			updateBattle(x,y);
		}
		if(!this.carrier.isEmpty()){
			updateDestroyer(x,y);
		}
	}
	
	public void updateCarrier(int x,int y){
		if(!this.carrier.isEmpty()){
			this.carrier.remove(x+""+y);
		}
		if(this.carrier.isEmpty()){
			System.out.println("Carrier sunk");
		}
	}
	
	public void updateSubmarine(int x,int y){
		if(!this.submarine.isEmpty()){
			this.submarine.remove(x+""+y);
		}
		if(this.submarine.isEmpty()){
			System.out.println("Submarine sunk");
		}
	}

	public void updateCruiser(int x,int y){
		if(this.cruiser.isEmpty()){
			this.cruiser.remove(x+""+y);
		}
		if(this.cruiser.isEmpty()){
			System.out.println("Cruisser sunk");
		}
	}

	public void updateBattle(int x,int y){
		if(!this.battleship.isEmpty()){
				this.battleship.remove(x+""+y);
		}
		if(this.battleship.isEmpty()){
			System.out.println("Battle Ship sunk");
		}
	}

	public void updateDestroyer(int x,int y){
		if(!this.destroyer.isEmpty()){
				this.destroyer.remove(x+""+y);
		}
		if(this.destroyer.isEmpty()){
			System.out.println("Destoryer sunk");
		}
	}
	
	public void updateBoard(int x,int y){
		if(this.board.squares[x][y].equals("empty")){
			System.out.println("Miss");
			this.board.squares[x][y]= "miss";
		}
		else{
			System.out.println("Hit");
			this.board.squares[x][y] = "hit";
		}
	}
	public Boolean checkGameOver(){
		int i=0;
		for(i=0;i<10;i++){
			int j=0;
			for(j=0;j<10;j++){
				if(this.board.squares[i][j].equals("Destroyer") || 
						this.board.squares[i][j].equals("Submarine") || 
						this.board.squares[i][j].equals("Cruiser") || 
						this.board.squares[i][j].equals("Battle") || 
						this.board.squares[i][j].equals("Carrier")){
					break;
				}
			}
			if(j!=10){
				break;
			}
		}
		if(i!=10){
			return false;
		}
		else{
			return true;
		}
	}
}
