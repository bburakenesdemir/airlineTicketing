package com.airline.ticketing.ticketer.util;

import com.airline.ticketing.ticketer.data.Flight;
import com.airline.ticketing.ticketer.resource.PriceResource;

import java.text.DecimalFormat;

public class PriceUtil {

    public static PriceResource calculateCurrentPrice(Flight flight, Integer ticketCount) {
        int hundred = 100;
        int capacity = flight.getCapacity() * hundred;
        Double basePrice = flight.getBasePrice();
        Double currentPrice = basePrice;
        int percentage = (hundred * hundred * ticketCount) / capacity;
        int percentageRounded = percentage - (percentage % 10);
        for (int i = 0; i < percentageRounded / 10; i++) {
            currentPrice *= 1.1;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        PriceResource resource = new PriceResource();
        resource.setBasePrice(basePrice);
        resource.setCurrentPrice(Double.valueOf(df.format(currentPrice)));
        resource.setTotalCapacity(capacity / hundred);
        resource.setCurrentCapacity(ticketCount);

        return resource;
    }
}
