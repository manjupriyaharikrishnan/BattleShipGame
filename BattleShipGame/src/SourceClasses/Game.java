package SourceClasses;
import java.util.Scanner;

public class Game {
	public static void main(String args[]){
		System.out.println("Welcome to Battle Ship Game!");
		System.out.println("Player1 enter your name");
		Player player1 = new Player();
		
		System.out.println("Player2 enter your name");
		Player player2 = new Player();
		
		Boolean gameOver = false;
		String winner = " ";
		Scanner scan = new Scanner(System.in);
		
		while(!gameOver){
			System.out.println("Player1 turn: Enter the Coordinates of a square separated by space");
			int x = scan.nextInt();
			int y = scan.nextInt();
			player2.updateBoard(x,y);
			player2.updatePlayers(x,y);
			gameOver = player2.checkGameOver();
			if(gameOver){
				winner = player1.getName();
				break;
			}
			
			System.out.println("Player2 turn: Enter the Coordinates of a square separated by space");
			int u = scan.nextInt();
			int v = scan.nextInt();
			player1.updateBoard(u,v);
			player1.updatePlayers(u,v);
			gameOver = player1.checkGameOver();
			if(gameOver){
				winner = player2.getName();
				break;
			}
		}
		
		System.out.println("Game Over. Winner is " + winner);
	}
}
