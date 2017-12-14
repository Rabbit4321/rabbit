package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;

public class Board {
	private static ArrayList<Square> AllSquares;
	private static Square Start = null;
	private Square Jail = null;
	
    public Board() {
    	super();
    	RestartBoard();
    //	printAllSquares();
    	
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
		Square[] Squares = new Square[GeneralVariables.getNumSquaresInGame()];
	//	int [] OptionsForEdgesBoard= {1,11,21,31};
		ArrayList<Property> properties = SysData.getInstance().getProperties();
		
		
		Squares[0] = new Square();
		Squares[0].setNum(0);
		Squares[0].setType(TypeSquares.START);
		Start = Squares[0];//maybe it should be square[0]
		
		Squares[10]= new Square();
		Squares[10].setNum(10);
		Squares[10].setType(TypeSquares.GO_TO_JAIL);
		Squares[30]= new Square();
		Squares[30].setNum(30);
		Squares[30].setType(TypeSquares.JAIL);
		Jail = Squares[30];
	
		//initialize board without random for now
		//organize properties by cities
		
		if(!properties.isEmpty()) {
		for(Property pr: properties) {
			if(pr.getCity().equals(Cities.Haifa)) {
				if(pr.getPropertyName().compareTo("Hadar") == 0) {
					pr.setNum(1);
					Squares[1] = pr;
				}
				if(pr.getPropertyName().compareTo("Carmel") == 0) {
					pr.setNum(2);
					Squares[2] = pr;
				}
				if(pr.getPropertyName().compareTo("Denia") == 0) {
					pr.setNum(4);
					Squares[4] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Tebrias)) {
				if(pr.getPropertyName().compareTo("Hagalil") == 0) {
				pr.setNum(5);
				Squares[5] = pr;
				}
				if(pr.getPropertyName().compareTo("Hashomer") == 0) {
				pr.setNum(7);
				Squares[7] = pr;
				}
				if(pr.getPropertyName().compareTo("Golani") == 0) {
				pr.setNum(9);
				Squares[9] = pr;
				}
			}
			if(pr.getCity().equals(Cities.KiryatShmona)) {
				if(pr.getPropertyName().compareTo("Shprinzak") == 0) {
				pr.setNum(11);
				Squares[11] = pr;
				}
				if(pr.getPropertyName().compareTo("Manahem Begin") == 0) {
				pr.setNum(13);
				Squares[13] = pr;
				}
				if(pr.getPropertyName().compareTo("Eshcol") == 0) {
				pr.setNum(14);
				Squares[14] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Netanya)) {
				if(pr.getPropertyName().compareTo("Klauzner") == 0) {
				pr.setNum(16);
				Squares[16] = pr;
				}
				if(pr.getPropertyName().compareTo("Herzel") == 0) {
				pr.setNum(18);
				Squares[18] = pr;
				}
				if(pr.getPropertyName().compareTo("Poleg") == 0) {
				pr.setNum(19);
				Squares[19] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Herzelia)) {
				if(pr.getPropertyName().compareTo("Haatzmaut") == 0) {
				pr.setNum(21);
				Squares[21] = pr;
				}
				if(pr.getPropertyName().compareTo("Ben Gurion") == 0) {
				pr.setNum(23);
				Squares[23] = pr;
				}
				if(pr.getPropertyName().compareTo("Hanasi") == 0) {
				pr.setNum(24);
				Squares[24] = pr;
				}
			}
			if(pr.getCity().equals(Cities.TelAviv)) {
				if(pr.getPropertyName().compareTo("Hatikva") == 0) {
				pr.setNum(26);
				Squares[26] = pr;
				}
				if(pr.getPropertyName().compareTo("Allenby") == 0) {
				pr.setNum(28);
				Squares[28] = pr;
				}
				if(pr.getPropertyName().compareTo("Dizengoff") == 0) {
				pr.setNum(29);
				Squares[29] = pr;
				}
			}
			if(pr.getCity().equals(Cities.BeerSheva)) {
				if(pr.getPropertyName().compareTo("Kadesh Alley") == 0) {
				pr.setNum(31);
				Squares[31] = pr;
				}
				if(pr.getPropertyName().compareTo("Ben Yehuda") == 0) {
				pr.setNum(32);
				Squares[32] = pr;
				}
				if(pr.getPropertyName().compareTo("Ramot") == 0) {
				pr.setNum(34);
				Squares[34] = pr;
				}
			}
			if(pr.getCity().equals(Cities.Eilat)) {
				if(pr.getPropertyName().compareTo("Sheshet Hayamim") == 0) {
				pr.setNum(36);
				Squares[36] = pr;
				}
				if(pr.getPropertyName().compareTo("Hadekel") == 0) {
				pr.setNum(37);
				Squares[37] = pr;
				}
				if(pr.getPropertyName().compareTo("Hatmarim") == 0) {
				pr.setNum(39);
				Squares[39] = pr;
				}
			}
		}
		}
		//order Lucky & Question cards
		Squares[3]= new LuckyCard();
		Squares[3].setNum(3);
		Squares[8]= new LuckyCard();
		Squares[8].setNum(8);
		Squares[15]= new LuckyCard();
		Squares[15].setNum(15);
		Squares[20]= new LuckyCard();
		Squares[20].setNum(20);
		Squares[25]= new LuckyCard();
		Squares[25].setNum(25);
		Squares[35]= new LuckyCard();
		Squares[35].setNum(35);
		Squares[6]= new QuestionCard();
		Squares[6].setNum(6);
		Squares[12]= new QuestionCard();
		Squares[12].setNum(12);
		Squares[17]= new QuestionCard();
		Squares[17].setNum(17);
		Squares[22]= new QuestionCard();
		Squares[22].setNum(22);
		Squares[27]= new QuestionCard();
		Squares[27].setNum(27);
		Squares[32]= new QuestionCard();
		Squares[32].setNum(32);
		Squares[33]= new QuestionCard();
		Squares[33].setNum(33);
		Squares[38]= new QuestionCard();
		Squares[38].setNum(38);
		
		for(int i =0; i< Squares.length ; i++) {
			AllSquares.add(Squares[i]);
		}
		
	}
	
	/**
	 * Move player to steps on the board
	 * @param player,steps
	 * @return if succeed - current square, 
	 * */
	/*
	public Square MovePlayer(PlayerInGame p,int steps) {
		return null;//empty method - why? maybe there is a similar method in the code
		*/
	/**
	 * get type of square on board
	 * */
	public String getSquareType(int numSquare) {
		this.toString();
		for(Square s : this.AllSquares) {
			if(s != null) {
				if(s.getNum() == numSquare) {
					if(s instanceof Property)
						return Property.class.getSimpleName();
					else if(s instanceof LuckyCard)
						return LuckyCard.class.getSimpleName();
					else if(s instanceof QuestionCard)
						return QuestionCard.class.getSimpleName();
				}
			}
		}
		return null;
	}
	
	public static Square getStart() {
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
	public static Square getSquareByIndex(int index){
		
		for (Square s : AllSquares){
			if (s.getNum() == index){
				return s;
			}
		}
		
		throw new RuntimeException("FATAL ERROR! try to reach not exist square");
		
		
	}
	
}
	
