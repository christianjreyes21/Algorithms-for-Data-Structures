// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 10
// Trees
//
public class BTNode
{
    protected String key;
    public int level = 0;
    protected BTNode left, right;
    
    public BTNode()
    {
        level = 0;
        key = null;
        left = right = null;
    }
    
     public BTNode(String i)
     {
        this(i, null, null);
     }
    
    public BTNode(String i, BTNode l, BTNode r)
    {
        level = 1;
        key = i;
        left = l;
        right = r;
    }
    
    public String toString()
    {
        String s = "";
        s = s + "[ K = " + key;
        if(left != null) s = s + " L = " + left.toString();
        if(right != null) s = s + " R = " + right.toString();
        s = s + "] ";
        return s;
    }
}