// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 10
// Trees
//
public class BST extends BT {
    public BTNode root;
    protected BTNode p;
    
    public void insert(String k){
        if(root==null){
            root=new BTNode(k);
            return;
        }
        BTNode n = root;
        p=null;
        
        while(n!=null){
            p=n;
            if (k.compareTo(n.key)<0){
                n=n.left;                
            }
            else 
            {
                n= n.right;
            }
        }
        
        if (k.compareTo(p.key)<0){
            p.left = new BTNode(k);
        }
        else {
            p.right = new BTNode(k);
        }
    }
    
    public BTNode search(String k){
        BTNode n = root;
        while(n!=null){
            if(k.compareTo(n.key)==0)
            {
                return n;
            }
            else 
            {
                if(k.compareTo(n.key)<0)
                {
                    n=n.left;
                }
                else 
                {
                    n = n.right;
                }
            }
        }
        return null;
    }
    
    public BTNode findLCA(String k1, String k2)
    {
        if (search(k1)==null || search(k2)==null)
            return null;
        BTNode k1Reference = root;
        BTNode k2Reference = root;
        Queue<BTNode> k1Queue = new <BTNode> Queue();
        Queue<BTNode> k2Queue = new <BTNode> Queue();
        
        while(k1Reference!=null)
        {
            p=k1Reference;
            if (k1.compareTo(k1Reference.key)<0)
            {
                k1Queue.enqueue(k1Reference);
                k1Reference=k1Reference.left;                
            }
            else 
            {
                k1Queue.enqueue(k1Reference);
                k1Reference=k1Reference.right; 
            }
        }
        
        while(k2Reference!=null)
        {
            if (k2.compareTo(k2Reference.key)<0)
            {
                k2Queue.enqueue(k2Reference);
                k2Reference=k2Reference.left;                
            }
            else 
            {
                k2Queue.enqueue(k2Reference);
                k2Reference=k2Reference.right; 
            }
        }
        BTNode tempReference=root;
        while(k1Queue.first().key.compareTo(k2Queue.first().key)==0)
        {
            tempReference=k1Queue.dequeue();
            k2Queue.dequeue();
        }
        
        return tempReference;
    }
    
    protected void printInOrderRec(BTNode currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.key + ", ");
        printInOrderRec(currRoot.right);
    }
    
    protected int countMoreInOrder(BTNode currRoot, String k) {
        if (currRoot == null) {
            return 0;}
        int z=0;
        z+=countMoreInOrder(currRoot.left,k);
        
        if (currRoot.key.compareTo(k)<0)
        {
            z++;
        }
        z+=countMoreInOrder(currRoot.right,k);
        return z;
    }
    
    protected void printPreOrderRec(BTNode currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.print(currRoot.key + ", ");
        printPreOrderRec(currRoot.left);
        printPreOrderRec(currRoot.right);
    }
    
    protected void printPostOrderRec(BTNode currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostOrderRec(currRoot.left);
        printPostOrderRec(currRoot.right);
        System.out.print(currRoot.key + ", ");

    }
}
