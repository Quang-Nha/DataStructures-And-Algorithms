package cauTrucDuLieuPhiTuyen.tree;

import java.util.ArrayList;

public class BinarySeachTree<T extends Comparable<T>> {
    private int size;
    private TreeNode<T> root;

    public void insert(T data) {
        this.size++;
        //nếu chưa có root thì khởi tạo root với data cần chèn
        //không thì gọi hàm insert của nó
        if (root == null) {
            root = new TreeNode<>(data);
        } else root.insert(data);
    }

    public T smallest() {
        if (root != null) {
            return root.smallest();
        }
        return null;
    }

    public T largest() {
        if (root != null) {
            return root.largest();
        }
        return null;
    }

    public TreeNode<T> find(T data) {

        //nếu root ko null thì tìm bằng hàm find của nó còn ko thì trả về null
        if (root != null) {
            return root.find(data);
        }
        return null;
    }

    //xóa mềm, tức là node nó vẫn còn nhưng đánh dấu là đã xóa
    public void sortDelete(T data) {

        //tạo node toDel là kết quả tìm kiếm của hàm tìm
        TreeNode<T> toDel = find(data);

        //nếu find() trả về ko null tức là tìm thấy node cần xóa, đánh dấu node đó đã xóa bằng
        //hàm delete() gán biến isDeleted = true
        if (toDel != null) {
            toDel.delete();
            size--;
        }
    }

    public void delete(T data) {
        TreeNode<T> current = this.root;
        TreeNode<T> parent = this.root;
        boolean leftChild = false;

        //nếu ngay từ đầu root là null thì ko cần xóa gì nữa
        if (current == null) {
            return;
        }

        //tìm kiếm giá trị cần xóa
        //lặp đến khi tìm thấy node current có giá trị cần tìm hoặc node là null thì dừng lại ta sẽ tìm được current và cha của nó
        while (current != null && !current.getData().equals(data)) {

            //gán cho parent = current rồi thay đổi current thành nhánh trái hoặc phải tùy theo đk
            parent = current;

            //nếu giá trị cần tìm nhỏ hơn data của node current hiện tại thì current thành nhánh trái của nó và ngược lại
            if (current.getData().compareTo(data) > 0) {
                current = current.getLeftChild();
                leftChild = true;//là nhánh trái gán cho leftChild = true và ngược lại
            } else {
                current = current.getRightChild();
                leftChild = false;
            }
        }

        //trường hợp vòng lặp trên tìm ra current cần xóa == null thì là ko tìm thấy và thoát
        if (current == null) {
            return;
        }
        //nếu current cần xóa ko null thì chắc chắn có node cần xóa giẩm size đi 1
        size--;

        //trường hợp tìm thấy current cần xóa ko null và nó là lá tức là nhánh trái, phải của nó là null
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {//nếu cần xóa là root thì cho root = null
                root = null;
            }
            //còn không phải root thì xóa nhánh trái hoặc phải của biến parent(cha) đã tìm ở vòng lặp theo biến đánh dấu leftChild
            else {
                if (leftChild) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }
        }

        //phải là else if vì nếu là if thì current có cả nhánh trái, phải = null nó vẫn chạy
        //trường hợp current cần xóa chỉ có nhánh trái tức RightChild == null
        else if (current.getRightChild() == null) {
            //nếu current là root thì cho root thành nhánh trái
            if (current == root) {
                root = current.getLeftChild();
            } else if (leftChild) {//còn không phải root thì gán nhánh trái của current
                // thành nhánh(nhánh trái, phải tùy theo biến leftChild) của parent
                // tức là xóa current nối từ parent sang nhánh của current
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        }

        //trường hợp current cần xóa chỉ có nhánh phải tức LeftChild == null làm ngược lại chỉ có nhánh trái
        else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (leftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }

        //trường hợp cuối cùng là node có cả nhánh trái và phải
        else {

            //tạo biến maxNode, preNode và gán cho nó nhánh phải của node
            TreeNode<T> minNode = current.getRightChild();
            TreeNode<T> preNode = minNode;

            //tạo vòng lặp và tìm nhánh trái cuối cùng tính từ nhánh phải của node
            //giá trị này sẽ lớn hơn node hiện tại và nhỏ hơn tất cả các node khác trong nhánh phải node
            //hay chính là giá trị min của phía phải, sẽ dùng min này chiếm chỗ của node hiện tại cần xóa
            //cần tìm min của nhánh phải vì quy tắc của cây này là bằng thì sẽ chèn vào nhánh phải nên nếu
            //nhánh phải có nhiều node giống min lấy min nhánh phải thay vào node sẽ ko vi phạm quy tắc này
            //nếu quy tắc bằng chèn vào bên trái thì làm ngược lại
            while (minNode.getLeftChild() != null) {
                //gán pre là min rồi cho min là nhánh trái của nó đến khi nhánh trái của nó null thì dừng
                preNode = minNode;
                minNode = minNode.getLeftChild();
            }

            //tìm được min rồi thì gán nhánh trái của node min này là nhánh trái của node cần xóa hiện tại
            //vì chắc chắn nhánh trái của minNode là null nên ko ảnh hưởng
            //nếu min này vẫn là nhánh phải của node hiện tại tức là vòng while ko chạy
            //thì nhánh phải của min giữ nguyên ko bị ảnh hưởn nên ko cần làm gì thêm
            minNode.setLeftChild(current.getLeftChild());

            //trường hợp min này ko phải là nhánh phải node hiện tại tức là while đã chạy
            //cần gán nhánh phải min cho nhánh trái của node cấp trên min rồi mới gán nhánh phải của min cho nhánh phải
            //node hiện tại
            //nếu ko sẽ mất nhánh phải của min ban đầu
            if (minNode != current.getRightChild()) {
                preNode.setLeftChild(minNode.getRightChild());
                minNode.setRightChild(current.getRightChild());
            }

            //sau khi tìm được min và gán đầy đủ đảm bảo thay thế được node cần xóa
            //xem node cần xóa có phải root ko, nếu có thì cho root là min này luôn
            if (current == root) {
                root = minNode;
            }
            //nếu không thì theo biến leftChild để xác định node cần xóa là
            // nhánh trái hay phải của node cấp trên nó và xác định lại nhánh con này của cấp trên
            // thành minNode thay cho node cần xóa
            else if (leftChild) {
                parent.setLeftChild(minNode);
            } else parent.setRightChild(minNode);
        }
    }

    /**
     * tìm và xóa node bắt đầu từ root, có thể dùng cả 2 hàm xóa theo đệ quy và không đệ quy, kết quả như nhau
     *
     * @param key xóa node có key cần tìm
     */
    public void recursiveDelete(T key) {
        //gán lại root của cây bằng root của hàm xóa bắt đầu từ root
        this.root = recursiveDelete(this.root, key);
    }

    /**
     * xóa node có data T cần tìm
     *
     * @param node bắt đầu tìm
     * @param key  giá trị cần tìm để xóa
     * @return node root của cây đã xóa node cần xóa
     */
    private TreeNode<T> recursiveDelete(TreeNode<T> node, T key) {

        //nếu node đang tìm null thì trả về null
        if (node == null) {
            return null;
        }

        //nếu node đang tìm có data trùng key thì nó là node cần xóa
        if (node.getData().equals(key)) {
            this.size--;//giảm size--

            //nếu nhánh phải của node null thì trả về nhánh trái node lần đệ quy trước là node trái hoặc phải
            // của node cha
            // coi như đã xóa node vì nó ko trả về node nữa
            if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            //nếu nhánh phải ko null thì lấy node có giá trị nhỏ nhất nhánh phải thay thế cho node
            //cho minNode là nhánh phải của node rồi gán min về phía nhánh trái của min đến hết là node có
            //giá trị nhỏ nhất
            //preNode sau vòng while sẽ là node cha của min
            TreeNode<T> minNode = node.getRightChild();
            TreeNode<T> preNode = minNode;
            //gán cho pre là min rồi min là nhánh trái của nó đến khi nhánh trái min là null
            //tức min là nhánh trái cuối cùng là node có giá trị nhỏ nhất phía nhánh phải node
            while (minNode.getLeftChild() != null) {
                preNode = minNode;
                minNode = minNode.getLeftChild();
            }

            //cho nhánh trái min là nhánh trái node, do nhánh trái min là null nên khi gán sẽ ko mất mát gì
            minNode.setLeftChild(node.getLeftChild());
            //nếu min vẫn là nhánh phải của node tức vòng while ko chạy thì nhánh phải của min ko cần thay đổi
            //nếu min ko còn là nhánh phải của node tức vòng while có chạy thì
            //gán nhánh phải của min cho nhánh trái của node cha của min rồi nhánh phải mới của min sẽ là
            //nhánh phải của node
            //khi này min đã có thể thay thế hoàn toàn node và ko trả về node tức là xóa node và trả về min là xong
            if (minNode != node.getRightChild()) {
                preNode.setLeftChild(minNode.getRightChild());
                minNode.setRightChild(node.getRightChild());
            }
            return minNode;

        }

        //nếu node đang tìm có data trùng không key thì so sánh key với giá trị của node nếu key >= thì gán nhánh phải node là
        //đệ quy nhánh phải ngược lại đệ quy nhánh trái
        if (node.lessThan(key)) {
            node.setRightChild(recursiveDelete(node.getRightChild(), key));
        } else {
            node.setLeftChild(recursiveDelete(node.getLeftChild(), key));
        }

        //khi node đang đệ quy ko phải node cần xóa thì trả về chính nó tức là node nhánh trái hoặc phải
        //của đệ quy node cha để đệ quy trước node.set..Child(đệ quy này) xác định được RightChild hoặc LeftChild
        return node;
    }

    public int height(TreeNode<T> node) {
        return (node == null) ? 0 : node.getHeight();
    }

    //
    private int max(int key1, int key2) {
        return Math.max(key1, key2);
    }

    //trả về hiệu số của chiểu cao nhánh trái và phải của node
    private int getBalance(TreeNode<T> node) {
        if (node == null) return 0;

        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    //gán lại root bằng root trả về của hàm chèn
    public void AvlFomat() {
        this.root = AvlFomat(this.root);
    }

    //trả về root 1 cây sau khi đã đổi nó sang cây avl
    private TreeNode<T> AvlFomat(TreeNode<T> node) {
        //trường hợp cơ sở nếu node null thì trả về null
        if (node == null) {
            return null;
        }

        //đệ quy cài đặt lại nhánh phải và trái
        node.setRightChild(AvlFomat(node.getRightChild()));

        node.setLeftChild(AvlFomat(node.getLeftChild()));

        //khi chạy hết đệ quy đến trường hợp cơ sở và chạy ngược lại tìm xem node có cân bằng ko
        // nếu có thì trả về chính nó còn không thì xoay để cho cân bằng rồi trả về
        int balance = getBalance(node);

        if (balance > 1) {//right
            if (getBalance(node.getLeftChild()) < 0) {
                node.setLeftChild(leftRotation(node.getLeftChild()));
            }
            node = rightRotation(node);
        } else if (balance < -1) {//left
            if (getBalance(node.getRightChild()) > 0) {
                node.setRightChild(rightRotation(node.getRightChild()));
            }
            node = leftRotation(node);
        }

        return node;
    }

    //trả về node sau khi xoay trái
    private TreeNode<T> leftRotation(TreeNode<T> node) {
        //nếu node truyền vào null thì trả về null
        if (node == null) return null;

        //tạo node trung gian chứa nhánh phải của node
        TreeNode<T> returnNode = node.getRightChild();

        //gán nhánh phải của node là nhánh trái của node trung gian
        node.setRightChild(returnNode.getLeftChild());

        //gán nhánh trái node trung gian là node truyền vào
        returnNode.setLeftChild(node);

        //tìm lại chiều cao theo đúng thứ tự node truyền vào rồi đến node trung gian
        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        returnNode.setHeight(max(height(returnNode.getLeftChild()), height(returnNode.getRightChild())) + 1);

        //trả về node trung gian
        return returnNode;
    }

    //trả về node sau khi xoay phải làm ngược lại xoay trái
    private TreeNode<T> rightRotation(TreeNode<T> node) {
        if (node == null) return null;

        TreeNode<T> returnNode = node.getLeftChild();
        node.setLeftChild(returnNode.getRightChild());
        returnNode.setRightChild(node);

        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        returnNode.setHeight(max(height(returnNode.getLeftChild()), height(returnNode.getRightChild())) + 1);

        return returnNode;
    }

    private void addToArray(TreeNode<T> node, ArrayList<TreeNode<T>> list) {
        // Base case
        if (node == null)
            return;

        // Store nodes in Inorder (which is sorted
        // order for BST)
        //duyệt cây bằng in order rồi gán tất cả vào 1 array list
        addToArray(node.getLeftChild(), list);
        list.add(node);
        addToArray(node.getRightChild(), list);
    }

    /* Recursive function to construct binary tree */
    //định dạng lại cây mới thành avl bằng nhị phân
    private TreeNode<T> addFromArrayToAvlTree(ArrayList<TreeNode<T>> list, int start,
                                              int end) {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        //tìm mid trong khoảng đầu và cuối rồi gán mid cho node đang đệ quy
        int mid = (start + end) / 2;
        TreeNode<T> node = list.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        //gán lại nhánh trái, phải bằng đệ quy nửa trái và phải của list, nửa trái là các node nhỏ hơn mid,
        //nửa phải là các node lớn hơn mid, như vậy nó sẽ sẽ được thêm vào cây đúng với định dạng trái < node < phải
        //liên tục thêm trái phải đều như vậy sẽ tạo thành cây cân bằng
        node.setLeftChild(addFromArrayToAvlTree(list, start, mid - 1));
        node.setRightChild(addFromArrayToAvlTree(list, mid + 1, end));

        //khi đệ quy đến trường hợp cơ sỏ chạy ngược lại tìm lại độ cao của node
        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);

        //trả về node được gán
        return node;
    }

    // This functions converts an unbalanced BST to
    // a balanced BST
    //gán lại root bằng root của cây avl
    public void converToAvl() {
        this.root = converToAvl(this.root);
    }

    //truyền vào root của cây cũ trả về root của cây được chuyển sang avl
    private TreeNode<T> converToAvl(TreeNode<T> node) {
        // Store nodes of given BST in sorted order
        //tạo list và thêm tất cả các node cần chuyển vào list theo thứ tự tăng dần bằng in order
        ArrayList<TreeNode<T>> list = new ArrayList<>();
        addToArray(node, list);

        // Constucts BST from nodes[]
        //cho n là độ dài của list
        int n = list.size();

        //hàm chuyển có đầu vào là list này và vị trí bắt đầu và kết thúc của nó
        //giá trị trả về của hàm này là root của cây avl
        return addFromArrayToAvlTree(list, 0, n - 1);
    }


    public void printPreOrder() {
        System.out.print("\n");
        System.out.print("printPreOrder, size = " + this.size);
        System.out.print("\n");
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode<T> node) {
        if (node == null) return;

        node.printInfo();
        printPreOrder(node.getLeftChild());
        printPreOrder(node.getRightChild());
    }

    public void printInOrder() {
        System.out.print("\n");
        System.out.print("printInOrder, size = " + this.size);
        System.out.print("\n");
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode<T> node) {
        if (node == null) return;

        printInOrder(node.getLeftChild());
        node.printInfo();
        printInOrder(node.getRightChild());
    }

}
