package rmi;

import util.CurrencyExchanger;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 11.11.2016 0:07
 */
public class CurrencyConverterServer extends UnicastRemoteObject implements CurrencyConverter {
    private static final long serialVersionUID = 1L;

    protected CurrencyConverterServer() throws RemoteException {
        super();
    }

    @Override
    public double convert(CurrencyExchanger.Currency from, CurrencyExchanger.Currency to, double amount) {
        return CurrencyExchanger.convert(from, to, amount);
    }

    public static void main(String [] args){
        try {
            LocateRegistry.createRegistry(1099);

            CurrencyConverterServer server = new CurrencyConverterServer();
            Naming.rebind("//0.0.0.0/converter", server);

            System.out.println("Server started...");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
