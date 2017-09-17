/*
 * Web3jProperties.java
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.aleggeup.aithein.config;

import static com.aleggeup.aithein.config.Web3jProperties.WEB3J_PREFIX;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = WEB3J_PREFIX)
public class Web3jProperties {

    protected static final String WEB3J_PREFIX = "web3j";

    private String clientAddress;

    private Boolean adminClient;

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(final String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Boolean getAdminClient() {
        return adminClient;
    }

    public void setAdminClient(final Boolean adminClient) {
        this.adminClient = adminClient;
    }
}
