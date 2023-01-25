package pro.tyshchenko.oop.network.rmi.client;


import pro.tyshchenko.oop.network.rmi.common.Calculator;
import pro.tyshchenko.oop.network.rmi.common.RMIConstants;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Alexander Tyshchenko.
 */
public class ClientCalculator {

    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("", RMIConstants.RMI_PORT);
        Calculator calculator = (Calculator) registry.lookup(RMIConstants.RMI_SERVICE);
        System.out.println(calculator.add(1, 2));
    }

}
