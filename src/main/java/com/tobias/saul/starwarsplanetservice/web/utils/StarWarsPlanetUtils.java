package com.tobias.saul.starwarsplanetservice.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarsplanetservice.model.Planet;
import com.tobias.saul.starwarsplanetservice.web.response.PlanetsResponse;

public class StarWarsPlanetUtils {
	
	public static String formatUrlToContainHttps(String url) {
		StringBuilder str = new StringBuilder(url);
		str.insert(4, 's');
		return str.toString();
	}

	public static List<Planet> addPlanetsToList(RestTemplate restTemplate, ResponseEntity<PlanetsResponse> response) {
		List<Planet> planets = new ArrayList<Planet>();
		planets.addAll(response.getBody().getPlanets());

		while (response.getBody().getNext() != null) {
			if (response.getBody().getNext() == null) {
				continue;
			} else {
				String urlFormattedToHttps = StarWarsPlanetUtils
						.formatUrlToContainHttps(response.getBody().getNext());
				response = restTemplate.getForEntity(urlFormattedToHttps, PlanetsResponse.class);
				planets.addAll(response.getBody().getPlanets());
			}
		}

		return planets;
	}

}
