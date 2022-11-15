package exercise.exercise7;

//  xây dựng lớp cây nhị phân tìm kiếm
class BTree {
    Node root;

    BTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    // Duyệt cây để tìm kiếm nút có giá trị >x, nếu thấy hiển thị giá trị ra màn hình,
    // sau đó lại tìm tiếp cho đến khi nào duyệt hết các nút //trong cây
    void search(Node p, int x) {
        if (p == null) {
            return;
        }
        search(p.left, x);
        if (p.info > x) {
            System.out.print(p.info + " ");
        }
        search(p.right, x);
    }

    // Chèn thêm 1 nút vào trong cây
    Node insert(Node node, int x) {
        Node ins = new Node(x);
        if (node == null) {
            return ins;
        }

        if (node.info < x) {
             node.right = insert(node.right, x);
        }else if (node.info > x) node.left = insert(node.left, x);
        return node;
    }

    // Insert mảng a các số nguyên vào trong cây, trong hàm này sẽ gọi tới hàm insert(...)  nhiều lần
    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            root = insert(root, a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    // Duyệt theo thứ tự pre Order
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // Duyệt theo thứ tự In Order
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
}
