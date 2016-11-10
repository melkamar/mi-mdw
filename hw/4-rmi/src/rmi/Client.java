package rmi;

import util.CurrencyExchanger;

import java.rmi.Naming;
import java.util.Random;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 11.11.2016 0:10
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CurrencyConverter server = (CurrencyConverter) Naming.lookup("//localhost/converter");

        System.out.println("1 USD = " + server.convert(
                CurrencyExchanger.Currency.USD,
                CurrencyExchanger.Currency.USD,
                1d) + " USD");

        System.out.println("1 USD = " + server.convert(
                CurrencyExchanger.Currency.USD,
                CurrencyExchanger.Currency.EUR,
                1d) + " EUR");

        System.out.println("1 USD = " + server.convert(
                CurrencyExchanger.Currency.USD,
                CurrencyExchanger.Currency.GBP,
                1d) + " GBP");

        // XXX -> USD
        System.out.println("1 EUR = " + server.convert(
                CurrencyExchanger.Currency.EUR,
                CurrencyExchanger.Currency.USD,
                1d) + " USD");

        System.out.println("1 GBP = " + server.convert(
                CurrencyExchanger.Currency.GBP,
                CurrencyExchanger.Currency.USD,
                1d) + " USD");

        // Randoms
        System.out.println("Random conversions");

        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            CurrencyExchanger.Currency from = intToCur(rnd.nextInt());
            CurrencyExchanger.Currency to = intToCur(rnd.nextInt());

            int value = rnd.nextInt(100);

            System.out.println(value + " " + from + " == " + server.convert(from, to, value) + " " + to);
        }
    }

    protected static CurrencyExchanger.Currency intToCur(int val) {
        switch (val % 3) {
            case 0:
                return CurrencyExchanger.Currency.USD;
            case 1:
                return CurrencyExchanger.Currency.EUR;
            case 2:
                return CurrencyExchanger.Currency.GBP;
            default:
                return CurrencyExchanger.Currency.USD;
        }
    }
}
