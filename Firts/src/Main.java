import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        Gauss gauss = new Gauss(matrix.matrixA, matrix.matrixB);

//        matrix.printMatrix(matrix.matrixA, matrix.matrixB);
//        System.out.println();
//        gauss.searchMainLine();
//        matrix.printMatrix(matrix.matrixA, matrix.matrixB);
//
//        gauss.matrixNull(matrix.matrixA, matrix.matrixB, gauss.createMatrixM(matrix.matrixA));
//        matrix.printMatrix(matrix.matrixA, matrix.matrixB);
        gauss.gauses();
        matrix.printMatrix(matrix.matrixA, matrix.matrixB);

//        int[][] test1 = {{1,2},{3,4}};
//        int[][] test2 = {{3,4},{1,2}};
//        int count = 0;
//        test1[count++] = test2[count];
//        System.out.println(Arrays.toString(test2[0]));
    }

}