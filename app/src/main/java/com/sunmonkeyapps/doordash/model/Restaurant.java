package com.sunmonkeyapps.doordash.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Restaurant{

	@SerializedName("phone_number")
	private Object phoneNumber;

	@SerializedName("max_order_size")
	private Object maxOrderSize;

	@SerializedName("is_time_surging")
	private boolean isTimeSurging;

	@SerializedName("status_type")
	private String statusType;

	@SerializedName("merchant_promotions")
	private List<MerchantPromotionsItem> merchantPromotions;

	@SerializedName("yelp_review_count")
	private int yelpReviewCount;

	@SerializedName("description")
	private String description;

	@SerializedName("price_range")
	private int priceRange;

	@SerializedName("asap_time")
	private Object asapTime;

	@SerializedName("cover_img_url")
	private String coverImgUrl;

	@SerializedName("delivery_fee")
	private int deliveryFee;

	@SerializedName("featured_category_description")
	private Object featuredCategoryDescription;

	@SerializedName("yelp_rating")
	private double yelpRating;
//	private int yelpRating;s

	@SerializedName("is_newly_added")
	private boolean isNewlyAdded;

	@SerializedName("id")
	private int id;

	@SerializedName("menus")
	private List<MenusItem> menus;

	@SerializedName("slug")
	private String slug;

	@SerializedName("service_rate")
	private int serviceRate;

	@SerializedName("address")
	private Address address;

	@SerializedName("business")
	private Business business;

	@SerializedName("composite_score")
	private int compositeScore;

	@SerializedName("average_rating")
	private double averageRating;

	@SerializedName("is_only_catering")
	private boolean isOnlyCatering;

	@SerializedName("url")
	private String url;

	@SerializedName("max_composite_score")
	private int maxCompositeScore;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("number_of_ratings")
	private int numberOfRatings;

	@SerializedName("name")
	private String name;

	@SerializedName("header_img_url")
	private String headerImgUrl;

	@SerializedName("business_id")
	private int businessId;

	@SerializedName("extra_sos_delivery_fee")
	private int extraSosDeliveryFee;

	@SerializedName("status")
	private String status;

	@SerializedName("promotion")
	private Object promotion;

	public void setPhoneNumber(Object phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public Object getPhoneNumber(){
		return phoneNumber;
	}



	public void setMaxOrderSize(Object maxOrderSize){
		this.maxOrderSize = maxOrderSize;
	}

	public Object getMaxOrderSize(){
		return maxOrderSize;
	}

	public void setIsTimeSurging(boolean isTimeSurging){
		this.isTimeSurging = isTimeSurging;
	}

	public boolean isIsTimeSurging(){
		return isTimeSurging;
	}

	public void setStatusType(String statusType){
		this.statusType = statusType;
	}

	public String getStatusType(){
		return statusType;
	}

	public void setMerchantPromotions(List<MerchantPromotionsItem> merchantPromotions){
		this.merchantPromotions = merchantPromotions;
	}

	public List<MerchantPromotionsItem> getMerchantPromotions(){
		return merchantPromotions;
	}

	public void setYelpReviewCount(int yelpReviewCount){
		this.yelpReviewCount = yelpReviewCount;
	}

	public int getYelpReviewCount(){
		return yelpReviewCount;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPriceRange(int priceRange){
		this.priceRange = priceRange;
	}

	public int getPriceRange(){
		return priceRange;
	}

	public void setAsapTime(Object asapTime){
		this.asapTime = asapTime;
	}

	public Object getAsapTime(){
		return asapTime;
	}

	public void setCoverImgUrl(String coverImgUrl){
		this.coverImgUrl = coverImgUrl;
	}

	public String getCoverImgUrl(){
		return coverImgUrl;
	}

	public void setDeliveryFee(int deliveryFee){
		this.deliveryFee = deliveryFee;
	}

	public int getDeliveryFee(){
		return deliveryFee;
	}

	public void setFeaturedCategoryDescription(Object featuredCategoryDescription){
		this.featuredCategoryDescription = featuredCategoryDescription;
	}

	public Object getFeaturedCategoryDescription(){
		return featuredCategoryDescription;
	}

	public void setYelpRating(double yelpRating){
		this.yelpRating = yelpRating;
	}

	public double getYelpRating(){
		return yelpRating;
	}

	public void setIsNewlyAdded(boolean isNewlyAdded){
		this.isNewlyAdded = isNewlyAdded;
	}

	public boolean isIsNewlyAdded(){
		return isNewlyAdded;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMenus(List<MenusItem> menus){
		this.menus = menus;
	}

	public List<MenusItem> getMenus(){
		return menus;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setServiceRate(int serviceRate){
		this.serviceRate = serviceRate;
	}

	public int getServiceRate(){
		return serviceRate;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setBusiness(Business business){
		this.business = business;
	}

	public Business getBusiness(){
		return business;
	}

	public void setCompositeScore(int compositeScore){
		this.compositeScore = compositeScore;
	}

	public int getCompositeScore(){
		return compositeScore;
	}

	public void setAverageRating(double averageRating){
		this.averageRating = averageRating;
	}

	public double getAverageRating(){
		return averageRating;
	}

	public void setIsOnlyCatering(boolean isOnlyCatering){
		this.isOnlyCatering = isOnlyCatering;
	}

	public boolean isIsOnlyCatering(){
		return isOnlyCatering;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setMaxCompositeScore(int maxCompositeScore){
		this.maxCompositeScore = maxCompositeScore;
	}

	public int getMaxCompositeScore(){
		return maxCompositeScore;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setNumberOfRatings(int numberOfRatings){
		this.numberOfRatings = numberOfRatings;
	}

	public int getNumberOfRatings(){
		return numberOfRatings;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHeaderImgUrl(String headerImgUrl){
		this.headerImgUrl = headerImgUrl;
	}

	public String getHeaderImgUrl(){
		return headerImgUrl;
	}

	public void setBusinessId(int businessId){
		this.businessId = businessId;
	}

	public int getBusinessId(){
		return businessId;
	}

	public void setExtraSosDeliveryFee(int extraSosDeliveryFee){
		this.extraSosDeliveryFee = extraSosDeliveryFee;
	}

	public int getExtraSosDeliveryFee(){
		return extraSosDeliveryFee;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setPromotion(Object promotion){
		this.promotion = promotion;
	}

	public Object getPromotion(){
		return promotion;
	}

	@Override
 	public String toString(){
		return 
			"Restaurant{" +
					"phone_number = '" + phoneNumber + '\'' +
					"max_order_size = '" + maxOrderSize + '\'' +
			",is_time_surging = '" + isTimeSurging + '\'' + 
			",status_type = '" + statusType + '\'' + 
			",merchant_promotions = '" + merchantPromotions + '\'' + 
			",yelp_review_count = '" + yelpReviewCount + '\'' + 
			",description = '" + description + '\'' + 
			",price_range = '" + priceRange + '\'' + 
			",asap_time = '" + asapTime + '\'' + 
			",cover_img_url = '" + coverImgUrl + '\'' + 
			",delivery_fee = '" + deliveryFee + '\'' + 
			",featured_category_description = '" + featuredCategoryDescription + '\'' + 
			",yelp_rating = '" + yelpRating + '\'' + 
			",is_newly_added = '" + isNewlyAdded + '\'' + 
			",id = '" + id + '\'' + 
			",menus = '" + menus + '\'' + 
			",slug = '" + slug + '\'' + 
			",service_rate = '" + serviceRate + '\'' + 
			",address = '" + address + '\'' + 
			",business = '" + business + '\'' + 
			",composite_score = '" + compositeScore + '\'' + 
			",average_rating = '" + averageRating + '\'' + 
			",is_only_catering = '" + isOnlyCatering + '\'' + 
			",url = '" + url + '\'' + 
			",max_composite_score = '" + maxCompositeScore + '\'' + 
			",tags = '" + tags + '\'' + 
			",number_of_ratings = '" + numberOfRatings + '\'' + 
			",name = '" + name + '\'' + 
			",header_img_url = '" + headerImgUrl + '\'' + 
			",business_id = '" + businessId + '\'' + 
			",extra_sos_delivery_fee = '" + extraSosDeliveryFee + '\'' + 
			",status = '" + status + '\'' + 
			",promotion = '" + promotion + '\'' + 
			"}";
		}
}