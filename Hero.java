// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK


//names the class Hero
public class Hero
{
    //do we need to assign a pouch to the hero
    private int firepower;

    public Hero(int f)
    {
        firepower = f;
    }


    public int getFirepower()
    {
        return firepower;
    }

    public void setFirepower(int i)
    {
        this.firepower = firepower + i;
    }
}
