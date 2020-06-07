package com.tobias.saul.starwarsplanetservice.web.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobias.saul.starwarsplanetservice.model.Planet;

public class PlanetsResponse {
	
	private String next;
	@JsonProperty("results")
	private List<Planet> planets;
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((planets == null) ? 0 : planets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetsResponse other = (PlanetsResponse) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (planets == null) {
			if (other.planets != null)
				return false;
		} else if (!planets.equals(other.planets))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PlanetsResponse [next=" + next + ", planets=" + planets + "]";
	}
	
	

}
