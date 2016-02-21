package com.strikr;

import com.strikr.storage.InMemoryStorage;
import com.strikr.storage.Storage;
import org.junit.Test;

import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.toPrimitive;
import static org.junit.Assert.assertArrayEquals;

public class TestInMemoryStorage {

    private static final int NR_BITS = 3;
    private static final int IMG_LEN = 4;

    @Test
    public void testStorage() {
        Storage store = new InMemoryStorage(NR_BITS, IMG_LEN);
        Double[] img = {1.0, 2.0, 3.0, 4.0};
        store.index(img);
        List<Double[]> queryResult = store.query(img, 1);
        double[] src = toPrimitive(img);
        double[] target = toPrimitive(queryResult.get(0));
        assertArrayEquals(src, target, 0.0);

    }

}
