package com.strikr.rest.endpoint;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.strikr.storage.Storage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class QueryService {

    @Resource
    private Storage storage;

    @RequestMapping(method = RequestMethod.GET, path = "/greet")
    public String test() {
        return "Hi";
    }

}
