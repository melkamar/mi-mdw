package com.melkamar.mdw;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 09.11.2016 22:35
 *
 * Taken from http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string.
 */
import java.security.SecureRandom;
import java.math.BigInteger;

public final class SessionIdentifierGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}
