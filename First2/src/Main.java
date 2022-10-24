public class Main {
    private static double[] test = {1.25779, -0.82194, 0.24077, 0.75591, 0.88328};

    public static void main(String[] args) {
        Gauss gauss = new Gauss();
        gauss.gauss();

        System.out.print("\u03B4 = ");
        System.out.printf("%.12f\n", pohubka(gauss.resultMat, test));
    }

    public static double pohubka(String[][] myAnswer, double[] test){
        double result = 0;
        for (int k = 0; k < myAnswer.length; k++) {
            result += Math.pow( (Double.parseDouble(myAnswer[k][1]) - test[k]) ,2);
        }
        result /= myAnswer.length;
        return result;
    }
}