package cauTrucDuLieuPhiTuyen.AVL_Tree;

public class AVLNode <T extends Comparable<T>> {
    private final T key;
    private int height;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private boolean isDeleted = false;

    public AVLNode(T data) {
        this.key = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public void printInfo() {
        System.out.print("key: " + this.key + "; height: " + this.height + "\n");
    }

    public boolean greaterThan(T key) {
        return this.key.compareTo(key) > 0;
    }

    public boolean lessThan(T key) {
        return this.key.compareTo(key) <= 0;
    }

    public boolean equal(int key) {
        return this.key.equals(key);
    }

    public T getKey() {
        return key;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void delete(){
        this.isDeleted = true;
    }

    public boolean isDelete(){
        return isDeleted;
    }

    public AVLNode<T> find(T data){

        //nếu dữ liệu cần tìm giống với dữ liệu node hiện tại thì trả về node này
        if (this.key.equals(data) && !isDeleted) {
            return this;
        }

        //nếu đữ liệu cần tìm nhỏ hơn thì gọi đệ quy nhánh  tìm bằng nhánh trái còn ko thì
        // nhánh phải sẽ chạy đến khi trái hoặc phải == null thì trả về null
        if (this.key.compareTo(data) > 0 && left != null) {
            return left.find(data);
        }

        //không cần dk so sánh vì nếu đã chạy câu lênh if trên thì nó sẽ ko chạy if này nữa vì
        //nếu đã chạy bên trái thì chỉ chạy bên trái đến khi null thì trả về mà sẽ ko chạy bên phải nữa
        //nên ko cần đk bên phải được chạy nó cũng ko chạy
        if (right != null) {
            return right.find(data);
        }

        return null;
    }

    public int height(AVLNode<T> node) {
        return (node == null) ? 0 : node.getHeight();
    }

    public void insert(T data){

        //nếu dữ liệu cần chèn lớn hơn dữ liệu node hiện tại thì xem xét nhánh bên phải
        //nếu nhánh phải là null thì khởi tạo nhánh phải với data cần chèn còn ko lại gọi đệ quy chèn từ nhánh phải
        if (this.key.compareTo(data) <= 0) {
            if (right == null) {
                right = new AVLNode<>(data);
            }else right.insert(data);
        }else {//trái tương tự phải
            if (left == null) {
                left = new AVLNode<>(data);
            }else left.insert(data);
        }

        //tính lại chiều cao của node
        this.height = Math.max(height(left), height(right)) + 1;
    }

    public T smallest(){
        if (this.left == null) {
            return this.key;
        }
        return this.left.smallest();
    }

    public T largest(){
        if (this.left == null) {
            return this.key;
        }
        return this.left.largest();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + key +
                '}';
    }
}
