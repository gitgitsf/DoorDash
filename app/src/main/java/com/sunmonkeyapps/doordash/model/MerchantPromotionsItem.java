package com.sunmonkeyapps.doordash.model;

import com.google.gson.annotations.SerializedName;

public class MerchantPromotionsItem{

	@SerializedName("delivery_fee")
	private Object deliveryFee;

	@SerializedName("delivery_fee_monetary_fields")
	private DeliveryFeeMonetaryFields deliveryFeeMonetaryFields;

	@SerializedName("new_store_customers_only")
	private boolean newStoreCustomersOnly;

	@SerializedName("minimum_subtotal_monetary_fields")
	private MinimumSubtotalMonetaryFields minimumSubtotalMonetaryFields;

	@SerializedName("id")
	private int id;

	@SerializedName("minimum_subtotal")
	private Object minimumSubtotal;

	public void setDeliveryFee(Object deliveryFee){
		this.deliveryFee = deliveryFee;
	}

	public Object getDeliveryFee(){
		return deliveryFee;
	}

	public void setDeliveryFeeMonetaryFields(DeliveryFeeMonetaryFields deliveryFeeMonetaryFields){
		this.deliveryFeeMonetaryFields = deliveryFeeMonetaryFields;
	}

	public DeliveryFeeMonetaryFields getDeliveryFeeMonetaryFields(){
		return deliveryFeeMonetaryFields;
	}

	public void setNewStoreCustomersOnly(boolean newStoreCustomersOnly){
		this.newStoreCustomersOnly = newStoreCustomersOnly;
	}

	public boolean isNewStoreCustomersOnly(){
		return newStoreCustomersOnly;
	}

	public void setMinimumSubtotalMonetaryFields(MinimumSubtotalMonetaryFields minimumSubtotalMonetaryFields){
		this.minimumSubtotalMonetaryFields = minimumSubtotalMonetaryFields;
	}

	public MinimumSubtotalMonetaryFields getMinimumSubtotalMonetaryFields(){
		return minimumSubtotalMonetaryFields;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMinimumSubtotal(Object minimumSubtotal){
		this.minimumSubtotal = minimumSubtotal;
	}

	public Object getMinimumSubtotal(){
		return minimumSubtotal;
	}

	@Override
 	public String toString(){
		return 
			"MerchantPromotionsItem{" + 
			"delivery_fee = '" + deliveryFee + '\'' + 
			",delivery_fee_monetary_fields = '" + deliveryFeeMonetaryFields + '\'' + 
			",new_store_customers_only = '" + newStoreCustomersOnly + '\'' + 
			",minimum_subtotal_monetary_fields = '" + minimumSubtotalMonetaryFields + '\'' + 
			",id = '" + id + '\'' + 
			",minimum_subtotal = '" + minimumSubtotal + '\'' + 
			"}";
		}
}