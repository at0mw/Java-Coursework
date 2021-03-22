// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK

public class Chamber
{
    private int northWall;
    private int eastWall;
    private int southWall;
    private int westWall;
    private int dragonItem;

    public Chamber(int n ,int e, int s, int w)
    {
        northWall = n;
        eastWall = e;
        southWall = s;
        westWall = w;
    }

    public String toChamberString()
    {
        return northWall + " " + eastWall+ " " + southWall+ " " + westWall;
    }

    public int getNorthWall()
    {
        return northWall;
    }

    public int getEastWall()
    {
        return eastWall;
    }

    public int getSouthWall()
    {
        return southWall;
    }

    public int getWestWall()
    {
        return westWall;
    }

    public int getDragonItem()
    {
        return dragonItem - 1;
    }

    public void setDragonItem(int d)
    {
        this.dragonItem = d + 1;
    }
}
