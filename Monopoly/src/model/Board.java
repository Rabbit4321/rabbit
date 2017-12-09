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
		
		Start = Squares[1];//maybe it should be square[0]
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
	
		//initialize board without random for now
		//organize properties by cities
		
		if(!properties.isEmpty()) {
		for(Property pr: properties) {
			if(pr.getCity().equals(Cities.Haifa)) {
				if(pr.getPropertyName().compareTo("Hadar") == 0) {
					pr.setNum(2);
					Squares[2] = pr;
				}
				if(pr.getPropertyName().compareTo("Carmel") == 0) {
					pr.setNum(3);
					Squares[3] = pr;
				}
				if(pr.getPropertyName().compareTo("Denia") == 0) {
					pr.setNum(5);
					Squares[5] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Tebrias)) {
				if(pr.getPropertyName().compareTo("Hagalil") == 0) {
				pr.setNum(6);
				Squares[6] = pr;
				}
				if(pr.getPropertyName().compareTo("Hashomer") == 0) {
				pr.setNum(8);
				Squares[8] = pr;
				}
				if(pr.getPropertyName().compareTo("Golani") == 0) {
				pr.setNum(10);
				Squares[10] = pr;
				}
			}
			if(pr.getCity().equals(Cities.KiryatShmona)) {
				if(pr.getPropertyName().compareTo("Shprinzak") == 0) {
				pr.setNum(12);
				Squares[12] = pr;
				}
				if(pr.getPropertyName().compareTo("Manahem Begin") == 0) {
				pr.setNum(14);
				Squares[14] = pr;
				}
				if(pr.getPropertyName().compareTo("Eshcol") == 0) {
				pr.setNum(15);
				Squares[15] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Netanya)) {
				if(pr.getPropertyName().compareTo("Klauzner") == 0) {
				pr.setNum(17);
				Squares[17] = pr;
				}
				if(pr.getPropertyName().compareTo("Herzel") == 0) {
				pr.setNum(19);
				Squares[19] = pr;
				}
				if(pr.getPropertyName().compareTo("Poleg") == 0) {
				pr.setNum(20);
				Squares[20] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Herzelia)) {
				if(pr.getPropertyName().compareTo("Haatzmaut") == 0) {
				pr.setNum(22);
				Squares[22] = pr;
				}
				if(pr.getPropertyName().compareTo("Ben Gurion") == 0) {
				pr.setNum(24);
				Squares[24] = pr;
				}
				if(pr.getPropertyName().compareTo("Hanasi") == 0) {
				pr.setNum(25);
				Squares[25] = pr;
				}
			}
			if(pr.getCity().equals(Cities.TelAviv)) {
				if(pr.getPropertyName().compareTo("Hatikva") == 0) {
				pr.setNum(27);
				Squares[27] = pr;
				}
				if(pr.getPropertyName().compareTo("Allenby") == 0) {
				pr.setNum(29);
				Squares[29] = pr;
				}
				if(pr.getPropertyName().compareTo("Dizengoff") == 0) {
				pr.setNum(30);
				Squares[30] = pr;
				}
			}
			if(pr.getCity().equals(Cities.BeerSheva)) {
				if(pr.getPropertyName().compareTo("Kadesh Alley") == 0) {
				pr.setNum(32);
				Squares[32] = pr;
				}
				if(pr.getPropertyName().compareTo("Ben Yehuda") == 0) {
				pr.setNum(34);
				Squares[34] = pr;
				}
				if(pr.getPropertyName().compareTo("Ramot") == 0) {
				pr.setNum(35);
				Squares[35] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Eilat)) {
				if(pr.getPropertyName().compareTo("Sheshet Hayamim") == 0) {
				pr.setNum(37);
				Squares[37] = pr;
				}
				if(pr.getPropertyName().compareTo("Hadekel") == 0) {
				pr.setNum(38);
				Squares[38] = pr;
				}
				if(pr.getPropertyName().compareTo("Hatmarim") == 0) {
				pr.setNum(40);
				Squares[40] = pr;
				}
			}
		}
		}
		//order Lucky & Question cards
		Squares[4]= new LuckyCard();
		Squares[4].setNum(4);
		Squares[9]= new LuckyCard();
		Squares[9].setNum(9);
		Squares[16]= new LuckyCard();
		Squares[16].setNum(16);
		Squares[21]= new LuckyCard();
		Squares[21].setNum(21);
		Squares[26]= new LuckyCard();
		Squares[26].setNum(26);
		Squares[36]= new LuckyCard();
		Squares[36].setNum(36);
		Squares[7]= new QuestionCard();
		Squares[7].setNum(7);
		Squares[13]= new QuestionCard();
		Squares[13].setNum(13);
		Squares[18]= new QuestionCard();
		Squares[18].setNum(18);
		Squares[23]= new QuestionCard();
		Squares[23].setNum(23);
		Squares[28]= new QuestionCard();
		Squares[28].setNum(28);
		Squares[33]= new QuestionCard();
		Squares[33].setNum(33);
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
		return null;//empty method - why? maybe there is a similar method in the code
		
	}
	/**
	 * get type of square on board
	 * */
	public String getSquareType(int numSquare) {
		for(Square s : this.AllSquares) {
			if(s.getNum() == numSquare)
				return s.getClass().toString();
		}
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
/*
	public static void main(String[] args) {
		SysData.getInstance().initProperties();
		SysData.getInstance().initQuestions();
		Board b = new Board();
		b.RestartBoard();
		b.printAllSquares();
	
	}
	*/
	
}
