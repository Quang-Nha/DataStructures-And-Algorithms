package cauTrucDuLieuPhiTuyen.test;

// Lớp cây nhị phân tìm kiếm
class BTree {
    Node root;

    BTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    // Hàm tìm kiếm
    Node search(Node p, int x) {
        if (p == null) return (null);
        if (p.info == x) return (p);
        if (x < p.info)
            return (search(p.left, x));
        else
            return (search(p.right, x));
    }

    // Hàm thêm 1 phần tử vào cây
    void insert(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (x < p.info) p = p.left;
            else p = p.right;
        }
        if (x < f.info) f.left = q;
        else f.right = q;
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) insert(a[i]);
    }

    // Hàm hiển thị thông tin một nút
    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    // Hàm duyệt Preorder
    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // Hàm duyệt Inorder
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    // HÀm duyệt Posorder
    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
}
