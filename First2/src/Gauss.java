import java.util.Arrays;

public class Gauss {
    private final int k1 = 24 - 25;
    private final int k2 = 24 - 21;
    private final double a = 0.25f * k1;
    private final double b = 0.35f * k2;
    public double[][] startMatrixA = {{5.18+a, 1.12, 0.95, 1.32, 0.83},
            {1.12, 4.28-a, 2.12, 5.57, 0.91},
            {0.95, 2.12, 6.13+a, 1.29, 1.57},
            {1.32, 0.57, 1.29, 4.57-a, 1.25},
            {0.83, 0.91, 1.57, 1.25, 5.21+a}};

    public double[][] startMatrixB ={{6.19+b},{3.21},{4.28-b},{6.25},{4.95+b}};
//    public double[][] matrixA = {{(double) (5.18+a), 1.12f, 0.95f, 1.32f, 0.83f},
//            {1.12f, (double) (4.28-a), 2.12f, 5.57f, 0.91f},
//            {0.95f, 2.12f, (double) (6.13+a), 1.29f, 1.57f},
//            {1.32f, 0.57f, 1.29f, (double) (4.57-a), 1.25f},
//            {0.83f, 0.91f, 1.57f, 1.25f, (double) (5.21+a)}};
//
//    public double[][] matrixB ={{(double) (6.19+b)},{3.21f},{(double) (4.28-b)},{6.25f},{(double) (4.95+b)}};
//
//    public double[][] matrixA = {{3,2,-5},{2, -1, 3},{1, 2, -1}};
//    public double[][] matrixB = {{-1}, {13}, {9}};
//    public double[][] matrixA = {{2,5,4,1},{1,3,2,1},{2,10,9,7}, {3,8,9,2}};
//    public double[][] matrixB = {{20}, {11}, {40}, {37}};
    private double[] matrixM;
    private double[][] matrixA;
    private double[][] matrixB;

    private int headLine;
    private int headColm;

    private String[][] resultMat;
    private int count;

    public double[] nevazka;

    private final int significantNum = 6;

    public Gauss(){
        matrixA = startMatrixA;
        matrixB = startMatrixB;
        matrixM = new double[matrixA.length];
        resultMat = new String[matrixA.length][2];
        nevazka = new double[matrixB.length];
        count = 0;
    }



    public void gausss(){
        if (count == 0){
            System.out.println();
            System.out.println("Start matrix");
            printMatrixAB(matrixA, matrixB);
        }
        if (count < matrixA.length){
            searchMainLine();
            createMatrixM();
            matrixNull();
            printMatrixAB(matrixA, matrixB);
            count++;
            gausss();
        }else{
            reverse();
            System.out.println("Result matrix");
            printMatrixAB(matrixA, matrixB);
            setResultMat(matrixA, matrixB);

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
//        System.out.println("Max = " + max);
    }

    public void createMatrixM(){
        for (int i = count+1; i < matrixM.length; i++) {
            matrixM[i] = matrixA[i][headColm]/matrixA[count][headColm];
        }
    }

    public void matrixNull(){
        for (int i = count+1; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] -= matrixM[i] * matrixA[headLine][j];
            }
            matrixB[i][0] -= matrixM[i] * matrixB[headLine][0];
        }
        System.out.println();
    }

    public void reverse(){
        int indexJ = 0, indexI = 0;
        for (int j = matrixA.length - 1; j >= 0 ; j--) {
            for (int i = 0; i < matrixA.length; i++) {
                if (Math.abs(matrixA[j][i]) > 0.00001){
                    indexJ = j;
                    indexI = i;
//                    System.out.printf("matrixA[%d][%d] != 0\n", j, i);
                    for (int k = j-1; k >= 0 ; k--) {
                        matrixB[j][0] /= matrixA[j][i];
//                        System.out.printf("matrixB[%d][0] /= matrixA[%d][%d];\n", j, j, i);
                        matrixA[j][i] = 1;
//                        System.out.printf("matrixA[%d][%d] = 1\n", j, i);
                        matrixA[k][i] *= matrixB[j][0];
//                        System.out.printf("matrixA[%d][%d] *= matrixB[%d][0];\n", k, i, j);
                        matrixB[k][0] -= matrixA[k][i];
//                        System.out.printf("matrixB[%d][0] -= matrixA[%d][%d];\n", k, k, i);
                        matrixA[k][i] = 0;
//                        System.out.printf("matrixA[%d][%d] = 0\n", k, i);
                    }
                }
            }
        }
        matrixB[indexJ][0] /= matrixA[indexJ][indexI];
        matrixA[indexJ][indexI] = 1;
    }

    public void nevazka(){
        double[][] nevazkaMatA = new double[startMatrixA.length][startMatrixA.length];
        double[][] nevazkaMatB = new double[startMatrixB.length][startMatrixB.length];
        for (int i = 0; i < nevazkaMatA.length; i++) {
            for (int j = 0; j < nevazkaMatA[i].length; j++) {
//                nevazkaMatA[i][j] *= resultMat[]
            }
        }
    }



//    ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ =================================================

    public void setResultMat(double[][] matA, double[][] matB){
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA.length; j++) {
                if (matA[i][j] == 1){
                    resultMat[j][0] = "X" + String.valueOf(j+1) ;
                    resultMat[j][1] = String.valueOf(matB[i][0]) ;
                }
            }
        }
        for (int i = 0; i < resultMat.length; i++) {
            System.out.printf("%s = %s\n", significantNumbers(resultMat[i][0]), significantNumbers(resultMat[i][1]));
        }
    }

    public void printMatrixAB(double[][] arrayA, double[][] arrayB){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%5.2f ", arrayA[i][j]);
            }
            System.out.printf("= %5.2f ", arrayB[i][0]);
            System.out.println(" |");
        }
    }

    public void printMatrix(double[][] arrayA){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%5.2f ", arrayA[i][j]);
            }
        }
    }

    public void printArray(double[] arrayM){
        System.out.print("M: | ");
        for (int i = 0; i < arrayM.length; i++) {
            System.out.printf("%5.2f | ",arrayM[i]);
        }
        System.out.println();
    }

    public String significantNumbers(String num){
        char[] chTest = num.toCharArray();
        char[] chTest1;
        int sizeChar = chTest.length;
        if (sizeChar == significantNum){
            chTest1 = new char[significantNum];
            for (int i = 0; i < chTest1.length; i++) {
                chTest1[i] = chTest[i];
            }
            return new String(chTest1);
        }else if(sizeChar > significantNum){
            int index = 0;
            for (int i = 0; i < chTest.length; i++) {
                if (chTest[i] == '.'){
                    index = i;
                    break;
                }else{
                    index = significantNum;
                }
            }
            if (index < significantNum){
                chTest1 = new char[significantNum+1];
                for (int i = 0; i < chTest1.length; i++) {
                    chTest1[i] = chTest[i];
                }
                return new String(chTest1);
            }
            chTest1 = new char[index];
            for (int i = 0; i < index; i++) {
                if (i >= significantNum){
                    chTest1[i] = '0';
                }else{
                    chTest1[i] = chTest[i];
                }
            }
            return new String(chTest1);
        }else{
            return new String(chTest);
        }
    }


}
