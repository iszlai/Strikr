package com.strikr.rest;

import com.strikr.storage.InMemoryStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Lehel on 2/22/2016.
 */

@SpringBootApplication
public class RunServer {

    @Value("${com.strikr.nrOfBits}")
    public int NR_OF_BITS;

    @Value("${com.strikr.imgSize}")
    public int IMG_SIZE;


    @Bean
    public InMemoryStorage storage(){
        return new InMemoryStorage(NR_OF_BITS,IMG_SIZE);
    }

public static void main (String[] args){
    SpringApplication.run(RunServer.class);
}

}
