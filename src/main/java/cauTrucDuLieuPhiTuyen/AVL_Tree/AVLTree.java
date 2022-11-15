package cauTrucDuLieuPhiTuyen.AVL_Tree;

public class AVLTree<T extends Comparable<T>> {
    private int size;
    private AVLNode<T> root;

    //trả về bậc của node, nếu bằng null thì trả về 0 còn ko thì trả về biến height của node đó
    public int height(AVLNode<T> node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int max(int key1, int key2) {
        return Math.max(key1, key2);
    }

    //trả về hiệu số của chiểu cao nhánh trái và phải của node
    private int getBalance(AVLNode<T> node) {
        if (node == null) return 0;

        return height(node.getLeft()) - height(node.getRight());
    }

    public void AvlInsert(T key) {
        //sau khi chèn và xoay xong cần xác định lại root bằng chính kết quả trả về
        //hàm chèn khi nó đệ quy về node ban đầu
        this.root = AvlInsert(this.root, key);
    }

    //truyền vào root của cây avl cũ trả về root của cây avl mới sau khi chèn
    private  AVLNode<T> AvlInsert(AVLNode<T> node, T key){
        //đệ quy đến khi gặp trường hợp cơ sở là node = null thì tăng size lên 1 và thêm 1 node vào node null đó
        if (node == null) {
            this.size++;
            return new AVLNode<>(key);
        }

        //nếu key node đang xem xét nhỏ hơn key cần chèn thì gán cho nhánh phải đệ quy hàm còn ko thì ngược lại
        if (node.lessThan(key)) {
            node.setRight(AvlInsert(node.getRight(), key));
        }
        if (node.greaterThan(key)) {
            node.setLeft(AvlInsert(node.getLeft(), key));
        }

        //sau khi đệ quy đến trường hợp cơ sở và chèn vào node null 1 node mới thì
        //cần tính lại chiều cao các node bậc cao hơn nó đệ quy sẽ chạy ngược lại đến node ban đầu truyền vào
        // (vd root)
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);

        //tính lại xem node đang đệ quy có cân bằng ko, so sánh hiệu nhánh trái và phải
        // nếu cân bằng thì bỏ qua các if dưới và trả về chính node đó còn không trả về node đó bằng node khác đã xoay
        int balance = getBalance(node);

        //nếu > 1 thì là lệch trái chắc chắn cần xoay phải tại node này
        if (balance > 1) {//right
            //trong lệch trái xem có lệch trái- phải không tức node con trái của node <= node chèn vào
            //thì node chèn vào sẽ ở bên phải nên thành lệch trái-phải
            //nếu có cần xoay trái node nhánh trái trước rồi xoay phải node hiện tại
            if (node.getLeft().lessThan(key)) {
                node.setLeft(leftRotation(node.getLeft()));
            }
            return rightRotation(node);
        }else if (balance < -1) {//left làm ngược lại lệch trái
            if (node.getRight().greaterThan(key)) {
                node.setRight(rightRotation(node.getRight()));
            }
            return leftRotation(node);
        }

        return node;
    }

    //trả về node root của nhánh sau khi xoay trái
    private AVLNode<T> leftRotation(AVLNode<T> node) {
        //nếu node truyền vào null thì trả về null
        if (node == null) return null;

        //tạo node trung gian chứa nhánh phải của node
        AVLNode<T> returnNode = node.getRight();

        //gán nhánh phải của node là nhánh trái của node trung gian
        node.setRight(returnNode.getLeft());

        //gán nhánh trái node trung gian là node truyền vào
        returnNode.setLeft(node);

        //tìm lại chiều cao theo đúng thứ tự node truyền vào rồi đến node trung gian
        //vì giờ node truyền vào đã là con của node trung gian
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        returnNode.setHeight(max(height(returnNode.getLeft()), height(returnNode.getRight())) + 1);

        //trả về node trung gian
        return returnNode;
    }

    //trả về node root của nhánh sau khi xoay phải làm ngược lại xoay trái
    private AVLNode<T> rightRotation(AVLNode<T> node) {
        if (node == null) return null;

        AVLNode<T> returnNode = node.getLeft();
        node.setLeft(returnNode.getRight());
        returnNode.setRight(node);

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        returnNode.setHeight(max(height(returnNode.getLeft()), height(returnNode.getRight())) + 1);

        return returnNode;
    }

    public void printPreOrder() {
        System.out.print("\n");
        System.out.print("printPreOrder, size = " + this.size);
        System.out.print("\n");
        printPreOrder(this.root);
    }
    private void printPreOrder(AVLNode<T> node) {
        if (node == null) return;

        node.printInfo();
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder() {
        System.out.print("\n");
        System.out.print("printInOrder, size = " + this.size);
        System.out.print("\n");
        printInOrder(this.root);
    }
    private void printInOrder(AVLNode<T> node) {
        if (node == null) return;

        printInOrder(node.getLeft());
        node.printInfo();
        printInOrder(node.getRight());
    }

    public void insert(T data) {
        this.size++;
        //nếu chưa có root thì khởi tạo root với data cần chèn
        //không thì gọi hàm insert của nó
        if (root == null) {
            root = new AVLNode<>(data);
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

    public AVLNode<T> find(T data) {

        //nếu root ko null thì tìm bằng hàm find của nó còn ko thì trả về null
        if (root != null) {
            return root.find(data);
        }
        return null;
    }

    //xóa mềm, tức là node nó vẫn còn nhưng đánh dấu là đã xóa
    public void sortDelete(T data) {

        //tạo node toDel là kết quả tìm kiếm của hàm tìm
        AVLNode<T> toDel = find(data);

        //nếu find() trả về ko null tức là tìm thấy node cần xóa, đánh dấu node đó đã xóa bằng
        //hàm delete() gán biến isDeleted = true
        if (toDel != null) {
            toDel.delete();
        }
    }

    public void delete(T data) {
        AVLNode<T> current = this.root;
        AVLNode<T> parent = this.root;
        boolean leftChild = false;

        //nếu ngay từ đầu root là null thì ko cần xóa gì nữa
        if (current == null) {
            return;
        }

        //tìm kiếm giá trị cần xóa
        //lặp đến khi tìm thấy node current có giá trị cần tìm hoặc node là null thì dừng lại ta sẽ tìm được current và cha của nó
        while (current != null && !current.getKey().equals(data)) {

            //gán cho parent = current rồi thay đổi current thành nhánh trái hoặc phải tùy theo đk
            parent = current;

            //nếu giá trị cần tìm nhỏ hơn data của node current hiện tại thì current thành nhánh trái của nó và ngược lại
            if (current.getKey().compareTo(data) > 0) {
                current = current.getLeft();
                leftChild = true;//là nhánh trái gán cho leftChild = true và ngược lại
            } else {
                current = current.getRight();
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
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {//nếu cần xóa là root thì cho root = null
                root = null;
            }
            //còn không phải root thì xóa nhánh trái hoặc phải của biến parent(cha) đã tìm ở vòng lặp theo biến đánh dấu leftChild
            else {
                if (leftChild) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        }

        //phải là else if vì nếu là if thì current có cả nhánh trái, phải = null nó vẫn chạy
        //trường hợp current cần xóa chỉ có nhánh trái tức RightChild == null
        else if (current.getRight() == null) {
            //nếu current là root thì cho root thành nhánh trái
            if (current == root) {
                root = current.getLeft();
            } else if (leftChild) {//còn không phải root thì gán nhánh trái của current
                // thành nhánh(nhánh trái, phải tùy theo biến leftChild) của parent
                // tức là xóa current nối từ parent sang nhánh của current
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        }

        //trường hợp current cần xóa chỉ có nhánh phải tức LeftChild == null làm ngược lại chỉ có nhánh trái
        else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (leftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setLeft(current.getRight());
            }
        }

        //trường hợp cuối cùng là node có cả nhánh trái và phải
        else {

            //tạo biến maxNode, preNode và gán cho nó nhánh phải của node
            AVLNode<T> minNode = current.getRight();
            AVLNode<T> preNode = minNode;

            //tạo vòng lặp và tìm nhánh trái cuối cùng tính từ nhánh phải của node
            //giá trị này sẽ lớn hơn node hiện tại và nhỏ hơn tất cả các node khác trong nhánh phải node
            //hay chính là giá trị min của phía phải, sẽ dùng min này chiếm chỗ của node hiện tại cần xóa
            //cần tìm min của nhánh phải vì quy tắc của cây này là bằng thì sẽ chèn vào nhánh phải nên nếu
            //nhánh phải có nhiều node giống min lấy min nhánh phải thay vào node sẽ ko vi phạm quy tắc này
            //nếu quy tắc bằng chèn vào bên trái thì làm ngược lại
            while (minNode.getLeft() != null) {
                //gán pre là min rồi cho min là nhánh trái của nó đến khi nhánh trái của nó null thì dừng
                preNode = minNode;
                minNode = minNode.getLeft();
            }

            //tìm được min rồi thì gán nhánh trái của node min này là nhánh trái của node cần xóa hiện tại
            //vì chắc chắn nhánh trái của minNode là null nên ko ảnh hưởng
            //nếu min này vẫn là nhánh phải của node hiện tại tức là vòng while ko chạy
            //thì nhánh phải của min giữ nguyên ko bị ảnh hưởn nên ko cần làm gì thêm
            minNode.setLeft(current.getLeft());

            //trường hợp min này ko phải là nhánh phải node hiện tại tức là while đã chạy
            //cần gán nhánh phải min cho nhánh trái của node cấp trên min rồi mới gán nhánh phải của min cho nhánh phải
            //node hiện tại
            //nếu ko sẽ mất nhánh phải của min ban đầu
            if (minNode != current.getRight()) {
                preNode.setLeft(minNode.getRight());
                minNode.setRight(current.getRight());
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
                parent.setLeft(minNode);
            } else parent.setRight(minNode);
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
     * xóa node cần tìm
     *
     * @param node bắt đầu tìm
     * @param key  giá trị cần tìm để xóa
     * @return node root của cây đã xóa node cần xóa
     */
    private AVLNode<T> recursiveDelete(AVLNode<T> node, T key) {

        //nếu node đang tìm null thì trả về null
        if (node == null) {
            return null;
        }

        //nếu node đang tìm có data trùng key thì nó là node cần xóa
        if (node.getKey().equals(key)) {
            this.size--;//giảm size--

            //nếu nhánh phải của node null thì trả về nhánh trái node lần đệ quy trước là node trái hoặc phải
            // của node cha
            // coi như đã xóa node vì nó ko trả về node nữa
            if (node.getRight() == null) {
                return node.getLeft();
            }

            //nếu nhánh phải ko null thì lấy node có giá trị nhỏ nhất nhánh phải thay thế cho node
            //cho minNode là nhánh phải của node rồi gán min về phía nhánh trái của min đến hết là node có
            //giá trị nhỏ nhất
            //preNode sau vòng while sẽ là node cha của min
            AVLNode<T> minNode = node.getRight();
            AVLNode<T> preNode = minNode;

            //gán cho pre là min rồi min là nhánh trái của nó đến khi nhánh trái min là null
            //tức min là nhánh trái cuối cùng là node có giá trị nhỏ nhất phía nhánh phải node
            while (minNode.getLeft() != null) {
                preNode = minNode;
                minNode = minNode.getLeft();
            }

            //cho nhánh trái min là nhánh trái node, do nhánh trái min là null nên khi gán sẽ ko mất mát gì
            minNode.setLeft(node.getLeft());
            //nếu min vẫn là nhánh phải của node tức vòng while ko chạy thì nhánh phải của min ko cần thay đổi
            //nếu min ko còn là nhánh phải của node tức vòng while có chạy thì
            //gán nhánh phải của min cho nhánh trái của node cha của min rồi nhánh phải mới của min sẽ là
            //nhánh phải của node
            //khi này min đã có thể thay thế hoàn toàn node và ko trả về node tức là xóa node và trả về min là xong
            if (minNode != node.getRight()) {
                preNode.setLeft(minNode.getRight());
                minNode.setRight(node.getRight());
            }
            return minNode;

        }

        //nếu node đang tìm có data trùng không key thì so sánh key với giá trị của node nếu key >= thì gán nhánh phải node là
        //đệ quy nhánh phải ngược lại đệ quy nhánh trái
        if (node.lessThan(key)) {
            node.setRight(recursiveDelete(node.getRight(), key));
        } else {
            node.setLeft(recursiveDelete(node.getLeft(), key));
        }

        //khi node đang đệ quy ko phải node cần xóa thì trả về chính nó tức là node nhánh trái hoặc phải
        //của đệ quy node cha để đệ quy trước node.set..Child(đệ quy này) xác định được RightChild hoặc LeftChild
        return node;
    }
}
