package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 11.11.2016 0:00
 */
public class CurrencyExchanger {
    protected static Map<Currency, Double> coefficients = new HashMap<>();

    static {
        coefficients.put(Currency.USD, 1d);
        coefficients.put(Currency.EUR, 0.91829051);
        coefficients.put(Currency.GBP, 0.796305144);
    }

    public static double convert(Currency from, Currency to, double amount) {
        System.out.println(coefficients.size());
        double usd = amount * (1 / coefficients.get(from));
        return usd * coefficients.get(to);
    }

    public enum Currency {
        EUR, USD, GBP
    }
}


