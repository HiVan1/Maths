public class Main {
    private static double[] test = {1.25779, -0.82194, 0.24077, 0.75591, 0.88328};
    private double[] myAnswer;
    public static void main(String[] args) {
        Gauss gauss = new Gauss();
//        gauss.gauss();
//        System.out.print("\u03B4 = ");
//        pohubka(gauss.resultMat, test);
//
//        Matrix matrix = new Matrix();
//        System.out.println("Test 0.14505 = " + val(0.14505));
//        System.out.println("Test 1.34504 = " + val(1.34504));
//        System.out.println("Test 1.30003 = " + val(1.30003));
//        System.out.println("Test 123.506 = " + val(123.506));
//        System.out.println("Test 123.504 = " + val(123.504));
//        System.out.println("Test 123456789 = " + val(123456789));
         т



    }
    /*
    * 1.00004 = 000001
    * 1.00005 = 1.0000
    * 1.34567 = 1.3456
    * 1.34507 = 1.2345
    * 1.34505 = 1.3450
    * 1.34504 =
    * */
    public static String val(double n){
        char[] arrNum = Double.toString(n).toCharArray();
        char[] arrNum2 = new char[6];
        int count = 0, indexDot = -1;

        for (int i = 0; i < arrNum2.length; i++) {
            if (arrNum[i] == '.'){
                indexDot = i;
                break;
            }
        }
        if (indexDot != -1){
            if (Integer.parseInt(String.valueOf(arrNum[5])) == 0 && Integer.parseInt(String.valueOf(arrNum[6])) >= 5){
                for (int i = 0; i < arrNum2.length; i++) {
                    arrNum2[i] = arrNum[i];
                }
                return new String(arrNum2);

            }else if(Integer.parseInt(String.valueOf(arrNum[5])) == 0 && Integer.parseInt(String.valueOf(arrNum[6])) < 5){
                for (int i = arrNum2.length - 1; i >= indexDot; i--) {
                    System.out.println("arrNum[i] = " + arrNum[i]);
                    if (arrNum[i] == '0'){
                        count++;
                    }
                }
                System.out.println("count = " + count);
            }
        }



        return new String("не правильно");
    }

    public static void swap (char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    public static void pohubka(String[][] myAnswer, double[] test){
//        double result = 0;
//        for (int k = 0; k < myAnswer.length; k++) {
//            result += Math.pow( (Double.parseDouble(myAnswer[k][1]) - test[k]) ,2);
//        }
//        result /= myAnswer.length;
//        if (result == 0){
//            System.out.print("0");
//        }else if (result == Math.pow(10, -4)){
//            System.out.print("Math.pow(10, -4)");
//        }else if (result == Math.pow(10, -6)){
//            System.out.print("Math.pow(10, -6)");
//        }else{
//            System.out.print(result);
//        }
//    }
}