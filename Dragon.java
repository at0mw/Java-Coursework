// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK


//names the class Dragon
public class Dragon
{
    private String name;
    private int firepower;
    private boolean dead;

    public Dragon(String n ,int f, boolean d)
    {
        name = n;
        firepower = f;
        dead = d;
    }

    public String toDragonString()
    {
        return name + " " + firepower;
    }

    public String getName()
    {
        return name;
    }


    public int getFirepower()
    {
        return firepower;
    }

    public boolean getStatus()
    {
        return dead;
    }

    public void setStatus(boolean d)
    {
        this.dead = d;
    }
}
