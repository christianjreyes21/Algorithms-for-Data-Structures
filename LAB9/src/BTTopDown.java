// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 10
// Trees
//
public class BTTopDown {
    public static void main(String args[])throws NullPointerException {
                                                                //create BST
        BST bst1 = new BST();
                                                                // insert nodes
        bst1.insert("K");
        bst1.insert("S");
        bst1.insert("D");
        bst1.insert("P");
        bst1.insert("A");
        bst1.insert("L");
        bst1.insert("H");
        bst1.insert("N");
        bst1.insert("Q");
        bst1.insert("M");
        bst1.insert("J");
        
        BT tree = new BT(bst1.root);                            // initialize tree
        
        tree.computeLevels();                                   // computes the levels
        System.out.println(tree);                               // prints the tree
        
        System.out.println("\n\n");                             // separator
        
        BT tree1 = new BT (bst1.search("P"));                   // initialize tree with searched
        tree1.setRootLevel(tree.getLevel(bst1.search("P")));    //sets the base level of the tree from search
        tree1.computeLevels();                                  // computes the levels
        System.out.println(tree1);                              // prints the tree
        
        System.out.println("\n\n");                             // separator
        
        BTNode foundLCA = bst1.findLCA("A","J");
        if(foundLCA==null)
        {
            System.out.println("no common ancestor");
        }
        else 
        {
            System.out.println("LCA = "+ foundLCA.key);
            BT tree2 = new BT(foundLCA);                        // initialize tree with searched
            tree2.setRootLevel(tree.getLevel(foundLCA));        //sets the base level of the tree from search
            tree2.computeLevels();                              // computes the levels
            System.out.println(tree2);                          // prints the tree
        }
        
        bst1.printPostOrderRec(bst1.root);
        
        System.out.println (bst1.countMoreInOrder(bst1.root,"K"));
        
        
        /*bst1.search("G");
        bst1.search("J");
        bst1.search("K");
        bst1.search("N");
        bst1.search("P");
        bst1.search("R");
        bst1.search("T");*/
    }
}
