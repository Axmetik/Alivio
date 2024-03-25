import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    public int[][] multiplyMatrixByVector(int[][] matrix, int[][] vector) throws RemoteException;
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    public int[][] multiplyMatrixByScalar(int[][] matrix, int scalar) throws RemoteException;
    public int[][] addScalarToMatrix(int[][] matrix, int[][] scalar) throws RemoteException;
    public int[][] subtractVectorFromMatrix(int[][] matrix, int[][] vector) throws RemoteException;
    public int[][] transposeVector(int[][] vector) throws RemoteException;
    public int[][] powerMatrix(int[][] matrix) throws RemoteException;
}
