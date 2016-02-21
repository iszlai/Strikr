package com.strikr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestLshUtils {

    @Test
    public void testEuclideanDistance() {
        Double[] p = {3.0, 3.0, 3.0, 3.0};
        Double[] q = {1.0, 1.0, 1.0, 1.0};
        final Double distance = LshUtils.getDistance(p, q);
        assertEquals(4, distance, 0);
    }

    @Test
    public void testDotProduct() {
        Double[] p = {1.0, 3.0, -5.0};
        Double[] q = {4.0, -2.0, -1.0};
        double dot = LshUtils.dotProduct(p, q);
        assertEquals(3.0, dot, 0);
    }

    @Test
    public void testDot() {
        Double[][] ps = {{1.0, 3.0, -5.0}, {1.0, 3.0, -5.0}, {1.0, 3.0, -5.0}};
        Double[] q = {4.0, -2.0, -1.0};

        Double[] dot = LshUtils.dot(ps, q);
        for (Double aDot : dot) {
            assertEquals(3.0, aDot, 0);
        }

    }

    @Test
    public void testHash() {
        Double[][] ps = {{1.0, 3.0, -5.0}, {1.0, 3.0, -5.0}, {1.0, 3.0, -5.0}};
        Double[] q = {4.0, -2.0, -1.0};
        assertEquals("111", LshUtils.hash(ps, q));
    }

    @Test
    public void testPlanes() {
        final int NR_BITS = 30;
        Double[][] planes = LshUtils.generateUniFormPlanes(NR_BITS, 4);
        Double[] img = {1.0, 2.0, 3.0, 4.0};
        assertEquals(NR_BITS, LshUtils.hash(planes, img).length());


    }

}
