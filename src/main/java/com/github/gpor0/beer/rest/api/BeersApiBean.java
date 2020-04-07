package com.github.gpor0.rest.api;

import com.github.gpor0.beer.rest.api.BeersApi;
import com.github.gpor0.beer.rest.api.model.Beer;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RequestScoped
public class BeersApiBean implements BeersApi {

    private static final Map<String, Beer> BEERS = new ConcurrentHashMap<>();

    static {
        Beer beer = new Beer();
        beer.setName("Corona Beer");
        beer.setAlcohol("5.3");
        beer.setCompany("Corona");
        beer.setPrice(new BigDecimal("2.5"));
        BEERS.put(beer.getName(), beer);

        beer = new Beer();
        beer.setName("Kozel Dark");
        beer.setAlcohol("4.6");
        beer.setCompany("Kozel");
        beer.setPrice(new BigDecimal("1.5"));
        BEERS.put(beer.getName(), beer);

        beer = new Beer();
        beer.setName("Kozel Light");
        beer.setAlcohol("4.6");
        beer.setCompany("Kozel");
        beer.setPrice(new BigDecimal("1.5"));
        BEERS.put(beer.getName(), beer);

        beer = new Beer();
        beer.setName("Heiniken alcohol frei");
        beer.setAlcohol("0.0");
        beer.setCompany("Heiniken");
        beer.setPrice(new BigDecimal("1.12"));
        BEERS.put(beer.getName(), beer);
    }

    @Override
    public Response getBeers(String company) {

        if ("-1".equals(company)) {
            return Response.serverError().build();
        }

        List<Beer> beers =
                BEERS.values().stream().filter(b -> b.getCompany().equals(company)).collect(Collectors.toList());

        return Response.ok(beers).build();
    }

}
