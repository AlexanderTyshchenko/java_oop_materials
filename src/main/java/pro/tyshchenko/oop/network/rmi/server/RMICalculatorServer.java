package pro.tyshchenko.oop.network.rmi.server;



import pro.tyshchenko.oop.network.rmi.common.RMIConstants;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Alexander Tyshchenko.
 */
public class RMICalculatorServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        CalculatorImpl calculator = new CalculatorImpl();

        Registry registry = LocateRegistry.createRegistry(RMIConstants.RMI_PORT);
        registry.bind(RMIConstants.RMI_SERVICE, calculator);

        System.out.println("Server started");
    }


}
