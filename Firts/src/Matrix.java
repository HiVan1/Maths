public class Matrix {
    private final int k1 = 24 - 25;
    private final int k2 = 24 - 21;
    private final float a = 0.25f * k1;
    private final float b = 0.35f * k2;
    public double[][] matrixA = {{5.18+a, 1.12, 0.95, 1.32, 0.83},
                                {1.12, 4.28-a, 2.12, 5.57, 0.91},
                                {0.95, 2.12, 6.13+a, 1.29, 1.57},
                                {1.32, 0.57, 1.29, 4.57-a, 1.25},
                                {0.83, 0.91, 1.57, 1.25, 5.21+a}};
    public double[][] matrixB ={{6.19+b},{3.21},{4.28-b},{6.25},{4.95+b}};
//    public double[][] matrixA = {{-3.22, 0.54},
//                                {-0.31, 4.43}};
//    public double[][] matrixB ={{7.52},{0.80}};
    public void printMatrix(double[][] arrayA, double[][] arrayB){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%.6f ", arrayA[i][j]);
            }
            System.out.printf("= %.6f ", arrayB[i][0]);
            System.out.println(" |");
        }
    }
}
