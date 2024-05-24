import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.extended.Stack;

public class extendedStack {
    private Stack s, s1, s2;

    @BeforeEach
    void setUp() {
        s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        s1 = new Stack(s);
        s2 = new Stack();
    }
    
    @Test
    void testClear() {
    	s.clear();
    	assertEquals(0, s.elements());
    }
    
    @Test
    void testPush() {
		s.push(5);
		assertEquals(5, s.peek());
		s.push(6);
		assertEquals(5, s.peek());
    }
    
    @Test
    void testPushOther() {
    	Stack t = new Stack(2);
    	t.push(5);
    	s.push(t);
    	assertEquals(5, s.elements());
    	t.push(6);
    	s.push(t);
    	assertEquals(7, s.elements());
    }
    
    @Test
    void testClone() {
    	Stack t = s.clone();
    	assertEquals(s.elements(), t.elements());
    }
    
    @Test
    void testEquals() {
    	Stack t = new Stack(3);
    	assertFalse(s.equals(t));
    	Stack t2 = s.clone();
    	assertTrue(s.equals(t2));
    	Stack t3 = new Stack(5);
    	assertFalse(t.equals(t3));
    	t3.push(1);
    	t3.push(1);
    	t3.push(1);
    	t3.push(1);
    	assertFalse(s.equals(t3));
    	assertTrue(s.equals(s1));
    	assertFalse(s.equals(s2));
    }
    
    @Test
    void testPop() {
    	s.pop();
    	assertEquals(3, s.elements());
    	s.clear();
    	assertEquals(Integer.MIN_VALUE, s.pop());
    }
    
    @Test
    void testPeek() {
    	assertEquals(4, s.peek());
    	s.clear();
    	assertEquals(Integer.MIN_VALUE, s.peek());
    }
    
    @Test
    void testSearch() {
    	assertTrue(s.search(2));
    	assertFalse(s.search(73));
    }
    
    @Test
    void testElements() {
    	s.pop();
    	assertEquals(3, s.elements());
    }
    
    @Test
    void testSize() {
    	assertEquals(5, s.size());
    }
    
    @Test
    void testToString() {
    	String expected = new String("[1] [2] [3] [4] ");
    	assertEquals(expected, s.toString());
    	Stack s3 = new Stack(4);
    	s3.push(5);
    	s3.push(6);
    	s3.push(7);
    	s3.push(8);
    	s.push(s3);
    	String expected2 = new String("[1] [2] [3] [4] [5] [6] [7] [8] ");
    	assertEquals(expected2, s.toString());
    }
}







