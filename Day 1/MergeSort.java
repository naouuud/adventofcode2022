import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    public static int[] leftHalf(int[] original) {
        int length = original.length + 1;
        int[] left = new int[length / 2];
        for (int i = 0; i < left.length; i++) {
            left[i] = original[i];
        }
        // DEBUGGING CODE
        // System.out.print("LEFT: ");
        // for (int i = 0; i < left.length; i++) {
        //     System.out.print(left[i] + " ");
        // }
        // System.out.println();
        return left;
    }
    public static int[] rightHalf(int[] original) {
        int length = original.length + 1;
        int[] left = new int[length / 2];
        int[] right = new int[original.length - left.length];
        for (int i = 0; i < right.length; i++) {
            right[i] = original[left.length + i];
        }
        // DEBUGGING CODE
        // System.out.print("RIGHT: ");
        // for (int i = 0; i < right.length; i++) {
        //     System.out.print(right[i] + " ");
        // }
        // System.out.println();
        return right;
    }

    public static int[] merge(int[] left, int[] right) {
        ArrayList<Integer> leftAL = new ArrayList<Integer>();
        for (int i = 0; i < left.length; i++) {
            leftAL.add(left[i]);
        }
        ArrayList<Integer> rightAL = new ArrayList<Integer>();
        for (int i = 0; i < right.length; i++) {
            rightAL.add(right[i]);
        }
        ArrayList<Integer> mergedAL = new ArrayList<Integer>();
        while (leftAL.size() > 0 || rightAL.size() > 0) {
            if (leftAL.size() == 0) {
                mergedAL.add(rightAL.get(0));
                rightAL.remove(0);
            }
            else if (rightAL.size() == 0) {
                mergedAL.add(leftAL.get(0));
                leftAL.remove(0);
            }
            else if (leftAL.get(0) <= rightAL.get(0)) {
                mergedAL.add(leftAL.get(0));
                leftAL.remove(0);
            }
            else {
                mergedAL.add(rightAL.get(0));
                rightAL.remove(0);
            }
        }
        int[] merged = new int[mergedAL.size()];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = mergedAL.get(i);
        }
        // DEBUGGING CODE
        // System.out.print("Merged: ");
        // for (int i = 0; i < mergedAL.size(); i++) {
        //     System.out.print(mergedAL.get(i) + " ");
        // }
        return merged;
    }

    public static int[] sort(int[] unsorted) {
        if (unsorted.length == 1) return unsorted;
        else {
            return merge(sort(leftHalf(unsorted)), sort(rightHalf(unsorted)));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> unsortedAL = new ArrayList<Integer>();
        while (input.hasNextLine()) {
            unsortedAL.add(Integer.parseInt(input.nextLine()));
        }
        int[] unsorted = new int[unsortedAL.size()];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = unsortedAL.get(i);
        }
        int[] sorted = sort(unsorted);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
