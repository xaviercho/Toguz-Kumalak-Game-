import java.io.Serializable;
public class Cup implements Serializable
{
    private int seeds;
    private int player;
    private String seedString;
    
    public Cup()
    {
        seeds = 0;
        player = 0;
        seedString = Integer.toString(seeds);
    }
    public Cup(int playerIn)
    {
        seeds = 0;
        player = playerIn;
        seedString = Integer.toString(seeds);
    }
    public Cup(int seedsIn, int playerIn)
    {
        seeds = seedsIn;
        player = playerIn;
        seedString = Integer.toString(seedsIn);
    }

    public String getSeedString()
    {
        return seedString;
    }
    public int getSeeds()
    {
        return seeds;
    }
    public void setSeeds(int seedsIn)
    {
        seeds = seedsIn;
        seedString = Integer.toString(seedsIn);
    }
    public int getPlayer()
    {
        return player;
    }
    public void setPlayer(int playerIn)
    {
        player = playerIn;
    }
   
    public void addOneSeed()
    {
        seeds++;
        String tempString;
        tempString = Integer.toString(seeds);
        seedString = tempString;
    }
    public void addSeeds(int seedsIn)
    {
        seeds = seeds + seedsIn;
        String tempString;
        tempString = Integer.toString(seeds);
        seedString = tempString;
    }
    public int removeSeeds()
    {
        int tempSeeds;
        tempSeeds = seeds;
        seeds = 0;
        return tempSeeds;
    }
    public int removeAllButOne()
    {
        int tempSeeds;
        tempSeeds = seeds -1;
        setSeeds(1);
        return tempSeeds;
    }
  
}

