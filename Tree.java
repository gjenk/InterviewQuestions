import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Tree {
	private TreeNode root;
	private int numElements;
	
	public Tree()
	{
		root = null;
		numElements = 0;
	}
	
	public boolean add(int n)
	{
		int oldSize = size();
		root = add(root, n);
		return oldSize != size();
	}
	
	private TreeNode add(TreeNode node, int n)
	{
		if (node == null)
		{
			node = new TreeNode(n);
			numElements++;
		}
		else if (node.val == n)
		{
			
		}
		else if( n >= node.val)
		{
			node.right = add(node.right, n);
		}
		else
		{
			node.left = add(node.left, n);
		}
		
		return node;	
		
	}
	
	public boolean remove(int n)
	{
		int oldSize = size();
		root = remove(root, n);
		return oldSize > size();
		
	}
	
	private TreeNode remove(TreeNode node, int n)
	{
		if (node == null)
		{
			
		}
		else if (node.val > n)
		{
			node.left = remove(node.left, n);
		}
		else if( node.val < n)
		{
			node.right = remove(node.right, n);
		}
		else
		{
			//Remove logic for current node being removed.
		}
		return node;
				
	}
	
	public boolean BFS( int n )
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode cur;
		q.add(root);
		
		while(!q.isEmpty())
		{
			cur = q.remove();
			if(cur.val == n)
				return true;
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null)
				q.add(cur.right);
		}
		return false;		
		
	}
	
	public Map<Integer, LinkedList<LinkedNode>> LLperHeight()
	{
		Map<Integer, LinkedList<LinkedNode>> out = new HashMap<Integer, LinkedList<LinkedNode>>();
		int height = getHeight(root);
		
		for (int i = 0; i < height; i++)
		{
			out.put(i,  new LinkedList<LinkedNode>());
		}
		
		return null;
	}
	
	private int getHeight(TreeNode root)
	{
		if (root == null)
			return 0;
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if (left > right)
			return left + 1;
		else
			return right + 1;	

	}
	
	private int size()
	{
		return numElements;
	}
	
	public void printTree(){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode tmp;
		q.add(root);
		int curCount = 1;
		int nextCount = 0;
		
		while (!q.isEmpty()){
			tmp = q.remove();
			curCount--;
			System.out.print(tmp.val + " ");

			if(tmp.left != null)
			{
				q.add(tmp.left);
				nextCount++;
			}
			if(tmp.right != null)
			{
				q.add(tmp.right);
				nextCount++;
			}
			if(curCount == 0)
			{
				System.out.print("\n");
				curCount = nextCount;
				nextCount = 0;
				
			}
			
			
		}
		
	
	}
	
	public TreeNode MostRecentAncestor(TreeNode node, TreeNode p, TreeNode q)
	{
		if(!covers(node, p) || !covers(node, q))
			return null;
		return MostRecentAnscestorHelper(node, p, q);
	}
	
	public TreeNode MostRecentAnscestorHelper(TreeNode node, TreeNode p, TreeNode q)
	{	
		if(node == null)
			return null;
		if(node == p)
			return node;
		if(node == q)
			return node;
		boolean is_p_left = covers(node.left, p);
		boolean is_q_left = covers(node.left, q);
		
		if(is_p_left != is_q_left)
			return node;
		TreeNode newParent;
		if(is_p_left)
			newParent = node.left;
		else
			newParent = node.right;
		
		return MostRecentAnscestorHelper(newParent, p, q);
	}
	
	private boolean covers(TreeNode parent, TreeNode child)
	{
		if (parent == null)
			return false;
		else if (parent == child)
			return true;
		return covers(parent.left, child) || covers(parent.right, child);		
		
	}
	
	
	
	
	
	
}
