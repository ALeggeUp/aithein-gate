/*
 * Config.java
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.aleggeup.aithein.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.infura.InfuraHttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.protocol.ipc.WindowsIpcService;
import org.web3j.protocol.parity.Parity;

@Configuration
@ConditionalOnClass(Web3j.class)
@EnableConfigurationProperties(Web3jProperties.class)
public class Config {

    private static final Log LOG = LogFactory.getLog(Config.class);

    @Autowired
    private Web3jProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Web3j web3j() {
        final Web3jService web3jService = buildService(properties.getClientAddress());
        LOG.info("Building service for endpoint: " + properties.getClientAddress());

        return Web3j.build(web3jService);
    }

    @Bean
    @ConditionalOnProperty(prefix = Web3jProperties.WEB3J_PREFIX, name = "admin-client", havingValue = "true")
    public Parity parity() {
        final Web3jService web3jService = buildService(properties.getClientAddress());
        LOG.info("Building admin service for endpoint: " + properties.getClientAddress());

        return Parity.build(web3jService);
    }

    private Web3jService buildService(final String clientAddress) {
        Web3jService web3jService;

        if (clientAddress == null || clientAddress.equals("")) {
            web3jService = new HttpService();
        } else if (clientAddress.contains("infura.io")) {
            web3jService = new InfuraHttpService(clientAddress);
        } else if (clientAddress.startsWith("http")) {
            web3jService = new HttpService(clientAddress);
        } else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            web3jService = new WindowsIpcService(clientAddress);
        } else {
            web3jService = new UnixIpcService(clientAddress);
        }

        return web3jService;
    }
}
