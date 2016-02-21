package com.strikr.storage;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.strikr.EuclideDistanceComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.strikr.LshUtils.generateUniFormPlanes;
import static com.strikr.LshUtils.hash;

public class InMemoryStorage implements Storage {
    Double[][] planes;
    Multimap<String, Double[]> store = ArrayListMultimap.create();

    public InMemoryStorage(int nrOfBits, int imageSize) {
        planes = generateUniFormPlanes(nrOfBits, imageSize);
    }


    @Override
    public void index(Double[] image) {
        String hash = hash(planes, image);
        store.put(hash, image);
    }

    @Override
    public List<Double[]> query(Double[] image, int numberOfResults) {
        String hash = hash(planes, image);
        ArrayList<Double[]> arrayList = new ArrayList<>(store.get(hash));
        return (List<Double[]>) arrayList.stream()
                .sorted(new EuclideDistanceComparator(image))
                .limit(numberOfResults)
                .collect(Collectors.toList());
    }
}
