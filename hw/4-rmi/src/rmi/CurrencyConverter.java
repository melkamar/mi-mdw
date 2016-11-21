package rmi;

import util.CurrencyExchanger;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 10.11.2016 23:59
 */
public interface CurrencyConverter extends Remote {
    public double convert(CurrencyExchanger.Currency from,
                          CurrencyExchanger.Currency to,
                          double amount) throws RemoteException;
}
