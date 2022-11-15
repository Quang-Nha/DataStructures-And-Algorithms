package cauTrucDuLieuPhiTuyen.tree;

import cauTrucDuLieuPhiTuyen.AVL_Tree.AVLTree;

public class main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("Balanced Binary Search Tree - AVL Tree \n");
        System.out.print("Cây cân bằng - CNP \n");

        BinarySeachTree<Integer> bst = new BinarySeachTree<>();
        bst.insert(18);
        bst.insert(20);
        bst.insert(10);
        bst.insert(15);
        bst.insert(12);
        bst.insert(17);
        bst.insert(7);
        bst.insert(8);
        bst.insert(3);
        bst.insert(14);
        bst.printPreOrder();
        bst.recursiveDelete(0);
        bst.printPreOrder();
    }
}
