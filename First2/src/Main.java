public class Main {
    protected static double a = 1.57895;
    protected static double b = 7.89474;
    public static double[][] arA = {{3,2,-5},{3.8,0.2,0},{0,a,0}};
    public  static double[][] arB = {{-1}, {12.4}, {b}};
    public static Gauss gauss;

    public static void main(String[] args) {

//        gauss.printMatrixAB(gauss.matrixA, gauss.matrixB);
//        gauss.gausss();
//        int[] num = {1,2,3,4,5,6,7,8,9};
//        for (int i = 0; i < num.length; i++) {
//            if (num[i] == 4){
//                continue;
//            }
//            System.out.print(num[i]+ " ");
//        }
        gauss = new Gauss();
        gauss.gausss();
//        System.out.println(gauss.significantNumbers("123"));
//        gauss.printMatrixAB(gauss.matrixA, gauss.matrixB);
//        System.out.println("Start matrix");
//        gauss.printMatrixAB(arA, arB);
//        System.out.println("Result");
//        test();
//        System.out.println();
//        gauss.printMatrixAB(arA, arB);
//        System.out.println();
//        gauss.printMatrix(arB);


    }

//    public static void test(){
////        int size = arA.length;
////        int count = 2;
////        for (int i = 0; i < arA.length; i++) {
////            if (arA[size - count][i] != 0) {
////                for (int g = size - count; g >= 0; g--) {
////                    arA[g][i] *= arB[size - count][0];
////                    arB[g][0] -= arA[g][i];
////                    arA[g][i] = 0;
////                    count++;
////                }
////            }
////            count = 0;
////            gauss.printMatrixAB(arA, arB);
////            System.out.println();
////        }
//        int indexJ = 0, indexI = 0;
//        for (int j = arA.length - 1; j >= 0 ; j--) {
//            for (int i = 0; i < arA.length; i++) {
//                if (arA[j][i] != 0){
//                    indexJ = j;
//                    indexI = i;
//                    System.out.printf("arA[%d][%d] != 0\n", j, i);
//                    for (int k = j-1; k >= 0 ; k--) {
//                        arB[j][0] /= arA[j][i];
//                        System.out.printf("arB[%d][0] /= arA[%d][%d];\n", j, j, i);
//                        arA[j][i] = 1;
//                        System.out.printf("arA[%d][%d] = 1\n", j, i);
//                        arA[k][i] *= arB[j][0];
//                        System.out.printf("arA[%d][%d] *= arB[%d][0];\n", k, i, j);
//                        arB[k][0] -= arA[k][i];
//                        System.out.printf("arB[%d][0] -= arA[%d][%d];\n", k, k, i);
//                        arA[k][i] = 0;
//                        System.out.printf("arA[%d][%d] = 0\n", k, i);
//                        gauss.printMatrixAB(arA, arB);
//                    }
//                }
//            }
//        }
//        arB[indexJ][0] /= arA[indexJ][indexI];
//        arA[indexJ][indexI] = 1;
//    }
}