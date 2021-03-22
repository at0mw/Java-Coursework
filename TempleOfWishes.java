// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//names the class TempleOfWishes
public class TempleOfWishes
{

    private Item[] items = new Item[18];
    private Dragon[] dragons = new Dragon[18];
    private Chamber[][] chamber1 = new Chamber[6][6];
    private static Hero player1 = new Hero(5);




    //constructor creates object holding the matrix values
    public TempleOfWishes()
    {
        try
        {
            File myChambers = new File("TempleData.txt");
            Scanner myReader = new Scanner(myChambers);
            for (int r=0; r<6; r++)
            {
                for (int c=0; c<6; c++)
                {
                    int n = myReader.nextInt();
                    int e = myReader.nextInt();
                    int s = myReader.nextInt();
                    int w = myReader.nextInt();
                    chamber1[r][c] = new Chamber(n,e,s,w);
                }
            }
        myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
        }
    }

    public void items()
    {
        //read in and create the items from the txt file
        try
        {
            File myItems = new File("ItemNames.txt");
            Scanner myReader1 = new Scanner(myItems);
            for (int i=0; i<items.length; i++)
            {
                String n = myReader1.nextLine();
                //generate a random number between 1 - 20
                int v = (int)(Math.random()*20)+1;
                boolean c = false;
                items[i] = new Item(n, v, c);
            }
        myReader1.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
        }
    }

    public void dragons()
    {
        /*read in and create the Dragons*/
        /*Dragon names taken from the text file*/
        try
        {
            File myDragons = new File("DragonNames.txt");
            Scanner myReader2 = new Scanner(myDragons);
            for (int i=0; i<items.length; i++)
            {
                String n = myReader2.nextLine();
                //generate a random number between 5 - 10
                int f = (int)(Math.random()*6)+5;
                boolean d = false;
                dragons[i] = new Dragon(n, f, d);
            }
        myReader2.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
        }

    }

    public void traveller(int x, int y, int x1, int y1)
    {
        System.out.println("You are now in Chamber (" + x1 +"," + y1 +")");
        if (chamber1[x][y].getNorthWall() == 1)
        {
            System.out.println("There is a door going North");
        }
        if (chamber1[x][y].getEastWall() == 1)
        {
            System.out.println("There is a door going East");
        }
        if (chamber1[x][y].getSouthWall() == 1)
        {
            System.out.println("There is a door going South");
        }
        if (chamber1[x][y].getWestWall() == 1)
        {
            System.out.println("There is a door going West");
        }
        if (chamber1[x][y].getDragonItem() >= 0)
        {
            int z = chamber1[x][y].getDragonItem();
            if (dragons[z].getStatus() == false)
            {
                System.out.println("The dragon "+dragons[z].getName()+" is guarding a "+items[z].toItemString()+" in this room");
            }
            else
            {
                System.out.println("There is no dragon guarding a "+items[z].toItemString()+" in this room");
            }
        }
    }


    public void shuffleItems()
    {
        for (int i = 0; i < items.length; i++)
        {
            //generate a random number j from 0 to 17
            int j = (int)(Math.random()*18);
            //swap a card at index i with a card at index j
            Item temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }
    }

    public void shuffleDragons()
    {
        for (int i = 0; i < items.length; i++)
        {
            //generate a random number j from 0 to 17
            int j = (int)(Math.random()*18);
            //swap a card at index i with a card at index j
            Dragon temp = dragons[i];
            dragons[i] = dragons[j];
            dragons[j] = temp;
        }

    }

    //assign the dragons and items to random empty rooms
    public void scatterDragonItems()
    {
        int x = (int)(Math.random()*6);
        int y = (int)(Math.random()*6);

        for (int k=0; k < 18; k++)
        {
            while (true)
            {
                //if room is empty, place dragon and break loop
                if (chamber1[x][y].getDragonItem() == -1)
                {
                    chamber1[x][y].setDragonItem(k);
                    break;
                }
                //if room filled, generate new random co-ordinates and try again
                else
                {
                    x = (int)(Math.random()*6);
                    y = (int)(Math.random()*6);
                }
            }
        }
    }

    public void rest()
    {
        if (player1.getFirepower() < 10)
        {
            System.out.println("You are resting...\nFirepower increased by 1.");
            player1.setFirepower(1);
            System.out.println("Your Hero's current firepower is: " + player1.getFirepower());
        }
        else
        {
            System.out.println("You are resting...\nFirepower already at maximum.");
        }
    }

    public void dragonFight(int x, int y)
    {
        //check for dragon

        int checkDrag = chamber1[x][y].getDragonItem();
        if (checkDrag >= 0 && dragons[checkDrag].getStatus() == false)
        {
            System.out.println("Preparing to fight...");
            if (dragons[checkDrag].getFirepower() < player1.getFirepower())
            {
                System.out.println("You defeated the dragon " + dragons[checkDrag].getName()+ " and gained Experience!");
                dragons[checkDrag].setStatus(true);
                if (player1.getFirepower() < 10)
                player1.setFirepower(1);
                System.out.println("Your firepower is now " + player1.getFirepower());
            }
            else if (dragons[checkDrag].getFirepower() == player1.getFirepower())
            {
                int j = (int)(Math.random()*2);
                if(j==0)
                {
                    System.out.println("You defeated the dragon " + dragons[checkDrag].getName()+ " and gained Experience!");
                    dragons[checkDrag].setStatus(true);
                    if (player1.getFirepower() < 10)
                    player1.setFirepower(1);
                    System.out.println("Your firepower is now " + player1.getFirepower());
                }
                else
                {
                    System.out.println("You were defeated by the Dragon");
                    if (player1.getFirepower() > 5)
                    player1.setFirepower(-1);
                    System.out.println("Your firepower is now " + player1.getFirepower());
                }

            }
            else
            {
                System.out.println("You were defeated by the Dragon");
                if (player1.getFirepower() > 5)
                player1.setFirepower(-1);
                System.out.println("Your firepower is now " + player1.getFirepower());
            }
        }
        else
        {
            System.out.println("There is no Dragon present");
        }
    }

    public boolean continuityCheck()
    {
        for (int k=0; k<18; k++)
        {
            if (!items[k].getStatus())
                return false;
        }
        return true;
    }

    public static void main(String argv[])
    {
        System.out.println("Starting the game...\n");
        TempleOfWishes temple1 = new TempleOfWishes();
        Inventory inventory1 = new Inventory();

        //create items and dragons
        temple1.items();
        temple1.dragons();

        /*shuffling the items and dragons means a random pair will appear for
        index i each time*/
        temple1.shuffleItems();
        temple1.shuffleDragons();

        //scatter numbers 0-17 throughtout the chamber matrix
        //the number corresponds to a dragon and an item
        temple1.scatterDragonItems();

        //co-ordinates are randomly set at first
        //but then altered by player decisions
        int x = (int)(Math.random()*6);
        int y = (int)(Math.random()*6);
        int x1;
        int y1;

        Scanner sc = new Scanner(System.in);

        boolean check = true;
        while (true)
        {
            //shift array index into traditional x,y co-ordinates


            //check for change in co-ordinates
            //if change describe new locale
            if (check)
            {
                x1 = x + 1;
                y1 = y + 1;
                temple1.traveller(x, y, x1, y1);
                System.out.println("  ");
            }

            check = false;
            //check the room and see where the doors are
            //and if there's a dragon and an item
            System.out.println("What would you like to do?");
            //read in the value input and assign it to input
            String input = sc.nextLine();
            int inputLength = input.length();

            switch (input)
            {
                //fight dragon
                case "f":
                    temple1.dragonFight(x,y);
                    //if dragon loses, set dead to true
                    //temple1.dragons[0].setStatus(true);
                    break;

                //inventory- list all items in backpack
                case "i":

                if (inventory1.isEmpty())
                {
                    System.out.println("There are no items in your pouch");
                }
                    System.out.println("You have acquired the following items:");
                    inventory1.print();
                    break;

                //pick up item
                case "p":
                    //check for dragon then item
                    int checkDrag = temple1.chamber1[x][y].getDragonItem();
                    if (checkDrag >= 0 && temple1.dragons[checkDrag].getStatus() == true)
                    {
                        System.out.println("You add the item to your pouch");
                        inventory1.insert(new Item(temple1.items[checkDrag].getName(), temple1.items[checkDrag].getValue(), true));
                    }
                    else
                    {
                        System.out.println("No item could be collected");
                    }

                    break;

                //rest (increase firepower by 1)
                case "r":
                    temple1.rest();
                    break;

                case "n":
                    if (temple1.chamber1[x][y].getNorthWall() == 1)
                    {
                        System.out.println("Selected n");
                        y = y + 1;
                        check = true;
                    }
                    else
                    {
                        System.out.println("You can't go that way");
                    }
                    break;

                case "e":
                    if (temple1.chamber1[x][y].getEastWall() == 1)
                    {
                        System.out.println("Selected e");
                        x = x + 1;
                        check = true;
                    }
                    else
                    {
                        System.out.println("You can't go that way");
                    }

                    break;

                case "s":
                    if (temple1.chamber1[x][y].getSouthWall() == 1)
                    {
                        System.out.println("Selected s");
                        y = y - 1;
                        check = true;
                    }
                    else
                    {
                        System.out.println("You can't go that way");
                    }

                    break;

                case "w":
                    if (temple1.chamber1[x][y].getWestWall() == 1)
                    {
                        System.out.println("Selected w");
                        x = x - 1;
                        check = true;
                    }
                    else
                    {
                        System.out.println("You can't go that way");
                    }
                    break;

                default:
                    System.out.println("Invalid option, please select again");
                    break;
            }
            if(temple1.continuityCheck())
            break;
        }
    }
}
