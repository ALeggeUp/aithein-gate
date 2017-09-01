/*
 * Config.java
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.aleggeup.starter;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aleggeup.starter.ethereum.EthereumBean;

@Configuration
public class Config {

    @Bean
    EthereumBean ethereumBean() throws Exception {
        final EthereumBean ethereumBean = new EthereumBean();
        Executors.newSingleThreadExecutor().submit(ethereumBean::start);

        return ethereumBean;
    }
}
