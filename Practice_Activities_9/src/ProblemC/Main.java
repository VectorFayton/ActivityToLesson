package ProblemC;

public class Main {
    public static void main(String[] args){
        int[][] matrix_1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix_2 = new int[][]{
                {89, 45, 56},
                {123, -67, -456},
                {34, 23, -500}
        };
        System.out.println(IntegerMatrix.minMatrix(matrix_1, matrix_2));
    }
}
