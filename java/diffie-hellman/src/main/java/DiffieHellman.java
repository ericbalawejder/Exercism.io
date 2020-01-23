import java.math.BigInteger;
import java.security.SecureRandom;

class DiffieHellman {

    BigInteger privateKey(BigInteger prime) {
        return getRandomBigInteger(BigInteger.ONE, prime);
    }

    BigInteger publicKey(BigInteger primeA, BigInteger primeB, BigInteger privateKey) {
        return primeB.modPow(privateKey, primeA);
    }

    BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.modPow(privateKey, prime);
    }

    // range = [ lowerLimit, upperLimit )
    private BigInteger getRandomBigInteger(BigInteger lowerLimit, BigInteger upperLimit) {
        final SecureRandom secureRandom = new SecureRandom(); //NativePRNG
        BigInteger randomNumber;
        do {
            randomNumber = new BigInteger(upperLimit.bitLength(), secureRandom);
        } while(randomNumber.compareTo(upperLimit) >= 0 || randomNumber.compareTo(lowerLimit) < 0);
        return randomNumber;
    }

}