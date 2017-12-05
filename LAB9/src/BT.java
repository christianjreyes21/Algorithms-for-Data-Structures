// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 10
// Trees
//
public class BT
{
    protected BTNode root;
    protected int height;
    
    public BT()
    {
        root = null;
    }
    
    public BT(BTNode n)
    {
        setRoot(n);
    }
    
    protected void setRoot(BTNode n)
    {
        root = n;
    }
    
    protected void visit(BTNode n)
    {
        System.out.println("K = " + n.key + "\t" + "Level = " + n.level);
    }
    
    protected void visit1(BTNode n)
    {
        System.out.print(" " + n.key);
    }
    
    protected int computeLevels()
    {
        BTNode p = root;
        Queue<BTNode> q = new <BTNode> Queue();
        if( p != null)
        {
            q.enqueue(p);
            while(! q.isEmpty())
            {
                p = q.dequeue();
                visit(p);
                if(p.left != null)
                {
                    q.enqueue(p.left);
                    p.left.level = p.level + 1;
                }
                if(p.right != null)
                {
                    q.enqueue(p.right);
                    p.right.level = p.level + 1;
                }
            }
        }
        height = p.level;
        return height;
    }
    
    protected void setRootLevel(int k)
    {
        root.level=k;
    }
    
    protected int getLevel(BTNode k)
    {
        int level=1;
        BTNode n = root;
        while(n!=null){
            if(k.key.compareTo(n.key)==0)
            {
                return level;
            }
            else 
            {
                if(k.key.compareTo(n.key)<0)
                {
                    n=n.left;
                    level++;
                }
                else 
                {
                    n = n.right;
                    level++;
                }
            }
        }
        return 0;
    }
    
    protected int sumLeaves()
    {
        int sum = 0;
        BTNode p = root;
        Queue <BTNode> q = new <BTNode> Queue();
        if(p != null)
        {
            q.enqueue(p);
            while(!q.isEmpty())
            {
                p = q.dequeue();
                //visit p 
                if(p.left != null)
                {
                    q.enqueue(p.left);
                }
                if(p.right != null)
                {
                    q.enqueue(p.right);
                }
                if(p.left == null && p.right == null)
                {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    public void inorder()
    {
        inorder(root);
    }
    
    public void inorder(BTNode n)
    {
        if (n != null)
        {
            inorder(n.left);
            visit(n);
            inorder(n.right);
        }
    }
    
    public String toString()
    {
        if(root != null) return "ht = " + height + "\n" + root.toString();
        else return "ht = 0";
    }
}