package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;

public class Board {
	private ArrayList<Square> AllSquares;
	private Square Start = null;
	private Square Jail = null;
	
    public Board() {
    	super();
    }

	/**
	 * restart the board and locate any square in her place (notice: 'Go to jail','Free parking','Jail','Start' are already defined in specific place
	 * @param list of squares*/
	
	public void RestartBoard() {
	/**TODO*/
		AllSquares = new ArrayList<Square>(GeneralVariables.getNumSquaresInGame());
		for(Square s : AllSquares) { // initialize squares
			s = new Square();
		}
		Square[] Squares = new Square[GeneralVariables.getNumSquaresInGame()+1];
		int [] OptionsForEdgesBoard= {1,11,21,31};
		ArrayList<Property> properties = SysData.getInstance().getProperties();
		
		//Initialize all the data from SysData (json files)
		
		
		

		
		
		//Randomly determine the edges-Initialize start,jail and go to jail squares
		
	/*	int rnd = new Random().nextInt(OptionsForEdgesBoard.length);
		Squares[OptionsForEdgesBoard[rnd]] = new Square();
		Squares[OptionsForEdgesBoard[rnd]].setNum(OptionsForEdgesBoard[rnd]);
		Squares[OptionsForEdgesBoard[rnd]].setType(TypeSquares.START);
		Start = Squares[OptionsForEdgesBoard[rnd]];
		Squares[(OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame()] = new Square();
		Squares[(OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame()].setNum((OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame());
		Squares[(OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame()].setType(TypeSquares.GO_TO_JAIL);
		int posGo= (OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame();
		System.out.println(posGo);
		System.out.println((posGo + 20) % GeneralVariables.getNumSquaresInGame());
		Squares[(posGo + 20) % GeneralVariables.getNumSquaresInGame()] = new Square();
		Squares[(posGo + 20) % GeneralVariables.getNumSquaresInGame()].setNum((posGo + 20) % GeneralVariables.getNumSquaresInGame());
		Squares[(posGo+ 20) % GeneralVariables.getNumSquaresInGame()].setType(TypeSquares.JAIL);
		Jail = Squares[(posGo + 20) % GeneralVariables.getNumSquaresInGame()];*/

		Start = Squares[1];
		Squares[1] = new Square();
		Squares[1].setNum(1);
		Squares[1].setType(TypeSquares.START);
		Squares[11]= new Square();
		Squares[11].setNum(11);
		Squares[11].setType(TypeSquares.GO_TO_JAIL);
		Squares[31]= new Square();
		Squares[31].setNum(31);
		Squares[31].setType(TypeSquares.JAIL);
		Jail = Squares[31];
						
		for(Property p: properties) {
			System.out.println(p);
		}
	
		//initialize board without random for now
		//organize properties by cities
		
		if(!properties.isEmpty()) {
		for(Property pr: properties) {
			if(pr.getCity().equals(Cities.Haifa)) {
				pr.setNum(2);
				Squares[2] = pr;
				pr.setNum(3);
				Squares[3] = pr;
				pr.setNum(5);
				Squares[5] = pr;
			}
			if(pr.getCity().equals(Cities.KiryatShmona)) {
				pr.setNum(7);
				Squares[7] = pr;
				pr.setNum(9);
				Squares[9] = pr;
				pr.setNum(10);
				Squares[10] = pr;
			}
			if(pr.getCity().equals(Cities.Netanya)) {
				pr.setNum(17);
				Squares[17] = pr;
				pr.setNum(18);
				Squares[18] = pr;
				pr.setNum(20);
				Squares[20] = pr;
			}
			if(pr.getCity().equals(Cities.TelAviv)) {
				pr.setNum(22);
				Squares[22] = pr;
				pr.setNum(23);
				Squares[23] = pr;
				pr.setNum(25);
				Squares[25] = pr;
			}
			if(pr.getCity().equals(Cities.BeerSheva)) {
				pr.setNum(27);
				Squares[27] = pr;
				pr.setNum(29);
				Squares[29] = pr;
				if(Squares[31] == null) {
					pr.setNum(31);
					Squares[31] = pr;
				}
				else if(Squares[21] == null) {
					pr.setNum(21);
					Squares[21] = pr;
				}
				else if(Squares[11] == null) {
					pr.setNum(11);
					Squares[11] = pr;
				}
				else if(Squares[1] == null) {
					pr.setNum(1);
					Squares[1] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Eilat)) {
				pr.setNum(32);
				Squares[32] = pr;
				pr.setNum(33);
				Squares[33] = pr;
				pr.setNum(35);
				Squares[35] = pr;
			}
			if(pr.getCity().equals(Cities.Herzelia)) {
				pr.setNum(37);
				Squares[37] = pr;
				pr.setNum(38);
				Squares[38] = pr;
				pr.setNum(40);
				Squares[40] = pr;
			}
		}
		}
		//order Lucky & Question cards
		Squares[4]= new LuckyCard();
		Squares[4].setNum(4);
		Squares[8]= new LuckyCard();
		Squares[8].setNum(8);
		Squares[16]= new LuckyCard();
		Squares[16].setNum(16);
		Squares[23]= new LuckyCard();
		Squares[23].setNum(24);
		Squares[28]= new LuckyCard();
		Squares[28].setNum(28);
		Squares[36]= new LuckyCard();
		Squares[36].setNum(36);
		Squares[6]= new QuestionCard();
		Squares[6].setNum(6);
		Squares[13]= new QuestionCard();
		Squares[13].setNum(13);
		Squares[19]= new QuestionCard();
		Squares[19].setNum(19);
		Squares[25]= new QuestionCard();
		Squares[25].setNum(26);
		Squares[30]= new QuestionCard();
		Squares[30].setNum(30);
		Squares[34]= new QuestionCard();
		Squares[34].setNum(34);
		Squares[39]= new QuestionCard();
		Squares[39].setNum(39);
		
		for(int i =1; i< Squares.length ; i++) {
			AllSquares.add(Squares[i]);
		}
		
	}
	
	/**
	 * Move player to steps on the board
	 * @param player,steps
	 * @return if succeed - current square, 
	 * */
	
	public Square MovePlayer(PlayerInGame p,int steps) {
		return null;
		
	}
	
	public Square getStart() {
		return Start;
	}

	public ArrayList<Square> getAllSquares() {
		return AllSquares;
	}

	public void setAllSquares(ArrayList<Square> allSqures) {
		AllSquares = allSqures;
	}
	


	@Override
	public String toString() {
		return "Board [AllSquares=" + AllSquares.size() + ", Start=" + Start.getNum() + ", Jail=" + Jail.getNum() + "]";
	}

	public void printAllSquares() {
		for(Square s : AllSquares) {
			if(s.getType() != null)
				System.out.println("Square: "+s.getNum()+ " type " +s.getType().toString());
			else
				System.out.println("Square: "+s.getNum()+ " "+ s.toString() );
		}
	}

	public Square getJail() {
		return Jail;
	}

	public void setJail(Square jail) {
		Jail = jail;
	}

	public static void main(String[] args) {
		SysData.getInstance().initProperties();
		SysData.getInstance().initQuestions();
		Board b = new Board();
		b.RestartBoard();
		b.printAllSquares();
	
	}
}
