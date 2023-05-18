package ProblemC;

public class IntegerMatrix extends GenericMatrix<Integer> {
    @Override /** Add two integers */
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override /** Multiply two integers */
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override /** Specify zero for an integer */
    protected Integer zero() {
        return 0;
    }

    public static int minMatrix(int[][] matrix_1, int[][] matrix_2){
        if (matrix_1.length != matrix_2.length){
            System.out.println("Matrices don't have same size");
        } else {
           Integer result_1 = Integer.MAX_VALUE;
           Integer result_2 = Integer.MAX_VALUE;
           for (int i = 0; i < matrix_1.length; i++){
               for (int j = 0; j < matrix_2.length; j++){
                   if (matrix_1[i][j] < result_1){
                       result_1 = matrix_1[i][j];
                   }
                   if (matrix_2[i][j] < result_2){
                       result_2 = matrix_2[i][j];
                   }
               }
           }
           return Integer.min(result_1, result_2);
        }
        return 0;
    }
}