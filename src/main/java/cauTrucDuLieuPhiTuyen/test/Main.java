package cauTrucDuLieuPhiTuyen.test;

public class Main {
    public static void main(String[] args) {
        BTree t = new BTree();
        int[] a = {25, 10, 30, 5, 20, 10, 15};
        t.insertMany(a);
        System.out.println("\nPre-order traverse:");
        t.preOrder(t.root);
        System.out.println("\nIn-order traverse:");
        t.inOrder(t.root);
        System.out.println("\nPost-order traverse:");
        t.postOrder(t.root);
        System.out.println();
    }
}
