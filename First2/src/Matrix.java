import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private final int k1 = 24 - 25;
    private final int k2 = 24 - 21;
    private final double a = 0.25f * k1;
    private final double b = 0.35f * k2;
    private final double[][] startMatrixA = {{5.18 + a, 1.12, 0.95, 1.32, 0.83}, {1.12, 4.28 - a, 2.12, 5.57, 0.91}, {0.95, 2.12, 6.13 + a, 1.29, 1.57}, {1.32, 0.57, 1.29, 4.57 - a, 1.25}, {0.83, 0.91, 1.57, 1.25, 5.21 + a}};
    private final double[][] startMatrixB = {{6.19 + b}, {3.21}, {4.28 - b}, {6.25}, {4.95 + b}};
//    private double[][] helpMatrix;
//    private double[][] startMatrixA;
//    private double[][] startMatrixB;
    Random random = new Random();
    public List<Double> list;

    public Matrix(/*int sizeX, int sizeY*/){
        list = new ArrayList<>();
//        readFile();
//        Print print = new Print(3);
//        System.out.println("print file");
//        print.printMatrixAB(startMatrixA, startMatrixB);
//        startMatrixA = new double[sizeX][sizeY];
//        startMatrixB = new double[sizeX][1];
//        setStartMatrixA(sizeX,sizeY);
//        setStartMatrixB(sizeX);
    }
//
//    public void setStartMatrixA(int sizeX, int sizeY) {
//        for (int i = 0; i < sizeX; i++) {
//            for (int j = 0; j < sizeY; j++) {
//                startMatrixA[i][j] = random.nextDouble(1, 20);
//            }
//        }
//    }



    public void setStartMatrixB(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 1; j++) {
                startMatrixB[i][j] = random.nextDouble(1, 20);
            }
        }
    }
//    public void readFile(){
//        File file = new File("src/Matrix.txt");
//        int sizeX = 0, sizeY = 0, count = 0;
//        try {
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()){
//                sizeX++;
//                sizeY = scanner.nextLine().split(" ").length;
//            }
//            System.out.println("x = " + sizeX + " y = " + sizeY);
//            scanner.close();
//
//            helpMatrix = new double[sizeX][sizeY];
//            startMatrixA = new double[sizeX][sizeY-1];
//            startMatrixB = new double[sizeX][1];
//
//            Scanner scanner2 = new Scanner(file);
//            while (scanner2.hasNextLine()){
//                String line = scanner2.nextLine();
//                String[] arLine = line.split(" ");
//                for (int i = 0; i < arLine.length; i++) {
//                    helpMatrix[count][i] = Double.parseDouble(arLine[i]);
//                }
//                for (int i = 0; i < startMatrixA.length; i++) {
//                    for (int j = 0; j < startMatrixA[i].length; j++) {
//                        startMatrixA[i][j] = helpMatrix[i][j];
//                    }
//                    startMatrixB[i][0] = helpMatrix[i][sizeY-1];
//                }
//                count++;
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Error");
//        }
//    }

//    public void readFile() throws FileNotFoundException {
//        File file = new File("src/Matrix.txt");
//        Scanner scanner = new Scanner(file);
//        Scanner scanner1 = new Scanner(file);
//        int sizeX = -1;
//        String[] line = scanner.nextLine().split(" ");
//        while (scanner.hasNextLine()){sizeX++;}
//        helpMatrix = new double[sizeX][line.length];
//        while (scanner1.hasNextLine()){
//            String[] line1 = scanner1.nextLine().split(" ");
//            for (int i = 0; i < helpMatrix.length; i++) {
//                for (int j = 0; j < helpMatrix[i].length; j++) {
//                    helpMatrix[i][j] = Double.parseDouble(line1[j]);
//                }
//            }
//        }
//        startMatrixA = new double[helpMatrix.length][line.length];
//        startMatrixB = new double[helpMatrix.length][1];
//
//        for (int i = 0; i < startMatrixA.length; i++) {
//            for (int j = 0; j < startMatrixA[i].length; j++) {
//                startMatrixA[i][j] = helpMatrix[i][j];
//
//            }
//            startMatrixB[i][0] = helpMatrix[i][helpMatrix.length-1];
//        }
//    }
    public double[][] getStartMatrixA() {
        return startMatrixA;
    }

    public double[][] getStartMatrixB() {
        return startMatrixB;
    }
//
//    public double[][] getHelpMatrix() {
//        return helpMatrix;
//    }
}
