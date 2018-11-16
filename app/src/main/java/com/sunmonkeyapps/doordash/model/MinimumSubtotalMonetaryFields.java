package com.sunmonkeyapps.doordash.model;

import com.google.gson.annotations.SerializedName;

public class MinimumSubtotalMonetaryFields{

	@SerializedName("display_string")
	private String displayString;

	@SerializedName("currency")
	private String currency;

	@SerializedName("unit_amount")
	private Object unitAmount;

	@SerializedName("decimal_places")
	private int decimalPlaces;

	public void setDisplayString(String displayString){
		this.displayString = displayString;
	}

	public String getDisplayString(){
		return displayString;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setUnitAmount(Object unitAmount){
		this.unitAmount = unitAmount;
	}

	public Object getUnitAmount(){
		return unitAmount;
	}

	public void setDecimalPlaces(int decimalPlaces){
		this.decimalPlaces = decimalPlaces;
	}

	public int getDecimalPlaces(){
		return decimalPlaces;
	}

	@Override
 	public String toString(){
		return 
			"MinimumSubtotalMonetaryFields{" + 
			"display_string = '" + displayString + '\'' + 
			",currency = '" + currency + '\'' + 
			",unit_amount = '" + unitAmount + '\'' + 
			",decimal_places = '" + decimalPlaces + '\'' + 
			"}";
		}
}