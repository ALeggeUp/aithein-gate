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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleggeup.starter.ethereum.EthereumBean;

@RestController
public class MyRestController {

    private final EthereumBean ethereumBean;

    @Autowired
    public MyRestController(final EthereumBean ethereumBean) {
        this.ethereumBean = ethereumBean;
    }

    @RequestMapping(value = "/bestBlock", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getBestBlock() throws IOException {
        return ethereumBean.getBestBlock();
    }
}