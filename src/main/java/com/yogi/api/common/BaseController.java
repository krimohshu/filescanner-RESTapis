package com.yogi.api.common;

import org.springframework.web.client.RestTemplate;

/**
 * @author Krishan Shukla
 * Created by Krishan Shukla on 20/10/2017.
 */
public class BaseController {

    private RestTemplate restTemplate;

    public BaseController(){
        restTemplate = new RestTemplate();
    }


}
