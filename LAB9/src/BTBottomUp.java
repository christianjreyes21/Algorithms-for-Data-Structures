

public class BTBottomUp
{
    public static void main(String args[])
    {
        BT emptyTree = new BT(); //emptyTree.computeLevels
        System.out.println("If tree is empty: ");
        System.out.println(emptyTree);
        
        //Basic Work
        System.out.println();
        System.out.println("Basic Work: ");
        
        BTNode n1 = new BTNode("2");
        BTNode n2 = new BTNode("4");
        BTNode n3 = new BTNode("1", null, n1);
        BTNode n4 = new BTNode("5", n2, null);
        BTNode n5 = new BTNode("3", n3, n4);
        BT tree1 = new BT(n5);
        System.out.println("Number of Leaves: "+tree1.sumLeaves());
        tree1.computeLevels();
        System.out.println(tree1);
        System.out.println();
        
       
        System.out.println("Twist: ");
        BTNode E = new BTNode("E");
        BTNode G = new BTNode("G");
        BTNode D = new BTNode("D");
        BTNode L = new BTNode("L", G, D);
        BTNode F = new BTNode("F");
        BTNode B = new BTNode("B", E, null);
        BTNode A = new BTNode("A", null, L);
        BTNode H = new BTNode("H", B, F);
        BTNode K = new BTNode("K", A, null);
        BTNode C = new BTNode("C", null, H);
        BTNode S = new BTNode("S", C, K);
        BT tree2 = new BT(S);
        System.out.println("Number of Leaves: "+tree2.sumLeaves());
        tree2.computeLevels();
        System.out.println(tree2);
        System.exit(0);
        
    }
}