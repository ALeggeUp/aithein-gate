/*
 * EthereumBean.java
 *
 * Copyright (C) 2017 [ A Legge Up ]
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.aleggeup.starter.ethereum;

import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;

public class EthereumBean {

    private Ethereum ethereum;

    public void start(){
        this.ethereum = EthereumFactory.createEthereum();
        this.ethereum.addListener(new EthereumListener(ethereum));
    }

    public String getBestBlock(){
        return String.valueOf(ethereum.getBlockchain().getBestBlock().getNumber());
    }
}