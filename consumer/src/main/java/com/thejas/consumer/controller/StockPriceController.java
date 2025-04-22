package com.thejas.consumer.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thejas.consumer.dto.StockPrice;
import com.thejas.consumer.service.StockPriceConsumerService;

import java.util.Map;

@Controller
public class StockPriceController {

    @Autowired
    private StockPriceConsumerService consumerService;

    @GetMapping("/")
    public String displayStockPrices(Model model) {
        Map<String, StockPrice> latestPrices = consumerService.getLatestStockPrices();
        model.addAttribute("stockPrices", latestPrices);
        return "stock-prices"; // Name of the Thymeleaf template
    }
}