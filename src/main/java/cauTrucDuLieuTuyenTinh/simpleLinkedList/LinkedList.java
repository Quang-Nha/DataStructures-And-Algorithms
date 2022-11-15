package cauTrucDuLieuTuyenTinh.simpleLinkedList;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public void insertAtHead(T data) {

        //gọi hàm khởi tạo node mới
        Node<T> newNode = new Node<T>(data);
        if (this.tail == null) {
            this.tail = newNode;
        }
        //cho next của node mới là head(đang là một node được tạo gần nhất trước đó)
        //nếu đây là node đầu tiên thì head sẽ là null
        newNode.setNextNode(this.head);
        //gán head là node mới
        this.head = newNode;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void insertAtTail(T data) {
        Node<T> newNode = new Node<T>(data);
        //nếu tail không rỗng thì cho next của tail là node mới
        //rồi cho tail bằng node mới
        if (this.tail != null) {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
        //nếu chưa có tail tức đây là node đầu tiên đưa vào
        //thì cho tail và head cùng bằng node mới
        //không được cho 2 if này đổi chỗ vì khi tail = null
        //được gán bằng newNode rồi sau đó mới so sánh tail != null
        //thì dk này lại đúng và tiếp tục thực hiện
        //hoặc có thể cho 2 if này thành 1 if-else chỉ thực hiện 1 trong 2
        if (isEmpty()) {
            this.tail = newNode;
            this.head = newNode;
        }

    }

    public void swap(Node<T> a, Node<T> b){
        T tmp = a.getData();
        a.setData(b.getData());
        b.setData(tmp);
    }

    public void selectionSort() {
        Node<T> i = head;
        Node<T> j;
        Node<T> min;
        while (i.getNextNode() != null){
            j = i.getNextNode();
            min = i;
            while (j != null){
                if (j.getData().compareTo(min.getData()) < 0) {
                    min = j;
                }
                j = j.getNextNode();
            }
            if (min != i) {
                swap(i, min);
            }
            i = i.getNextNode();
        }
    }

    public void deleteFromHead() {
        if (isEmpty()) {
            return;
        }

        if (length() == 1) {
            this.tail = null;
        }
        //cho head là head.next
        this.head = this.head.getNextNode();
    }

    public Node<T> search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public void deleteFromTail(){
        //nếu chiều dài = 0 thì thoát
        if (isEmpty()) {
            return;
        }
        //bằng 1 thì cho head về null
        if (length() == 1) {
            this.head = null;
            this.tail = null;
            return;
        }
        Node<T> current = head;
        //chạy từ đầu đến áp cuối
        while (current.getNextNode().getNextNode() != null){
            current = current.getNextNode();
        }
        //sét cho next của áp cuối bằng null và tail = áp cuối
        current.setNextNode(null);
        this.tail = current;
    }

    public void deleteNode(T data){
        if (isEmpty()) {
            return;
        }
        boolean dk = true;

        //nếu đầu của head giống data thì gọi hàm xóa đầu
        //dùng lặp vì có thể xóa head này thì head mới cũng có thể giống data
        //có thể list chỉ còn 1 sản phẩm nên khi xóa sẽ bị rỗng và vòng lặp xem điều kiện this.head.getData().equals(data) sẽ bị lỗi
        //nên sau đó kiểm tra sau xóa nếu list đã rỗng thì thông báo xóa xong và thoát luôn
        while (this.head.getData().equals(data)) {
            deleteFromHead();
            dk = false;
            if (isEmpty()) {
                System.out.println("Đã xóa thành công");
                return;
            }
        }

        //đuôi cũng tương tự
        while (this.tail.getData().equals(data)){
            deleteFromTail();
            dk = false;
            if (isEmpty()) {
                System.out.println("Đã xóa thành công");
                return;
            }
        }

        //sau khi xem xét xóa đầu và xóa đuôi thì nếu xóa hết thì vòng while dưới sẽ không chạy
        //nếu còn 1 node hoặc thì chắc chắn nó không trùng dữ liệu cần xóa nên vòng while dưới sẽ không chạy
        //nếu còn 2 node thì chắc chắn chắn nó không trùng dữ liệu cần xóa nên vòng while thứ 2 dưới sẽ không chạy
        Node<T> curr = this.head;
        while (curr.getNextNode() != null){//chạy từ đầu cho tới áp cuối

            //nếu next của node hiện tại giống data thì xóa next, tiếp tục lặp nếu next tiếp nữa vẫn giống
            //vòng while này chỉ làm việc với list từ 3 node trở lên và các node head và tail chắc chắn không
            //thảo mãn dk vì đã chạy hàm xóa tất cả các node head và tail trùng với điều kiện
            //nên curr.getNext() chắc chắn lúc nào cũng khác null vì đến khi curr.getNext() = tail thì do nó không trùng điều kiện nên sẽ thoát
            //và vòng lặp ngoài cập nhật curr thành tail và curr.getNext() sẽ thành null nên thoát luôn
            while (curr.getNextNode().getData().equals(data)) {
                curr.setNextNode(curr.getNextNode().getNextNode());
                dk = false;
            }
            curr = curr.getNextNode();
        }
        if (dk) {
            System.out.println("Không tìm thấy sản phẩm cần xóa");
        }else {
            System.out.println("Đã xóa thành công");
        }

    }

    public void insertAfter(T data, T insert){
        if (isEmpty()) {
            return;
        }
        Node<T> newNode;
        Node<T> curr = this.head;
        //chạy từ đầu đến hết
        while (curr != null){
            //gọi hàm khởi tạo của phần tử cần chèn bên trong vòng lặp vì tạo ngoài sẽ chỉ gọi hàm khởi tạo
            // 1 lần thì sẽ chỉ có 1 biến chèn
            //nếu cần chèn thêm chỗ khác không thể tạo thêm biến mới chèn vào nếu dùng biến chèn cũ
            //sẽ làm loạn list, next của biến chèn cũ sẽ nhảy sang next của vị trí cần chèn
            newNode = new Node<T>(insert);
            if ((curr.getData() + "").equals(data + "")) {
                newNode.setNextNode(curr.getNextNode());
                curr.setNextNode(newNode);
                //nhảy biến đếm thêm 1 lần để bỏ qua giá trị vừa chèn nhảy đến vị trí tiếp theo của lúc chưa chèn
                curr = curr.getNextNode();
            }
            curr = curr.getNextNode();
        }
    }

    public void insertBefore(T data, T insert){
        if (isEmpty()) {
            return;
        }
        Node<T> curr = this.head;
        Node<T> newNode;
        //nếu head là vị trí cần chèn thì gọi hàm chèn trước
        if ((head.getData() + "").equals(data + "")) {
            insertAtHead(insert);
            curr = curr.getNextNode();//nhảy biến tạm thêm 1 để phần chèn sau bỏ qua head mới vừa chèn
            //và vòng lặp sau tính từ head cuối
        }
        //chạy từ đầu nếu không phải chèn trước head đến áp cuối
        while (curr.getNextNode() != null){
            //tạo hàm khởi tạo trong vòng lặp tương tự chèn sau
            newNode = new Node<T>(insert);
            //nếu next của node hiện tại trùng data thì chèn vào phía trước next
            if ((curr.getNextNode().getData() + "").equals(data + "")) {
                newNode.setNextNode(curr.getNextNode());
                curr.setNextNode(newNode);
                //chèn xong thì nhảy biến đếm thêm 1 để bỏ qua giá trị vừa chèn nếu không
                //thì next của giá trị chèn sẽ luôn giống với data và lại chèn vào trước dẫn đến lặp vô hạn
                curr = curr.getNextNode();
            }
            curr = curr.getNextNode();
        }
    }

    public int length() {
        int length = 0;
        Node<T> current = head;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    @Override
    public String toString() {
        String print = "{";
        //cho current là head
        Node<T> current = this.head;
        //nếu current không phải là null thì cộng thêm current vào print
        //rồi cho current là node tiếp theo bằng cách cho current = biến nextNode(trỏ tới node trước đó)
        while (current != null) {
            print += current;
            current = current.getNextNode();
        }
        print += "}";
        return print;
    }
}
