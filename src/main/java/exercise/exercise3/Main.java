package exercise.exercise3;

public class Main {
    public static void main(String[] args) {
        MyList t = new MyList();
        int[] a = {7, 2, 9, 8, 6, 3};
        t.addMany(a);
        System.out.println("\n Traverse: ");
        t.traverse();
        System.out.println("\n Search: ");
        t.Search(8);
        System.out.println();
    }
}