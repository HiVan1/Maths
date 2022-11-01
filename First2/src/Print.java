public class Print {
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
                System.out.printf("%8s ", num(arrayA[i][j]));
            }
            System.out.printf("%5s %8s |\n", "=", num(arrayB[i][0]));
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

    public void printVector(String[][] arrayVector){
        for (int i = 0; i < arrayVector.length; i++) {
            System.out.printf("%s = %s\n", arrayVector[i][0], arrayVector[i][1]);
        }
    }

    public static String num(double n) {
        String str = String.format("%.4f", n);
        String str1;
        int zeroN = 0;

        if (n == 1){
            return "000001";
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' && i < 6) {
                zeroN++;
            }
        }
        if (zeroN >=4) {
            str1 = "0";
            return str1;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                str = str.substring(0, i);
            } else {
                break;
            }
        }

        int index1 = str.indexOf(',');

        if (str.length() >= 6 && index1 <= 5 ) {
            str1 = str.substring(0, index1 + 1) + str.substring(index1 + 1, 6);
        } else {
            int c = 6 - str.length();
            String zero = "";
            for (int i = 0; i < c; i++) {
                zero += "0";
            }
            if (str.charAt(0) == '-' ) {
                str1 = str.charAt(0) + zero + str.substring(1, str.length());
            } else {
                str1 = zero + str.substring(0, str.length());
            }
        }
        return str1;
    }
}
