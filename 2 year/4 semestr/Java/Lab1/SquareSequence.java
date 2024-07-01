package Lab1;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private BigInteger[] numbers;
    private long index;

    SquareSequence(BigInteger[] numbers) {
        this.numbers = numbers;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        boolean isNext = (numbers.length > 0 && index < numbers.length);
        return isNext;
    }

    @Override
    public BigInteger next() {
        BigInteger number = numbers[(int)(index+1)];
        return number;
    }
}
