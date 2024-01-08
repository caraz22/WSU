package Recursion;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] list, int key, int low, int high) {
        if (low > high) {
            return -1;
        } 

        int mid = (low + high) / 2;

        if (key < list[mid]) {
            return binarySearch(list, key, low, mid - 1);
        } else if (key == list[mid]) {
            return mid;
        } else {
            return binarySearch(list, key, mid + 1, high);
        } 
    }

    public static int search(int[] list, int key) {
        return binarySearch(list, key, 0, list.length - 1);
    }
    
    //1, 2, 5, 7, 10, 13, 17
    public static void main(String[] args) {
        int[] listInts = {1, 2, 5, 7, 10, 13, 17};
        // int index = listInts[binarySearch(listInts, 2, 0, listInts.length - 1)];
        int index = search(listInts, 8);
        if (index != -1) {
            System.out.println(listInts[index]);
        } else {
            System.out.println("not found");
        }
    }
}
