public class BT {

    protected BTNode root = null;
    protected int height = 0;

    public BT() {
    }

    public void setRoot(BTNode n) 
    {
        this.root = n;
    }

    public void computeLevels() 
    {
        BTNode p = root;
        Queue<BTNode> q = new Queue<>();

        if (p != null) 
        {
            q.enqueue(p);
            p.level = 1;

            while (!q.isEmpty()) 
            {
                p = q.dequeue();
                System.out.println("K=" + p.getKey() + " level=" + p.level);

                if (p.left != null) 
                {
                    q.enqueue(p.left);
                    p.left.level = p.level + 1;
                }
                if (p.right != null) 
                {
                    q.enqueue(p.right);
                    p.right.level = p.level + 1;
                }

            }

            height = p.level;

        }

    }

    public String toString() 
    {
        String info = "ht=" + height + " ";
        BTNode r = root;

        if (r != null) 
        {
            info += "[K=" + r.getKey();

            if (r.left != null) 
            {
                info += " L=" + r.left.toString() + "]";
            }

            if (r.right != null) 
            {
                info += " R=" + r.right.toString() + "]";
            }
        }

        if (r.left == null && r.right == null) 
        {
            info += "]";
        }

        return info;
    }

}
