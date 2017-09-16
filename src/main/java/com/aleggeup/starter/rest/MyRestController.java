/*
 * MyRestController.java
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.aleggeup.starter.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleggeup.starter.service.Web3jInfoService;

@RestController
public class MyRestController {

    private static Log LOG = LogFactory.getLog(MyRestController.class);

    private final Web3jInfoService web3jInfoService;

    @Autowired
    public MyRestController(final Web3jInfoService web3jInfoService) {
        LOG.info("Initializing REST Controller");
        this.web3jInfoService = web3jInfoService;
    }

    @RequestMapping(value = "/clientVersion", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String clientVersion() throws IOException {
        return "Client version " + web3jInfoService.getClientVersion();
    }
}