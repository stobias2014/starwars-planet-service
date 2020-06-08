package com.tobias.saul.starwarsplanetservice.web.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarsplanetservice.model.Planet;
import com.tobias.saul.starwarsplanetservice.web.response.PlanetsResponse;
import com.tobias.saul.starwarsplanetservice.web.utils.StarWarsPlanetUtils;

@RestController
@RequestMapping("/planets")
public class PlanetService {
	
	private final String BASE_URL = "https://swapi.dev/api/planets/";
	private final RestTemplate restTemplate;
	
	public PlanetService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping
	public List<Planet> getAllPlanets() {
		ResponseEntity<PlanetsResponse> response = restTemplate.getForEntity(BASE_URL, PlanetsResponse.class);
		
		List<Planet> vehicles = StarWarsPlanetUtils.addPlanetsToList(restTemplate, response);
		
		return vehicles;
	}
	
	@GetMapping("/{planetId}")
	public Planet getStarWarsPlanet(@PathVariable("planetId") Integer planetId) {		
		ResponseEntity<PlanetsResponse> response = restTemplate.getForEntity(BASE_URL, PlanetsResponse.class);
		
		List<Planet> planets = StarWarsPlanetUtils.addPlanetsToList(restTemplate, response);
		
		Planet planet = planets.get(planetId - 1);
		
		return planet;
	}
	
}
