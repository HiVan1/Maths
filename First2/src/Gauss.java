import java.util.Arrays;

public class Gauss {
    private final int k1 = 24 - 25;
    private final int k2 = 24 - 21;
    private final float a = 0.25f * k1;
    private final float b = 0.35f * k2;
//    public double[][] matrixA = {{5.18+a, 1.12, 0.95, 1.32, 0.83},
//            {1.12, 4.28-a, 2.12, 5.57, 0.91},
//            {0.95, 2.12, 6.13+a, 1.29, 1.57},
//            {1.32, 0.57, 1.29, 4.57-a, 1.25},
//            {0.83, 0.91, 1.57, 1.25, 5.21+a}};
//
//    public double[][] matrixB ={{6.19+b},{3.21},{4.28-b},{6.25},{4.95+b}};

    public double[][] matrixA = {{3,2,-5},{2, -1, 3},{1, 2, -1}};
    public double[][] matrixB = {{-1}, {13}, {9}};
    private double[] matrixM;

    private int headLine;
    private int headColm;

    private double[][] testMat;
    private int count = 0;

    public Gauss(){
        matrixM = new double[matrixA.length];
        testMat = new double[matrixA.length][matrixA.length];
    }



    public void gausss(){
        if (count < matrixA.length){
            searchMainLine();
            createMatrixM();
            matrixNull();
            printMatrixAB(matrixA, matrixB);
            count++;
            gausss();
        }
    }



    public void searchMainLine(){
        double max = 0;
        int indexLine = 0, indexColm = 0;
        double[] helpMat;
        for (int i = count; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                if (Math.abs(matrixA[i][j]) > max){
                    max = Math.abs(matrixA[i][j]);
                    indexLine = i;
                    indexColm = j;
                }
            }
        }
//        headLine = indexLine;
        helpMat = matrixA[count];
        matrixA[count] = matrixA[indexLine];
        matrixA[indexLine] = helpMat;

        helpMat = matrixB[count];
        matrixB[count] = matrixB[indexLine];
        matrixB[indexLine] = helpMat;
        headLine = count;
        headColm = indexColm;
        System.out.println("Max = " + max);

    }

    public void createMatrixM(){
        for (int i = count+1; i < matrixM.length; i++) {
            matrixM[i] = matrixA[i][headColm]/matrixA[count][headColm];
        }
        printArray(matrixM);
    }

    public void matrixNull(){
        System.out.println("matrixNull");
        for (int i = count+1; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] -= matrixM[i] * matrixA[headLine][j];
                matrixB[i][0] -= matrixM[i] * matrixA[headLine][0];
                System.out.printf("\nmatrixB[%d][0] -= matrixM[%d] * matrixA[%d][0]", i, i, headLine);
            }
        }
        System.out.println();
    }

    public void printMatrixAB(double[][] arrayA, double[][] arrayB){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%.6f ", arrayA[i][j]);
            }
            System.out.printf("= %.6f ", arrayB[i][0]);
            System.out.println(" |");
        }
    }

    public void printMatrix(double[][] arrayA){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%.6f ", arrayA[i][j]);
            }
        }
    }

    public void printArray(double[] arrayM){
        System.out.print("M:  ");
        for (int i = 0; i < arrayM.length; i++) {
            System.out.printf("%.5f | ",arrayM[i]);
        }
        System.out.println();
    }
}
