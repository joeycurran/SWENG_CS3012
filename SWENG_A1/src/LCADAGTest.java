

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



@RunWith(JUnit4.class)
public class LCADAGTest {
	

	
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
		lca.putNode(null,  null);
		
		assertEquals("Checking if we can get node that exists", (Integer)5, lca.getNode(3));
		assertEquals("Checking if we can get node that does not exist", null, lca.getNode(8));
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

		@ Test 
	public void getLCATest() {
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		lca.putNode(4, 4);
		lca.putNode(2, 2);
		lca.putNode(3, 3);
		lca.putNode(7, 7);
		lca.putNode(6, 6);
		lca.putNode(8, 8);
		lca.putNode(9, 9);
		lca.putNode(10, 10);
		assertEquals("Checking two common ancestors, where LCA is the root", (Integer)4, lca.getLowestCommonAncestor(3, 9));
		assertNull("Checking where one inputNode does not exist in the tree", lca.getLowestCommonAncestor(4, 5));
		assertEquals("Checking two common ancestors, where LCA is not the root", (Integer)7, lca.getLowestCommonAncestor(6, 10));
	}

	@Test
	public void testPrint(){
		//checks to see if the putNode function operates as needed
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		lca.putNode(4, 4);
		lca.putNode(3, 3);
		lca.putNode(7, 7);
		lca.putNode(6, 6);
		lca.putNode(9, 9);
		lca.putNode(10, 10);

		assertEquals("Testing that the keys were correctly inserted into the tree", "((()3())4((()6())7(()9(()10()))))" , lca.treeToString());
		lca.putNode(20, 20);
		lca.putNode(null, null);
		assertEquals("Testing that the keys were correctly inserted into the tree", "((()3())4((()6())7(()9(()10(()20())))))" , lca.treeToString());


	}
	
	@Test
	public void testDAG()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		
		assertEquals(1, graph.indegree(4));
		assertEquals(2, graph.outdegree(4));
		assertEquals(5, graph.E());
		assertEquals(10, graph.V());
		String adj = "[6, 7]";
		assertEquals(adj, graph.adj(4).toString());
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest(){
		
		//Can't make a directed graph with less than 0 vertices
		
		DAG graph = new DAG(-5);
	}
	
	@Test
	public void addEdge()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1,2);

		//As negative, will print a system error and not addEdge
		graph.addEdge(-1, -6);
		
		//This will not addEdge as 12 > 5
		graph.addEdge(3, 12);
		
		assertEquals(1, graph.E());
	}
	
	@Test
	public void testIndegree()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(1, graph.indegree(3));
	
		assertEquals(-1, graph.indegree(5));
	}
	
	@Test
	public void testOutdegree()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(1, graph.outdegree(3));
	
		assertEquals(-1, graph.outdegree(5));
	}
	
	@Test 
	public void testV()
	{
		DAG graph = new DAG(6);
		assertEquals(6, graph.V());
	}
	
	@Test
	public void testE(){
		
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(3, graph.E());
	}
	
	@Test
	public void testAdj()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		graph.addEdge(4, 3);
		
		String adj = "[4]";
		assertEquals(adj, graph.adj(2).toString());
	}
	
	@Test
	public void testforCycle()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		graph.findCycle(0);
		
		assertTrue(graph.hasCycle());
	}
	
	@Test
	public void testAcyclicGraph()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		graph.findCycle(1);
		assertFalse(graph.hasCycle());
	}
	
	@Test
	public void testLCA()
	{
		DAG graph = new DAG(10);
		
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 6);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(4, 8);
		graph.addEdge(8, 7);
		
		assertEquals(1, graph.findLCA(4, 5));
		assertEquals(8, graph.findLCA(7, 8));
		assertEquals(6, graph.findLCA(6, 7));
	}
	
	@Test
	public void testLCAforNoCommonAncestors()
	{
		DAG graph = new DAG(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 5);
		
		//Check LCA function works
		assertEquals(0, graph.findLCA(2, 1));
		assertEquals(3, graph.findLCA(2, 3));
		assertEquals(2, graph.findLCA(4, 5));
		
		//Check for non-present vertex
		assertEquals(-1, graph.findLCA(8, 2));
		
		//Check for negative vertex
		assertEquals(-1, graph.findLCA(-2, 3));
		assertEquals(-1, graph.findLCA(3, -2));
		assertEquals(-1, graph.findLCA(-2, -3));
	}
	
	@Test
	public void testLCAForNonDAG()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 4);
		
		assertEquals(-1, graph.findLCA(3, 2));
		assertEquals(-1, graph.findLCA(2, 4));
		assertEquals(-1, graph.findLCA(1, 3));
		assertEquals(-1, graph.findLCA(0, 3));
		assertEquals(-1, graph.findLCA(1, 2));
		
	}
	
	@Test
	public void testLCAForSameVertex()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		
		assertEquals(3, graph.findLCA(3, 3));
		
	}
	
	@Test
	public void testLCAForEmptyDAG()
	{
		DAG graph = new DAG(5);
		assertEquals(-1, graph.findLCA(0, 2));
		assertEquals(-1, graph.findLCA(0, 4));
		assertEquals(-1, graph.findLCA(0, 0));
	}
	
	

}
