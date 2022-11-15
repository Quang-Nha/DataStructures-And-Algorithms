package search.binarySearchLinkedList;

// Java code to implement binary search
// on Singly Linked List

// Node Class
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}

class BinarySearch {
    // function to insert a node at the beginning
    // of the Singaly Linked List
    //chèn vào đầu list
    static Node push(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // Function to find middle element
    // using Fast and Slow pointers
    //tìm điểm giữa list
    static Node middleNode(Node start, Node last) {
        //nếu bắt đầu null thì trả về null
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start.next;

        //fast khác last thì cho fast dịch lên 1
        while (fast != last) {
            fast = fast.next;
            //tiếp tục khác thì dịch lên 1 rồi cho slow dịch lên 1
            if (fast != last) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    // function to insert a node at the beginning
    // of the Singly Linked List
    static Node binarySearch(Node head, int value) {
        Node start = head;
        Node last = null;

        do {
            // Find Middle
            //tìm mid
            Node mid = middleNode(start, last);

            // If middle is empty
            //nếu mid là null tức là start đã chạy đến null
            if (mid == null)
                return null;

            // If value is present at middle
            if (mid.data == value)
                return mid;

                // If value is less than mid
            //nếu data của mid lớn hơn giá trị cần tìm thì cho start là mid.next là nửa bên phải
            //vì đây là danh sách giảm dần nếu tăng dần thì ngược lại
            else if (mid.data > value) {
                start = mid.next;
            }

            // If the value is more than mid.
            //còn không thì cho last = mid là nửa bên trái
            else
                last = mid;
        } while (last == null || last != start);

        // value not present
        return null;
    }

    // Driver Code
    public static void main(String[] args) {
        Node head = null;

        // Using push() function to
        // convert singly linked list
        // 10 -> 9 -> 8 -> 7 -> 4 -> 1
        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 7);
        head = push(head, 8);
        head = push(head, 9);
        head = push(head, 10);
        int value = 0;

        if (binarySearch(head, value) == null) {
            System.out.println("Value not present");
        } else {
            System.out.println("Present");
        }
    }
}

// This code is contributed by Vivekkumar Singh

