package com.strikr;

import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Arrays;
import java.util.stream.IntStream;


public class LshUtils {

    public static Double getDistance(Double[] p, Double[] q) {
        Validate.isTrue(p.length == q.length);
        double sum = IntStream.range(0, p.length)
                .mapToDouble(i -> p[i] - q[i])
                .map(i -> i * i)
                .sum();
        return Math.sqrt(sum);
    }

    public static Double dotProduct(Double[] p, Double[] q) {
        Validate.isTrue(p.length == q.length);
        return IntStream.range(0, p.length)
                .mapToDouble(i -> p[i] * q[i])
                .sum();
    }

    public static Double[] dot(Double[][] table, Double[] q) {
        Double[] d = new Double[table.length];

        for (int i = 0; i < table.length; i++) {
            d[i] = dotProduct(table[i], q);
        }
        return d;
    }


    public static Double[][] generateUniFormPlanes(int rows, int columns) {
        NormalDistribution nd = new NormalDistribution();
        Double[][] result = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = nd.sample();
            }
        }
        return result;

    }

    public static String hash(Double[][] planes, Double[] image) {
        return Arrays.stream(dot(planes, image)).map(LshUtils::decideBit).reduce("", (a, b) -> a + b);
    }

    private static String decideBit(Double number) {
        return number > 0 ? "1" : "0";
    }

}

