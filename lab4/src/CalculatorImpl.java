import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {
        super();
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


}
