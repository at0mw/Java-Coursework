// Temple of Wishes Program
// Thomas Williams
// Friday 6th of December 2019
// The University of Liverpool, UK

//names the class Item
public class Pouch
{
    private ItemListNode head;

    public ItemList()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head ==null;
    }

    public void insert(ItemListNode newNode) {
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            //start looking in list from head
            ItemListNode current = head;
            //continue moving through the list until the end
            while (current.getNext() != null)
            {
                current =current.getNext();
                current.setNext(newNode);
            }
        }
    }

    public String getItem(String name) {}
    public String remove(String name) {}
    public void print()
    {
        if (isEmpty())
        System.out.println("There are no items in your pouch");
        ItemListNode current = head;
        //as long as the next node is there
        while (current != null)
        {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
