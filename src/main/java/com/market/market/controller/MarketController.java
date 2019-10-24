package com.market.market.controller;

import com.market.market.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController {

    private static final String DATA_NOT_FOUND = "Data not found";

    @Autowired
    private MarketService marketService;

    @RequestMapping(
            value = "/api/markets",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMarkets() {
        List markets = marketService.getAllMarkets();
        if(markets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(DATA_NOT_FOUND);
        }
        return ResponseEntity.ok(markets);
    }
}
