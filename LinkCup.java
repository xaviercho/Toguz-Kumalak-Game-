

import java.io.Serializable;


public class LinkCup extends Cup implements Serializable
{
    private LinkCup nextCup;
    private LinkCup home;
   
    
    public LinkCup()
    {
        super();
        nextCup= null;
        home = null;
    }
    public LinkCup(int seedsIn, int playerIn)
    {
        super(seedsIn, playerIn);
        nextCup = null;
        home = null;
    }
    
    public LinkCup(int seedsIn, int playerIn, LinkCup nextCupIn)
    {
        super(seedsIn, playerIn);
        nextCup=nextCupIn;   
        home = null;
        
    }
  
    public LinkCup getNextCup()
    {
        return nextCup;
    }          
    public void setNextCup(LinkCup nextCupIn)
    {
        nextCup= nextCupIn;
    }
    
    public LinkCup getHome()
    {
        return home;
    }
    public void setHome(LinkCup homeIn)
    {
        home = homeIn;
    }

    public boolean hasHome()
    {
        return home != null; 
    }


}

