// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK

//names the class Inventory
public class Inventory
{
    private Item head;

    public Inventory()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void insert(Item newNode) {
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            //start looking in list from head
            Item current = head;
            //continue moving through the list until the end
            //if new is greater than current head
            if (current.getValue() <= newNode.getValue())
            {

                current.setPrevious(newNode);
                newNode.setNext(current);
                head = newNode;
            }
            else
            {
                /*search through the list until you arrive at a value that is less than the newNode
                or the next is null, meaning youre at the end of the list*/
                System.out.println("Debug New Node Value: "+newNode.getValue());
                System.out.println("Debug while: "+current.getValue());
                while (current.getValue() > newNode.getValue() && current.getNext() != null) //issue here is that it can push stuff to bottom?
                {

                    current = current.getNext();
                }
                System.out.println("Debug while post add: "+current.getValue());
                if (current.getNext() == null && current.getValue() > newNode.getValue())
                {
                    System.out.println("Debug New Node Value Hits Null: "+newNode.getValue());
                    current.setNext(newNode);
                    newNode.setPrevious(current);
                }
                else
                {
                    //shows the while statement is working
                    if (current.getPrevious() != null)
                    {

                        //set the newNode as the next one for the previous
                        current.getPrevious().setNext(newNode);
                        //set the previous node as the previous
                        newNode.setPrevious(current.getPrevious());
                        current.setPrevious(newNode);
                        newNode.setNext(current);

                    }
                    else
                    {
                        newNode.setPrevious(current);
                        current.setNext(newNode);
                    }
                    //need to alter the previous as well
                    //so that it now points to this Item first
                }

            }

        }
        System.out.println("\n");
    }

    //public String getItem(String name) {}
    //public String remove(String name) {}

    public void print()
    {
        if (isEmpty())
        System.out.println("There are no items in your pouch");
        Item current = head;
        //as long as the next node is there
        while (current != null)
        {
            System.out.println(current.toItemString());
            current = current.getNext();
        }
    }
}
