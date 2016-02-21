package com.strikr.storage;


import java.util.List;

public interface Storage {
    void index(Double[] image);

    List<Double[]> query(Double[] image, int numberOfResults);
}
