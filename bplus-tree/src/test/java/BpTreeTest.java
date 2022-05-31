import destiny.bplus.BpNode;
import destiny.bplus.BpTree;
import destiny.bplus.Tuple;
import destiny.bplus.value.IntValue;
import destiny.bplus.value.Value;
import org.junit.Test;
import java.util.Random;


public class BpTreeTest {

    @Test
    public void testRandom() {
        BpTree tree = new BpTree();
        int n = 100000;
        Random random = new Random();
        int i;
        for (i = 0; i < n; i++) {
            int x = random.nextInt(n);
            Tuple tuple = createTuple(x);
            tree.insert(tuple);
            boolean isValid = tree.validate();
            if (!isValid) {
                break;
            }
        }
        System.out.println(i);
    }

    @Test
    public void test1() {
        BpTree bpTree = new BpTree();
        for (int i = 1; i <= 20; i++) {
            bpTree.insert(createTuple(i));
        }
        //bpTree.insert(createTuple(21));
        //printLink(bpTree.getHead());

        BpNode root = bpTree.getRoot();
        printTree(root);

//        bpTree.remove(createTuple(13));
//
//        printTree(root);


        System.out.println("root=" + bpTree.getRoot().getEntries().get(0).getValues()[0]);
        boolean isValid = bpTree.validate();
        System.out.println("isValid:" + isValid);

//        Tuple key = bpTree.find(createTuple(16));
//        System.out.println("key:" + key.getValues()[0]);

//        bpTree.remove(createTuple(21));
//        printLink(bpTree.getHead());
    }

    @Test
    public void test2(){
        int [] leaflist = {1,23,2,5,7,9,6,10,4,19,28,30,15,57,34,3,7,11,22,12,13,14};
        BpTree bpTree = new BpTree();
        for (int i : leaflist) {
            bpTree.insert(createTuple(i));
        }

        BpNode root = bpTree.getRoot();

        printTree(root);

        bpTree.remove(createTuple(5));

        printTree(root);
    }

    public static void printTree(BpNode root){
        System.out.print("根结点"+"\t\t\t\t\t\t");
        printNode(root);
        for (int k =0 ;k<2;k++){
            System.out.print("\n中间结点\t\t\t");
            printNode(root.getChildren().get(k));
            System.out.print("\n叶节点\t");
            for(int i=0;i<root.getChildren().get(k).getChildren().size();i++){
                printNode(root.getChildren().get(k).getChildren().get(i));
                System.out.print("\t\t");
            }
            System.out.println();
        }

    }

    private static void printNode(BpNode node) {
        for (Tuple key : node.getEntries()) {
            System.out.print(key.getValues()[0] + " ");

        }

    }

    private static void printLink(BpNode head) {
        while (head != null) {
            for (Tuple key : head.getEntries()) {
                System.out.print(key.getValues()[0] + " ");
            }
            head = head.getNext();
        }
    }

    private static Tuple createTuple(int i) {
        Value[] values = new Value[1];
        values[0] = new IntValue(i);
//        values[1] = new StringValue("fate");
        return new Tuple(values);
    }

    @Test
    public void testRemove() {
        int x = 44445 & 1;
        System.out.println(x);
    }
}
