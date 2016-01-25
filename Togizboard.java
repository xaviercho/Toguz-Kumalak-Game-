import java.io.Serializable;

public class TogizBoard implements Serializable
{
    private final LinkCup[][] board = new LinkCup[2][11]; //cups as an array, creating a board
    private final LinkCup[] score; //players scores
    private boolean gameOver = false;
    private int emptySide1 = 0;
    private int emptySide2 = 0;
   // private final boolean[] home = new boolean[2];
    private int holderSeeds;
    
    public TogizBoard()
    {
        this.score = new LinkCup [2];
        score[0] = new LinkCup(0, 0); //player 1's pickup when playing
        score[1] = new LinkCup(0, 1); //player 2's pickup when playing
        score[0].setSeeds(0);
        score[1].setSeeds(0);
        
        for (int row =0; row < 2; row ++)
        {  
            for(int col = 0; col< 11; col++)
            {
                board[row][col] = new LinkCup(col, row);
            }
            
        }
        board [0][0] = new LinkCup(7, 0);//seeds
        board [1][10] = new LinkCup(7, 1) ; //seeds
 

        for (int col = 1; col <= 10; col++)
        {
            board[0][col] = new LinkCup (7, 0, board[0][col-1]);//seeds
        }

        for (int col = 9; col >=0; col--)
        {
            
            board[1][col] = new LinkCup (7, 1, board[1][col+1]);//seeds
        }   

        board [0][0].setNextCup(board[1][0]);
        board [1][10].setNextCup(board[0][10]); 

        
    }
   
   public LinkCup getCup(int player, int col)
   {
       return board[player][col];
   }
   public LinkCup getScoreCup(int player)
   {
       return score[player];
   }
    public void playBoard(int player, int cupChose)
    {
        
        System.out.println(player+ " cup:"+ cupChose + "Seeds:" +board[player][cupChose].getSeeds());
        System.out.println("Player 1: " + score[0].getSeeds()+ "Player 2: "+score[1].getSeeds());
        int tempSeeds = board[player][cupChose].getSeeds();
        LinkCup tempRef = board[player][cupChose].getNextCup();
        int pickUpSeeds;
        
        if (tempSeeds > 1) 
        {
            pickUpSeeds = board[player][cupChose].removeAllButOne();
            while (pickUpSeeds != 1)
            {
                    tempRef.addOneSeed();  

                tempRef = tempRef.getNextCup();
                pickUpSeeds--;
            }
            tempRef.addOneSeed();

        }
        else if (tempSeeds < 2 && tempSeeds > 0) 
        {
            board[player][cupChose].removeSeeds();
            tempRef.addOneSeed();   

        }
        
        setHolderSeeds(tempSeeds);
        if(tempRef.getPlayer() != player && tempRef.getSeeds()%2 == 0)
        {
            score[player].addSeeds(tempRef.getSeeds());
            tempRef.removeSeeds();
        } 
        gameOver();
    }
    
    public int getPlayerOneScore()
    {
        return score[0].getSeeds();
    }
    
    public int getPlayerTwoScore()
    {
        return score[1].getSeeds();
    }
   
    public int getHolderSeeds()
    {
        return holderSeeds;
    }
    
    public void setHolderSeeds( int tempSeedsIn)
    {
        holderSeeds = tempSeedsIn;
    }
   
    public boolean cupEmpty(int side, int col)
    {
            return board[side][col].getSeeds() == 0;
    }
   
    public boolean invalidCup(int cupChose)
    {
        return cupChose > 7 || cupChose < 0;
    }
    
    public void gameOver()
    {   
        emptySide1 =0;
        emptySide2 =0;

       for (int col = 0; col < 10; col++)
       {
            if(cupEmpty(0, col))
            {
                emptySide1++;
            }
       }
       for (int col = 0; col < 10; col++)
       {
           if (cupEmpty(1, col))
               emptySide2++;
       }
       if(emptySide1 == 10 || emptySide2 == 10)
           gameOver = true;
    }
  
    public void winner()
    {
        int tempSeeds = 0;
        if (emptySide1 == 10)
        {
            for (int col = 0; col < 10; col++)
            {
                tempSeeds = tempSeeds + board[1][col].getSeeds();
            }
         score[1].addSeeds(tempSeeds);
        }
        else
        {
            for (int col = 0; col < 10; col++)
            {
                tempSeeds = tempSeeds + board[0][col].getSeeds();
            }
         score[0].addSeeds(tempSeeds); 
        }

    }

    public boolean getGameOver()
    {
        return gameOver;
    }
    
}
