

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
		DAG dag = new DAG(10);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 4);
		dag.addEdge(2, 5);
		dag.addEdge(4, 6);
		dag.addEdge(4, 7);
		
		assertEquals("checking for indegree",1, dag.indegree(4));
		assertEquals("checking fo routdegree",2, dag.outdegree(4));
		assertEquals("Checking edges", 5, dag.E());
		assertEquals("checking vertices", 10, dag.V());
		String adj = "[6, 7]";
		assertEquals(adj, dag.adj(4).toString());
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest(){
		
		//Can't make a directed dag with less than 0 vertices
		
		DAG dag = new DAG(-5);
	}
	
	@Test
	public void addEdge()
	{
		DAG dag = new DAG(5);
		
		dag.addEdge(1,2);

		//As negative, will print a system error and not addEdge
		dag.addEdge(-1, -6);
		
		//This will not addEdge as 12 > 5
		dag.addEdge(3, 12);
		
		assertEquals(1, dag.E());
	}
	
	@Test
	public void testIndegree()
	{
		DAG dag = new DAG(5);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 4);
		dag.addEdge(3, 3);
		
		assertEquals(1, dag.indegree(3));
		assertEquals(-1, dag.indegree(5));
	}
	
	@Test
	public void testOutdegree()
	{
		DAG dag = new DAG(5);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 4);
		dag.addEdge(3, 3);
		
		assertEquals(1, dag.outdegree(3));
		assertEquals(-1, dag.outdegree(5));
	}
	
	@Test 
	public void testV()
	{
		DAG dag = new DAG(6);
		assertEquals("checking creation of DAG", 6, dag.V());
	}
	
	@Test
	public void testE(){
		
		DAG dag = new DAG(5);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 3);
		dag.addEdge(3, 1);
		
		assertEquals("testing E()",3, dag.E());
	}
	
	@Test
	public void testAdj()
	{
		DAG dag = new DAG(5);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 4);
		dag.addEdge(3, 3);
		dag.addEdge(4, 3);
		
		String adj = "[4]";
		assertEquals(adj, dag.adj(2).toString());
	}
	
	@Test
	public void testforCycle()
	{
		DAG dag = new DAG(10);
		
		dag.addEdge(0, 1);
		dag.addEdge(1, 2);
		dag.addEdge(2, 0);
		dag.addEdge(2, 3);
		dag.addEdge(3, 4);
		
		dag.findCycle(0);
		
		assertTrue("checking for cycle in cyclic dag", dag.hasCycle());
	}
	
	@Test
	public void testAcyclicdag()
	{
		DAG dag = new DAG(10);
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 4);
		dag.addEdge(3, 3);
		
		dag.findCycle(1);
		assertFalse("Testing on an acyclic dag", dag.hasCycle());
	}
	
	@Test
	public void testLCA()
	{
		DAG dag = new DAG(10);
		
		
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(2, 4);
		dag.addEdge(2, 5);
		dag.addEdge(5, 7);
		dag.addEdge(3, 6);
		assertEquals("Assert LCA(2,3) is 1", dag.findLCA(2, 3), 1);
		assertEquals("Assert LCA(4,7) is 2", dag.findLCA(4, 7), 2);
		assertEquals("Assert LCA(7,6) is 1", dag.findLCA(7, 6), 1);
	}
	
	@Test
	public void testLCAforNoCommonAncestors()
	{
		DAG dag = new DAG(10);
		dag.addEdge(0, 1);
		dag.addEdge(0, 3);
		dag.addEdge(1, 3);
		dag.addEdge(3, 2);
		dag.addEdge(2, 4);
		dag.addEdge(1, 5);
		dag.addEdge(2, 5);
		
		
		assertEquals("Check LCA function works", 0, dag.findLCA(2, 1));
		assertEquals("Check LCA function works",3, dag.findLCA(2, 3));
		assertEquals("Check LCA function works",2, dag.findLCA(4, 5));		
		assertEquals("Check LCA function works for non presnet node",-1, dag.findLCA(8, 2));
		assertEquals("Check LCA function works for negatives",-1, dag.findLCA(-2, 3));
		assertEquals("Check LCA function works for negatives",-1, dag.findLCA(3, -2));
		assertEquals("Check LCA function works for negatives",-1, dag.findLCA(-2, -3));
	}
	
	@Test
	public void testLCAForNonDAG()
	{
		DAG dag = new DAG(10);
		
		dag.addEdge(0, 1);
		dag.addEdge(0, 3);
		dag.addEdge(3, 2);
		dag.addEdge(2, 0);
		dag.addEdge(2, 4);
		
		//Testing for dag with cycle
		assertEquals(-1, dag.findLCA(3, 2));
		assertEquals(-1, dag.findLCA(2, 4));
		assertEquals(-1, dag.findLCA(1, 3));
		assertEquals(-1, dag.findLCA(0, 3));
		assertEquals(-1, dag.findLCA(1, 2));
		
	}
	
	@Test
	public void testLCAForSameVertex()
	{
		DAG dag = new DAG(10);
		
		dag.addEdge(0, 1);
		dag.addEdge(0, 3);
		dag.addEdge(1, 3);
		
		assertEquals("checking for lca with ancestor on same vertex", 3, dag.findLCA(3, 3));
		
	}
	
	@Test
	public void testLCAForEmptyDAG()
	{
		DAG dag = new DAG(5);
		assertEquals("Empty DAG test", -1, dag.findLCA(0, 2));
		assertEquals("Empty DAG test",-1, dag.findLCA(0, 4));
		assertEquals("Empty DAG test",-1, dag.findLCA(0, 0));
	}
	
	

}
