public class Print {
    private int significantNum;
    public Print(int significantNum){
        this.significantNum = significantNum;
    }
    public String[][] setResultMat(double[][] matA, double[][] matB, String[][] resultMat, char a){
        if (matA.length > matA[0].length){
            for (int i = 0; i < matA.length; i++) {
                for (int j = 0; j < matA[i].length; j++) {
                    if (matA[i][j] == 1){
                        resultMat[j][0] = a + String.valueOf(j+1) ;
                        resultMat[j][1] = String.valueOf(matB[i][0]) ;
                    }
                }
            }
        }else{
            for (int i = 0; i < matA.length; i++) {
                for (int j = 0; j < matA.length; j++) {
                    if (matA[i][j] == 1){
                        resultMat[j][0] = a + String.valueOf(j+1) ;
                        resultMat[j][1] = String.valueOf(matB[i][0]) ;
                    }
                }
            }
        }
        return resultMat;
    }
    public void printMatrixAB(double[][] arrayA, double[][] arrayB){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
//                System.out.printf("%3.1f ", arrayA[i][j]);
                System.out.printf("%5.1f ", arrayA[i][j]);
            }
            System.out.printf("%5s %5.1f |\n", "=", arrayB[i][0]);
        }
    }

    public void printMatrix(double[][] arrayA){
        for(int i = 0; i < arrayA.length; i++) {
            System.out.printf("| ");
            for(int j = 0; j < arrayA[0].length; j++) {
                System.out.printf("%5.1f ", arrayA[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

//    public void printVector(String[][] arrayVector){
//        for (int i = 0; i < arrayVector.length; i++) {
//            System.out.printf("%s = %s\n", significantNumbers(arrayVector[i][0]), significantNumbers(arrayVector[i][1]));
//        }
//    }
    public void printVector(String[][] arrayVector){
        for (int i = 0; i < arrayVector.length; i++) {
            System.out.printf("%s = %s\n", arrayVector[i][0], arrayVector[i][1]);
        }
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
