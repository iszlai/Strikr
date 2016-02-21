package com.strikr;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TestEuclideDistance {

    @Test
    public void testComparator() {
        Double[] src = {3.0, 3.0, 3.0, 3.0};
        Double[] im1 = {1.0, 1.0, 1.0, 1.0};
        Double[] im2 = {0.0, 0.0, 0.0, 0.0};

        List<Double[]> doubles = Arrays.asList(im1, im2);
        doubles.sort(new EuclideDistanceComparator(src));
        assertArrayEquals(im1, doubles.get(0));
        assertArrayEquals(im2, doubles.get(1));
    }

}
