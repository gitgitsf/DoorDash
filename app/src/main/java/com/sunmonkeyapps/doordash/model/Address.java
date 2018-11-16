package com.sunmonkeyapps.doordash.model;

import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("printable_address")
	private String printableAddress;

	@SerializedName("lng")
	private double lng;

	@SerializedName("city")
	private String city;

	@SerializedName("street")
	private String street;

	@SerializedName("state")
	private String state;

	@SerializedName("lat")
	private double lat;

	public void setPrintableAddress(String printableAddress){
		this.printableAddress = printableAddress;
	}

	public String getPrintableAddress(){
		return printableAddress;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"printable_address = '" + printableAddress + '\'' + 
			",lng = '" + lng + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",state = '" + state + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}