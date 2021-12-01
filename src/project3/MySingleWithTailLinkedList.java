package project3;

import java.io.Serializable;
import java.util.Collections;
import java.util.Random;

/***************************
 * Class Description of MySingleWithTailLinkedList
 *
 * A Singly Linked List with Tail
 *
 * @author Michael Van Duine
 */

public class MySingleWithTailLinkedList implements Serializable
{
    private Node top;
    private Node tail;

    public MySingleWithTailLinkedList() {
        top = tail = null;
    }

    /********************************************************************************************
     * A function that gets the total size of the list.
     *
     * @return total size
     */
    public int size() {
        if (top == null)
            return 0;

        int total = 0;
        Node temp = top;
        while (temp.getNext() != null) {
            total++;
            temp = temp.getNext();
        }

        if (temp != tail)
            throw new RuntimeException("Tail is not pointing at the end of the list");
        else
            total++;

        return total;
    }

    /********************************************************************************************
     * A function that clears the list
     */
    public void clear () {
        Random rand = new Random(13);
        while (size() > 0) {
            int number = rand.nextInt(size());
            remove(number);
        }
    }

    /********************************************************************************************
     * A function that adds a rental to the head of the list in order of date and if the dates
     * are the same it sorts by the name of renter
     *
     * @param rental the unit being rented
     */
    public void add(Rental rental) {

        Node temp = top;

        // no list
        if (top == null) {
            tail = top = new Node(rental, null);
            return;
        }

        if(rental instanceof Game) {
            if (top.getData().dueBack.after(rental.dueBack)) {
                top = new Node(rental, temp);
                return;
            }

            if (top.getData().dueBack.equals(rental.dueBack) && top.getData().nameOfRenter.compareToIgnoreCase(rental.nameOfRenter) > 0) {
                top = new Node(rental, temp);
                return;

            }

            while(temp.getNext() != null && temp.getNext().getData() instanceof Game && temp.getNext().getData().dueBack.before(rental.dueBack)) {
                temp = temp.getNext();
            }

            while(temp.getNext() != null && temp.getNext().getData() instanceof Game && temp.getNext().getData().dueBack.equals(rental.dueBack)) {
                if (temp.getNext().getData().nameOfRenter.compareToIgnoreCase(rental.nameOfRenter) > 0) {
                    break;
                }
                temp = temp.getNext();
            }

            temp.setNext(new Node(rental, temp.getNext()));
            if (temp.getNext().getNext() == null) {
                tail = temp.getNext();
            }
            return;
        }

        if (rental instanceof Console) {
            Node consoleTop = null;
            Node gameEnd = null;

            if(top.getData() instanceof Console) {
                gameEnd = top;
                consoleTop = top;
                temp = top;

            } else {

                while (temp.getNext() != null && temp.getNext().getData() instanceof Game) {
                    temp = temp.getNext();
                }

                gameEnd = temp;
                consoleTop = temp.getNext();
                temp = consoleTop;
            }


            if (consoleTop == null) {
                gameEnd.setNext(new Node(rental, null));
                tail = gameEnd.getNext();
                return;
            }

            if (consoleTop.getData().dueBack.after(rental.dueBack)) {
                if (top.getData() instanceof Console)
                    top = new Node(rental, top);
                else {
                    gameEnd.setNext(new Node(rental, consoleTop));
                    if (gameEnd.getNext().getNext() == null) {
                        tail = gameEnd.getNext();
                    }
                }
                return;
            }

            if (consoleTop.getData().dueBack.equals(rental.dueBack) && consoleTop.getData().nameOfRenter.compareToIgnoreCase(rental.nameOfRenter) > 0) {
                if (top.getData() instanceof Console)
                    top = new Node(rental, top);
                else {
                    gameEnd.setNext(new Node(rental, consoleTop));
                    if (gameEnd.getNext().getNext() == null) {
                        tail = gameEnd.getNext();
                    }
                }
                return;
            }

            while(temp.getNext() != null && temp.getNext().getData() instanceof Console && temp.getNext().getData().dueBack.before(rental.dueBack)) {
                temp = temp.getNext();
            }

            while(temp.getNext() != null && temp.getNext().getData() instanceof Console && temp.getNext().getData().dueBack.equals(rental.dueBack)) {
                if (temp.getNext().getData().nameOfRenter.compareToIgnoreCase(rental.nameOfRenter) > 0) {
                    break;
                }
                temp = temp.getNext();
            }

            temp.setNext(new Node(rental, temp.getNext()));
            if (temp.getNext().getNext() == null) {
                tail = temp.getNext();
            }
            return;

        }
    }

    /********************************************************************************************
     * A function that removes the given index from the list and returns the data being removed
     *
     * @return total size
     */
    public Rental remove(int index) {
        //  more code goes here.
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException();
        }
        if (top == null)
            return null;


        Node temp = top;
        Node removed = null;

        if(index == 0) {
            removed = top;
            top = temp.getNext();
            return removed.getData();
        }

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.getNext();

        removed = temp.getNext();

        temp.setNext(removed.getNext());
        if (temp.getNext() == null)
            tail = temp;

        return removed.getData(); // this line will need to be changed
    }

    /********************************************************************************************
     * A function that returns the given index of the lists rental.
     *
     * @return total size
     */
    public Rental get(int index) {
        //  more code goes here.
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException();
        }
        if (top == null)
            return null;

        Node temp = top;
        int count = 0;
        while(temp != null && count != index) {
            temp = temp.getNext();
            count++;
        }

        return temp.getData(); // this line will need to be changed
    }

    /********************************************************************************************
     * A function that outputs the data of each index
     *
     * @return total size
     */
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "LL {" +
                "top=" + top +
                ", size=" + size() +
                '}';
    }
}

