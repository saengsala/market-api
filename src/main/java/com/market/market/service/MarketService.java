package com.market.market.service;

import com.market.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public List getAllMarkets() {
        List markets = new ArrayList(marketRepository.findAll());
        return markets;
    }
}
