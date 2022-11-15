package exercise.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int choice;
        int [] b = {5,7,11,3,9,2,6};

        SimpleSort t = new SimpleSort(b);

        t.bubbleSort();


    }
}
