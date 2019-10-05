

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;




public class lowestCommonAncestorTest {
	

	
	@Test
	
	public void testEmpty() {
		lowestCommonAncestor<Integer, Integer> lca = new lowestCommonAncestor<Integer, Integer>();
		assertFalse("Checking if empty tree contains key ", lca.existsCheck(3));
		assertNull("Checking if we can get value from empty tree ", lca.getNode(0));
		
		
		
	}

	

}
