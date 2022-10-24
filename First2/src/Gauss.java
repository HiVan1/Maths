public class Gauss {
    public double[][] startMatrixA;
    public double[][] startMatrixB;
    private double[] matrixM;
    private double[][] matrixA;
    private double[][] matrixB;

    private int headLine;
    private int headColm;

    public String[][] resultMat;
    private int count;

    public double[][] nevazka;


    public Matrix matrixStart;
    public Matrix matrixStart1;
    public Print print;

    public Gauss(){
        matrixStart = new Matrix();
        matrixStart1 = new Matrix();
        print = new Print();
        startMatrixA = matrixStart.getStartMatrixA();
        startMatrixB = matrixStart.getStartMatrixB();
        matrixA = matrixStart1.getStartMatrixA();
        matrixB = matrixStart1.getStartMatrixB();

        matrixM = new double[matrixA.length];
        resultMat = new String[matrixA.length][2];
        nevazka = new double[matrixB.length][1];
        count = 0;
    }

    public void gauss(){
        if (count == 0){
            System.out.println();
            System.out.println("Start matrix");
            print.printMatrixAB(matrixA, matrixB);
        }
        if (count < matrixA.length){
            searchMainLine();
            createMatrixM();
            matrixNull();
            print.printMatrixAB(matrixA, matrixB);
            count++;
            gauss();
        }else{
            reverse();
            System.out.println("Result matrix");
            print.printMatrixAB(matrixA, matrixB);
            print.setResultMat(matrixA, matrixB, resultMat, 'x');
            print.printVector(resultMat);
            System.out.println("NEVAZKA");
            nevazka();
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
        helpMat = matrixA[count];
        matrixA[count] = matrixA[indexLine];
        matrixA[indexLine] = helpMat;

        helpMat = matrixB[count];
        matrixB[count] = matrixB[indexLine];
        matrixB[indexLine] = helpMat;
        headLine = count;
        headColm = indexColm;
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
            for (int i = 0; i < matrixA[j].length; i++) {
                if (Math.abs(matrixA[j][i]) > 0.00001){
                    indexJ = j;
                    indexI = i;
                    for (int k = j-1; k >= 0 ; k--) {
                        matrixB[j][0] /= matrixA[j][i];
                        matrixA[j][i] = 1;
                        matrixA[k][i] *= matrixB[j][0];
                        matrixB[k][0] -= matrixA[k][i];
                        matrixA[k][i] = 0;
                    }
                }
            }
        }
        matrixB[indexJ][0] /= matrixA[indexJ][indexI];
        matrixA[indexJ][indexI] = 1;
    }

    public void nevazka(){
        double[][] nevazkaMatA = new double[startMatrixA.length][startMatrixA.length];
        for (int i = 0; i < nevazkaMatA.length; i++) {
            for (int j = 0; j < nevazkaMatA[i].length; j++) {
                nevazka[i][0] += startMatrixA[i][j] * Double.parseDouble(resultMat[j][1]);
            }
            nevazka[i][0] = startMatrixB[i][0] - nevazka[i][0];
        }
        print.printMatrix(nevazka);
    }
}
