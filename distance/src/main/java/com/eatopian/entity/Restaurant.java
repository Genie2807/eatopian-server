package com.eatopian.entity;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

public class Restaurant {

	private Address address;
	private String rName;
	private LatLng rLatLng;
	private GeoHash rGeoHash;
	private int precision;
	private double distance;
	private double lat;
	private double lng;

	public Restaurant(){
		
	}
	
	public Restaurant(String rName, Address address) {
		this.precision = 10;
		this.rName = rName;
		this.address = address;
		this.getLatLng();
		this.getGeoHash();
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		this.getLatLng();
		this.getGeoHash();
	}

	public GeoHash getrGeoHash() {
		return rGeoHash;
	}

	public LatLng getrLatLng() {
		return rLatLng;
	}

	private void getLatLng() {
		Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
				.setAddress(this.address.getFormattedAddress())
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		for (GeocoderResult gr : geocoderResponse.getResults()) {
			this.rLatLng = gr.getGeometry().getLocation();
			break;
		}
	}

	private void getGeoHash() {
		this.rGeoHash = GeoHash.withCharacterPrecision(this.rLatLng.getLat()
				.doubleValue(), this.rLatLng.getLng().doubleValue(), this.precision);
	}

	public double distanceFrom(LatLng otherLatLng) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(otherLatLng.getLat().doubleValue() - this.rLatLng.getLat().doubleValue());
		double dLng = Math.toRadians(otherLatLng.getLng().doubleValue() - this.rLatLng.getLng().doubleValue());
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
				* Math.cos(Math.toRadians(this.rLatLng.getLat().doubleValue()))
				* Math.cos(Math.toRadians(otherLatLng.getLat().doubleValue()));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;
		return dist;
	}

}
