// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK

//names the class Item
public class Item
{


      private String name;
      private int value;
      private boolean collected;
      private Item next;
      private Item previous;

      public Item(String n ,int v, boolean c)
      {
        name = n;
        value = v;
        collected = c;
        next = null;
      }

      public String toItemString()
      {
          return name + " (value " + value + ")";
      }

      public String getName()
      {
          return name;
      }

      public int getValue()
      {
          return value;
      }

      public void setNext(Item nextPTR)
      {
          next = nextPTR;
      }

      //return next node
      public Item getNext()
      {
          return next;
      }

      public void setPrevious(Item previousPTR)
      {
          previous = previousPTR;
      }

      public Item getPrevious()
      {
          return previous;
      }

      public boolean getStatus()
      {
          return collected;
      }

      public void setStatus(boolean c)
      {
          this.collected = c;
      }
}
