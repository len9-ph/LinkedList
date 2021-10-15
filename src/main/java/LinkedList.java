/*
 * Linked list
 * @author Leonid Gadetsky <leonidgadetsky@yandex.ru>
 * @version 1.0
 */


public class LinkedList<T> {

    /** List head field */
    private node<T> head;
    /** List length field */
    private int length = 0;


    /**
     * List node
     */
    class node<T> {
        T data;
        node<T> next;
        node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }


    /**
     * Default constructor
     */
    LinkedList() { this.head = null; length = 0; }


    /**
     * Constructor with parameters
     * @param variables variables added to a list
     */
     LinkedList(T... variables) {
        for (T data : variables) {
            addToEnd(data);
        }
    }


    /**
     * The method of checking for emptiness
     * @return true or false
     */
    boolean isEmpty() {
        return head == null;
    }


    /**
     * Method that returns the first item in the list
     * @return head.data
     */
    T getHead() {
        return head.data;
    }


    /**
     * Method that returns the length of the list
     * @return list length
     */
    int getLength() {
        return length;
    }


    /**
     * Method that adds an element to the head of the list
     * @param data value of element to be added
     */
    void addToHead(T data) {
        node<T> temp = new node<>(data);
        if (isEmpty()) {
            head = temp;
        }
        else {
            temp.next = head;
            head = temp;
        }
        length++;
    }


    /**
     * Method that adds an element to the end of the list
     * @param data value of element to be added
     */
    void addToEnd(T data) {
        node<T> temp = new node<>(data);
        if(isEmpty()) {
            head = temp;
        }
        else {
            node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = temp;
        }
        length++;
    }


    /**
     * A method that deletes a list item by its value
     * @param key the value of the node to be deleted
     */
    void remove(T key) {
        node<T> previous = new node<>(null);
        previous.next = head;
        node<T> next = head.next;
        node<T> temp = head;
        boolean exists = false;

        if(head.data == key){
            head = head.next;

            exists = true;
        }
        while (temp.next != null){
            if (String.valueOf(temp.data).equals(String.valueOf(key))){
                previous.next = next;
                exists = true;

                break;
            }
            previous = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))){
            previous.next = null;
            exists = true;
        }
        if (exists) {
            length--;
        }

    }


    /**
     * A method that removes all list items
     */
    void clear() {
        head = null;
        length = 0;
    }


    /**
     * A method that represents a list as a string
     * @return a string containing list items
     */
    @Override
    public String toString() {
        String string = "";
        node<T> temp = head;

        if (temp == null) {
            return string;
        }
        while (temp.next != null) {
            string += temp.data + " ";
            temp = temp.next;
        }

        string += String.valueOf(temp.data);
        return string;
    }
}
