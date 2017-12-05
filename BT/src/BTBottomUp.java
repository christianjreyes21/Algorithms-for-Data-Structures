public class BTBottomUp 
{

    public static void main(String[] args) 
    {
        BTNode a = new BTNode("2");
        BTNode b = new BTNode("4");

        BTNode c = new BTNode("1", null, a);
        BTNode d = new BTNode("5", b, null);

        BTNode e = new BTNode("3", c, d);

        BT t = new BT();
        t.setRoot(e);

        System.out.println(e.toString());
        t.computeLevels();
        System.out.println(t.toString());

    }
}
