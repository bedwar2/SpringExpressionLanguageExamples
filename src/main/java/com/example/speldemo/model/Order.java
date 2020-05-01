package com.example.speldemo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("order")
@Data
public class Order {



    @Value("#{100.55 + 500.75 + 400.66}")
    private double amount;
    @Value("#{order.amount >= 1000 ? order.amount * 5 / 100 : 0}")
    private double discount;

    @Value("#{user.country == 'US' and user.timeZone == 'America/New_York' ? 3 : 14}")
    private int daysToDeliver;

    @Value("#{user.country}")
    private String origin;

    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
    private String formattedAmount;

    @Value("#{shipping.locationsByCountry[user.country]}")
    private List<City> shippingLocations;

    @Value("#{order.shippingLocations.?[isCapital != true]}")
    private List<City> nonCapitalShippingLocations;

    @Value("#{(shipping.locationsByCountry.?[key == 'UK' or key =='US'])}")
    private Map<String, List<City>> westernShippingLocations;

    @Value("#{order.shippingLocations.?[shipping < 10.6].size()}")
    private Integer noOfCheapShippingLocations;

    @Value("#{user.name} your order total is #{order.formattedAmount} and the payable amount with 5% discount is #{order.amount - order.discount}")
    private String orderSummary;


    /*
    public String getNoOfCheapShippingLocationsString() {
        int cheapLocations = 5;
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1  = parser.parseExpression("Number of cheap locations is: #{user.name}", new TemplateParserContext());
        String expressionText = (String) exp1.getValue();
        return expressionText;
    }
    */

}
