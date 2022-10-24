import java.util.Random;

public class Matrix {
    private final int k1 = 24 - 25;
    private final int k2 = 24 - 21;
    private final double a = 0.25f * k1;
    private final double b = 0.35f * k2;
    private final double[][] startMatrixA = {{5.18 + a, 1.12, 0.95, 1.32, 0.83}, {1.12, 4.28 - a, 2.12, 5.57, 0.91}, {0.95, 2.12, 6.13 + a, 1.29, 1.57}, {1.32, 0.57, 1.29, 4.57 - a, 1.25}, {0.83, 0.91, 1.57, 1.25, 5.21 + a}};
    private final double[][] startMatrixB = {{6.19 + b}, {3.21}, {4.28 - b}, {6.25}, {4.95 + b}};

    Random random = new Random();

    public Matrix(/*int sizeX, int sizeY*/){
//        readFile();
//        Print print = new Print(3);
//        System.out.println("print file");
//        print.printMatrixAB(startMatrixA, startMatrixB);
//        startMatrixA = new double[sizeX][sizeY];
//        startMatrixB = new double[sizeX][1];
//        setStartMatrixA(sizeX,sizeY);
//        setStartMatrixB(sizeX);
    }

    public double[][] getStartMatrixA() {
        return startMatrixA;
    }

    public double[][] getStartMatrixB() {
        return startMatrixB;
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
}
