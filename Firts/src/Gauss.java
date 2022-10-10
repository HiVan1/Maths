import java.util.Arrays;

public class Gauss {
    private double[][] matA;
    private double[][] matB;
    private double[] matM;
    private double[][] testMat;
    private int headLine;
    private int headColm;

    public Gauss(double[][] matrixA, double[][] matrixB){
        matA = matrixA;
        matB = matrixB;
        matM = new double[matrixA.length];
        testMat = new double[matrixA.length][matrixA.length];
    }

    public double[][] searchMainLine(double[][] matrixA){
        double max = 0;
        int indexLine = 0, indexColm = 0;
        double[] helpMat;
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[i].length; j++) {
                if (matA[i][j] > max){
                    max = matA[i][j];
                    indexLine = i;
                    indexColm = j;
                }
            }
        }
//        headLine = indexLine;
        helpMat = matA[0];
        matA[0] = matA[indexLine];
        matA[indexLine] = helpMat;

        helpMat = matB[0];
        matB[0] = matB[indexLine];
        matB[indexLine] = helpMat;
        headLine = 0;
        headColm = indexColm;
        return matrixA;
    }

    public double[] createMatrixM(double[][] mA){
        for (int i = headLine+1; i < matM.length; i++) {
            matM[i] = mA[i][headColm]/mA[headLine][headColm];
        }
        System.out.println("Matrix M");
        System.out.println(Arrays.toString(matM));
        return matM;
    }

    public void matrixNull(double[][] mA, double[][] mB, double[] mM){
        for (int i = headLine+1; i < mA.length; i++) {
            for (int j = 0; j < mA[i].length; j++) {
                mA[i][j] -= mM[i] * mA[headLine][j];
                mB[i][0] -= mM[i] * mB[headLine][0];
            }
        }
    }

    public void gauses(){
        int count = 0;
        double[][] testMatA = searchMainLine(matA);
        matM = createMatrixM(testMatA);
        matrixNull(testMatA, matB, matM);


    }
}
