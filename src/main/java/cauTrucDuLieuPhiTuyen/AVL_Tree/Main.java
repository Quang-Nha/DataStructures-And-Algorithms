package cauTrucDuLieuPhiTuyen.AVL_Tree;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("Balanced Binary Search Tree - AVL Tree \n");
        System.out.print("Cây cân bằng - CNP \n");

        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.AvlInsert(100);
        avlTree.AvlInsert(200);
        avlTree.AvlInsert(300);
        avlTree.AvlInsert(300);
        avlTree.AvlInsert(400);
        avlTree.AvlInsert(500);
        avlTree.AvlInsert(600);
        avlTree.AvlInsert(700);
        avlTree.AvlInsert(800);
        avlTree.AvlInsert(900);
        avlTree.AvlInsert(1000);
        avlTree.AvlInsert(1100);
        avlTree.AvlInsert(1200);
        avlTree.AvlInsert(555);
        avlTree.printInOrder();
    }
}
