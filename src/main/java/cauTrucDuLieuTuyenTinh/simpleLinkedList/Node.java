package cauTrucDuLieuTuyenTinh.simpleLinkedList;

import java.util.ArrayList;
//T lúc này được coi là 1 đối tượng
public class Node<T extends Comparable<T>> {//cho T kế thừa Comparable<T>
    //để chắc chắn đối tượng T sau khi gán kiểu có thực thi Comparable thì mới thực hiện được hàm compareTo()
    private T data;
    private Node nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }


    @Override
    public String toString() {
        if (nextNode == null) {
            return data + " ";
        }else {
            return data + ", ";
        }
    }


    public int compareTo(T a)
    {//khi mà đối tượng data đã được gán kiểu, vd Interger thì khi này kiểu đó sẽ thực thi hàm compareTo
        return (data).compareTo(a);
    }
}
