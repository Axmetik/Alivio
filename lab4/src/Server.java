import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException,
            AlreadyBoundException {
        System.out.println("Запуск сервера на порті 3000");
        LocateRegistry.createRegistry(3000);
        Calculator calculator = new CalculatorImpl();
        try {
            Naming.bind("//localhost:3000/Calculation", calculator);
            System.out.println("Success connected");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Успішне підключення до 3000 порту");
    }
}
