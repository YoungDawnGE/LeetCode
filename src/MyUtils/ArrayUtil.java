package MyUtils;

/**
 * Created by GYC
 * 2020/8/13 15:08
 */
public class ArrayUtil {
    public static void printArray(boolean[][] array){
        int height = array.length;
        if (height == 0) {
            System.out.println("null");
            return;
        }
        int width = array[0].length;
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    public static void printArray(int[][] array){
        int height = array.length;
        if (height == 0) {
            System.out.println("null");
            return;
        }
        int width = array[0].length;
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    public static void printArray(char[][] array){
        int height = array.length;
        if (height == 0) {
            System.out.println("null");
            return;
        }
        int width = array[0].length;
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static void printArray(boolean[] array){
        int len = array.length;
        if (len == 0) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(char[] array){
        int len = array.length;
        if (len == 0) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] array){
        int len = array.length;
        if (len == 0) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
