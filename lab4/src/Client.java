import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.Naming;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class CompleteCalculation {
    Integer n;
    int[][] x;
    int[][] A;
    int[][] A1;
    int[][] A2;
    int[][] B2;
    int[][] b1;
    int[][] c1;

    int[][] C2;

    int[][] y1;

    int[][] y2;

    int[][] Y3;

    public CompleteCalculation(Integer sizeOfArray) {
        n = sizeOfArray;

        x = new int[n][n];
        A = new int[n][n];
        A1 = new int[n][n];
        A2 = new int[n][n];
        B2 = new int[n][n];
        C2 = new int[n][n];
        b1 = new int[n][1];
        c1 = new int[n][1];
        y1 = new int[n][n];
        y2 = new int[n][n];
        Y3 = new int[n][n];
    }

    public void calculatec1(int[][] matrix){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            matrix[i][0] = random.nextInt(10) + 1;
        }
    }

    public void calculateb1(int[][] matrix){
        Random random = new Random();
        for (int i = 1; i < n; i++) {
            if(i%2 == 0){
                b1[i-1][0] = 24/(i*i + 4);
            }
            else{
                b1[i-1][0] = 24;
            }
        }
    }

    public int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public void calculateC2(int[][] matrix){
        Random random = new Random();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i-1][j-1] = 24/((i+1) + 3*((j+1)*(j+1)));
            }
        }
    }

    public void calculateMatrix(int[][] matrix){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(51) + 1;
            }
        }
    }

    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] multiplyMatrixByVector(int[][] matrix, int[][] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][1]; // Вектор завжди буде матрицею rows x 1

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j] * vector[j][0];
            }
            result[i][0] = sum;
        }

        return result;
    }

    // Метод для множення матриці на матрицю
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; k < cols1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public int[][] multiplyMatrixByScalar(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }

    public int[][] addScalarToMatrix(int[][] matrix, int[][] scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int sc = scalar[0][0];

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] + sc;
            }
        }

        return result;
    }

    public int[][] subtractVectorFromMatrix(int[][] matrix, int[][] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Перевірка, чи вектор має правильний розмір
        if (vector.length != rows || vector[0].length != 1) {
            throw new IllegalArgumentException("Invalid vector size for subtraction.");
        }

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] - vector[i][0];
            }
        }
        return result;
    }


    public int[][] transposeVector(int[][] vector) {
        int rows = vector.length;
        int cols = vector[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = vector[i][j];
            }
        }

        return result;
    }

    public int[][] powerMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += matrix[i][k] * matrix[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Функція для виведення вектора на екран
    public void printColumnVector(int[][] columnVector) {
        for (int i = 0; i < columnVector.length; i++) {
            System.out.println(columnVector[i][0]);
        }
    }
}

interface ResultProvider {
    int[][] getResult();
}

class CallerMultiple implements Runnable{
    CompleteCalculation target;
    int[][] result;
    Method methodToCall;

    int[][] M1;
    int[][] M2;
    Thread t;

    public CallerMultiple(CompleteCalculation target, String methodName, int[][]matrix1, int[][]matrix2) {
        this.target = target;
        try {
            this.methodToCall = CompleteCalculation.class.getMethod(methodName, int[][].class, int[][].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        M1 = matrix1;
        M2 = matrix2;
        t = new Thread(this);
        t.start();
    }

    public int[][] getResult() {
        return result;
    }

    // синхронізовані виклики call()
    public void run() {
        synchronized (target) {
            try {
                // Викликати метод, використовуючи посилання на метод
                result = (int[][]) methodToCall.invoke(target, M1, M2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

class Caller implements Runnable{
    CompleteCalculation target;
    int[][] result;
    Method methodToCall;

    int[][] M1;
    Thread t;

    public Caller(CompleteCalculation target, String methodName, int[][]matrix1) {
        this.target = target;
        try {
            this.methodToCall = CompleteCalculation.class.getMethod(methodName, int[][].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        M1 = matrix1;

        t = new Thread(this);
        t.start();
    }

    public int[][] getResult() {
        return result;
    }

    // синхронізовані виклики call()
    public void run() {
        synchronized (target) {
            try {
                // Викликати метод, використовуючи посилання на метод
                result = (int[][]) methodToCall.invoke(target, (Object) M1);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Замініть на IP-адресу або ім'я хоста сервера //10.50.188.152
        System.out.println("Client connect to server \n \"rmi://" + serverAddress + ":3000/Calculation\"");

        try {
            Calculator rC = (Calculator) Naming.lookup("rmi://" + serverAddress + ":3000/Calculation");
            System.out.println("Client connected successfully");

            // Створюємо об'єкт Scanner для отримання вводу від користувача
            Scanner scanner = new Scanner(System.in);

            // Виводимо повідомлення для користувача
            System.out.print("Введіть розмірність матриць (n): ");

            // Отримуємо введений текст від користувача
            Integer n = scanner.nextInt();

            // Закриваємо Scanner, коли він більше не потрібен
            scanner.close();

            CompleteCalculation equation = new CompleteCalculation(n);

            Caller obj1 = new Caller(equation, "calculateMatrix", equation.A);
            Caller obj2 = new Caller(equation, "calculateMatrix", equation.A1);
            Caller obj3 = new Caller(equation, "calculateMatrix", equation.A2);
            Caller obj4 = new Caller(equation, "calculateMatrix", equation.B2);
            Caller obj5 = new Caller(equation, "calculatec1", equation.c1);
            Caller obj6 = new Caller(equation, "calculateb1", equation.b1);
            Caller obj7 = new Caller(equation, "calculateC2", equation.C2);

            try {
                obj1.t.join();
                obj2.t.join();
                obj3.t.join();
                obj4.t.join();
                obj5.t.join();
                obj6.t.join();
                obj7.t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("Matrix A: \t");
            equation.printMatrix(equation.A);
            System.out.println("Matrix A1: \t");
            equation.printMatrix(equation.A1);
            System.out.println("Matrix A2: \t");
            equation.printMatrix(equation.A2);
            System.out.println("Matrix B2: \t");
            equation.printMatrix(equation.B2);
            System.out.println("Matrix c1: \t");
            equation.printMatrix(equation.c1);
            System.out.println("Matrix b1: \t");
            equation.printMatrix(equation.b1);
            System.out.println("Matrix C2: \t");
            equation.printMatrix(equation.C2);

            int[][] newc1 = equation.multiplyMatrixByScalar(equation.c1, 24);
            CallerMultiple tempy2 = new CallerMultiple(equation, "subtractMatrices", equation.b1, newc1);

            int[][] newC2 = equation.multiplyMatrixByScalar(equation.C2, 24);
            CallerMultiple tempY3 = new CallerMultiple(equation, "addMatrices", equation.B2, newC2);


            try {
                tempy2.t.join();
                tempY3.t.join();

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("b1 - 24c1 = ");
            int[][] resultFromTempy2 = tempy2.getResult();
            equation.printMatrix(resultFromTempy2);
            System.out.println("B2 + 24C2 = ");
            int[][] resultFromTempY3 = tempY3.getResult();
            equation.printMatrix(resultFromTempY3);

            CallerMultiple finaly1 = new CallerMultiple(equation, "multiplyMatrixByVector", equation.A, equation.b1);
            CallerMultiple finaly2 = new CallerMultiple(equation, "multiplyMatrixByVector", equation.A1, resultFromTempy2);
            CallerMultiple finalY3 = new CallerMultiple(equation, "multiplyMatrices", equation.A2, resultFromTempY3);

            try {
                finaly1.t.join();
                finaly2.t.join();
                finalY3.t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println("y1 = A * b1 = ");
            equation.y1 = finaly1.getResult();
            equation.printMatrix(equation.y1);
            System.out.println("y2 = A1 * (b1 - 24c1) = ");
            equation.y2 = finaly2.getResult();
            equation.printMatrix(equation.y2);
            System.out.println("Y3 = A2 * (B2 + 24C2) = ");
            equation.Y3 = finalY3.getResult();
            equation.printMatrix(equation.Y3);


            int[][] Y3_mul_y1;
            int[][] Y3pow;
            int[][] y1transp;
            int[][] y2transp;

            CallerMultiple obj8 = new CallerMultiple(equation, "multiplyMatrixByVector", equation.Y3, equation.y1);
            Caller obj9 = new Caller(equation, "powerMatrix", equation.Y3);
            Caller obj10 = new Caller(equation, "transposeVector", equation.y1);
            Caller obj11 = new Caller(equation, "transposeVector", equation.y2);

            try {
                obj8.t.join();
                obj9.t.join();
                obj10.t.join();
                obj11.t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("Y3 * y1 = ");
            Y3_mul_y1 = obj8.getResult();
            equation.printMatrix(Y3_mul_y1);
            System.out.println("Y3^2 = ");
            Y3pow = obj9.getResult();
            equation.printMatrix(Y3pow);
            System.out.println("y1' = ");
            y1transp = obj10.getResult();
            equation.printMatrix(y1transp);
            System.out.println("y2' = ");
            y2transp = obj11.getResult();
            equation.printMatrix(y2transp);

            int[][] Y3_mul_y1_plus_y2;
            int[][] y2transp_mul_Y3pow;


            CallerMultiple obj12 = new CallerMultiple(equation, "addMatrices", Y3_mul_y1, equation.y2);
            CallerMultiple obj13 = new CallerMultiple(equation, "multiplyMatrices", y2transp, Y3pow);

            try {
                obj12.t.join();
                obj13.t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("Y3 * y1 + y2 = ");
            Y3_mul_y1_plus_y2 = obj12.getResult();
            equation.printMatrix(Y3_mul_y1_plus_y2);
            System.out.println("y2' * Y3^2 = ");
            y2transp_mul_Y3pow = obj13.getResult();
            equation.printMatrix(y2transp_mul_Y3pow);

            int[][] y2transp_mul_Y3pow_mul_y1;

            CallerMultiple obj14 = new CallerMultiple(equation, "multiplyMatrixByVector", y2transp_mul_Y3pow, equation.y1);

            try {
                obj14.t.join();

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("y2' * Y3^2 * y1 = ");
            y2transp_mul_Y3pow_mul_y1 = obj14.getResult();
            equation.printMatrix(y2transp_mul_Y3pow_mul_y1);

            int[][] y2transp_mul_Y3pow_mul_y1_plus_y1transp = equation.addScalarToMatrix(y1transp, y2transp_mul_Y3pow_mul_y1);
            int[][] zeroMatrix = new int[1][n];
            CallerMultiple obj15 = new CallerMultiple(equation, "addMatrices", y2transp_mul_Y3pow_mul_y1_plus_y1transp, zeroMatrix);

            try {
                obj15.t.join();

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("y2' * Y3^2 * y1 + y1' = ");
            y2transp_mul_Y3pow_mul_y1_plus_y1transp = obj15.getResult();
            equation.printMatrix(y2transp_mul_Y3pow_mul_y1_plus_y1transp);

            CallerMultiple objLast = new CallerMultiple(equation, "multiplyMatrices", y2transp_mul_Y3pow_mul_y1_plus_y1transp, Y3_mul_y1_plus_y2);

            try {
                objLast.t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            int[][] finalX = objLast.getResult();
            System.out.println("(y2' * Y3^2 * y1 + y1') * (Y3 * y1 + y2`) = \t");
            equation.printMatrix(finalX);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
