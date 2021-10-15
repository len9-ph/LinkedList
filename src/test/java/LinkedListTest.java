import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void isEmpty() {
        assertTrue(linkedList.isEmpty());
        linkedList.addToHead(10);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void getHead() {
        int element = 10;
        linkedList.addToHead(element);
        assertEquals(linkedList.getHead(),element);
    }

    @Test
    void getLength() {
        assertEquals(linkedList.getLength(),0);
        linkedList.addToHead(10);
        assertEquals(linkedList.getLength(),1);
    }

    @Test
    void addToHead() {
        int element = 10;
        linkedList.addToHead(element);
        assertEquals(linkedList.getHead(), element);
    }

    @Test
    void addToEnd() {
        for (int i = 0; i < 4; i++) {
            linkedList.addToEnd(i);
        }
        assertEquals(linkedList.getLength(),4);
    }

    @Test
    void remove() {
        assertEquals(linkedList.getLength(),0);
        linkedList.addToHead(10);
        assertEquals(linkedList.getLength(),1);
        linkedList.remove(10);
        assertEquals(linkedList.getLength(),0);
    }

    @Test
    void clear() {
        assertTrue(linkedList.isEmpty());
        for(int i = 0; i < 4; i++) {
            linkedList.addToHead(i);
        }
        assertFalse(linkedList.isEmpty());
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void testToString() {
        String string = "0 1 2 3";
        for (int i = 0; i < 4; i++) {
            linkedList.addToEnd(i);
        }
        assertEquals(linkedList.toString(), string);
    }
}