package cl.ucn.disc.as.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RutGenerator {

    private final Random random = new Random();

    public List<String> generateRuts(int numberOfRuts, int minValue, int maxValue) {
        List<String> ruts = new ArrayList<>();
        while (ruts.size() < numberOfRuts) {
            int number = getRandomNumber(minValue, maxValue);
            if (!ruts.contains(number)) {
                String dv = calculateDV(number);
                ruts.add(number + "-" + dv);
            }
        }
        return ruts;
    }

    private int getRandomNumber(int minValue, int maxValue) {
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    private String calculateDV(int number) {
        int m = 0, s = 1;
        for (; number != 0; number /= 10) {
            s = (s + number % 10 * (9 - m++ % 6)) % 11;
        }
        return (s > 0) ? String.valueOf(s - 1) : "K";
    }

}