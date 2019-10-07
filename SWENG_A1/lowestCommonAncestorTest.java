

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)

public class lowestCommonAncestorTest {
	

	
	@Test
	
	public void testEmpty() {
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		assertFalse("Checking if empty tree contains key ", lca.existsCheck(3));
		assertNull("Checking if we can get value from empty tree ", lca.getNode(0));
		assertEquals("Checking if we can find lca for empty tree ",null, lca.getLowestCommonAncestor(0,0));
		assertEquals("Checking if we can get node for empty tree", null, lca.getNode(3));


		
	}
	
	@ Test
	
	public void putNodeTest() {
		
		
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		
		lca.putNode(1, 1);
		assertTrue("Checking if tree contains key ", lca.existsCheck(1));
		lca.putNode(2,  2);
		lca.putNode(100, 345555);
		assertTrue("Checking if tree contains key ", lca.existsCheck(100));
		assertFalse("Checking if tree contains key ", lca.existsCheck(0));
		lca.putNode(null,  null);
		assertFalse("Checking if tree contains a null key ", lca.existsCheck(null));
		
		
		
		
	}
	
	@ Test
	
	public void getNodeTest() {
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		
		lca.putNode(1, 1);
		lca.putNode(2, 2);
		lca.putNode(3, 5);
		lca.putNode(4, 4);
		lca.putNode(5, 5);
		lca.putNode(6, 6);
		lca.putNode(7, 7);
		
		assertEquals("Checking if we can find lca for this tree", (Integer)5, lca.getNode(3));
		assertEquals("Checking if we can find lca for this tree", null, lca.getNode(8));
		assertEquals("Checking if we can find null node", null, lca.getNode(null));
		
		
	}
	
	@ Test 
	public void existsCheckTest() {
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		assertFalse("Checking if any node exists in empty tree", lca.existsCheck(3));
		lca.putNode(1, 1);
		lca.putNode(2, 2);
		lca.putNode(3, 5);
		lca.putNode(4, 4);
		lca.putNode(5, 5);
		assertTrue("Checking if node exists in  tree", lca.existsCheck(5));
		assertTrue("Checking if node exists in  tree", lca.existsCheck(4));
		assertFalse("Checking if node exists in tree", lca.existsCheck(9));
	}
}
