package pro.tyshchenko.oop.network.rmi.server;



import pro.tyshchenko.oop.network.rmi.common.Calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Alexander Tyshchenko.
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
    }

    public long add(long a, long b) throws RemoteException {
        System.out.println("calculated from some client a=" + a + " b=" + b);
        return a + b;
    }
}
