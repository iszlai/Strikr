package com.strikr;

import java.util.Comparator;

public class EuclideDistanceComparator implements Comparator<Double[]> {
    private final Double[] src;

    public EuclideDistanceComparator(Double[] src) {
        this.src = src;
    }

    @Override
    public int compare(Double[] o1, Double[] o2) {
        return (int) (LshUtils.getDistance(src, o1) - LshUtils.getDistance(src, o2));
    }
}
