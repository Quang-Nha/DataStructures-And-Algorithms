package cauTrucDuLieuPhiTuyen.tree;

import cauTrucDuLieuPhiTuyen.AVL_Tree.AVLNode;

public class TreeNode<T extends Comparable<T>> {
    private final T data;
    private int height = 1;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private boolean isDeleted = false;

    public TreeNode(T data) {
        this.data = data;
    }

    public void printInfo() {
        System.out.print("key: " + this.data + "; height: " + this.height + "\n");
    }

    public boolean greaterThan(T key) {
        return this.data.compareTo(key) > 0;
    }

    public boolean lessThan(T key) {
        return this.data.compareTo(key) <= 0;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
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

    public TreeNode<T> find(T data){

        //nếu dữ liệu cần tìm giống với dữ liệu node hiện tại thì trả về node này
        if (this.data.equals(data) && !isDeleted) {
            return this;
        }

        //nếu đữ liệu cần tìm nhỏ hơn thì gọi đệ quy nhánh tìm bằng hàm find của node nhánh trái còn ko thì
        // tìm bằng hàm find của node nhánh phải sẽ chạy đến khi trái hoặc phải == null thì trả về null
        if (this.data.compareTo(data) > 0 && leftChild != null) {
            return leftChild.find(data);
        }

        //không cần dk so sánh vì nếu đã chạy câu lênh if trên thì nó sẽ ko chạy if này nữa vì
        //nếu đã chạy bên trái thì chỉ chạy bên trái đến khi null thì trả về mà sẽ ko chạy bên phải nữa
        //nên ko cần đk bên phải được chạy nó cũng ko chạy
        if (rightChild != null) {
            return rightChild.find(data);
        }

        return null;
    }

    /**
     * @return trả về chiều cao của node truyền vào
     */
    public int height(TreeNode<T> node) {
        return (node == null) ? 0 : node.getHeight();
    }

    public void insert(T data){

        //nếu dữ liệu cần chèn lớn hơn dữ liệu node hiện tại thì xem xét nhánh bên phải
        //nếu nhánh phải là null thì khởi tạo nhánh phải với data cần chèn còn ko lại gọi đệ quy
        //hàm này của đối tượng nhánh phải để chèn từ nhánh phải
        if (this.data.compareTo(data) <= 0) {
            if (rightChild == null) {
                rightChild = new TreeNode<>(data);
            }else rightChild.insert(data);
        }else {//trái tương tự phải
            if (leftChild == null) {
                leftChild = new TreeNode<>(data);
            }else leftChild.insert(data);
        }
        //tính lại chiều cao của node khi đã đệ quy đến đỉnh và quay lại lệnh này
        this.height = Math.max(height(leftChild), height(rightChild)) + 1;
    }

    /**
     * @return giá trị của node có giá trị nhỏ nhất trong cây
     */
    public T smallest(){
        if (this.leftChild == null) {
            return this.data;
        }
        return this.leftChild.smallest();
    }

    /**
     * @return giá trị của node có giá trị lớn nhất trong cây
     */
    public T largest(){
        if (this.rightChild == null) {
            return this.data;
        }
        return this.rightChild.largest();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
