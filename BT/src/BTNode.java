public class BTNode 
{

    protected String key;
    protected BTNode left, right;
    protected int level;

    public BTNode() 
    {
        key = "";
        left = right = null;
    }

    public BTNode(String i) 
    {
        this(i, null, null);
    }

    public BTNode(String i, BTNode l, BTNode r) 
    {
        key = i;
        left = l;
        right = r;
    }

    public String getKey() 
    {
        return key;
    }

    public String toString() 
    {
        String info = "";

        if (getKey() != null) 
        {
            info += "[K=" + getKey();

            if (left != null) 
            {
                info += " L=" + left.toString() + "]";
            }

            if (right != null) 
            {
                info += " R=" + right.toString() + "]";
            }
        }

        if (left == null && right == null) 
        {
            info += "]";
        }

        return info;
    }

}
