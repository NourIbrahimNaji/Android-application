package com.example.finalproject_1190270_1190768;

public class Destination {
    private Integer destination_id;
    private String city;
    private String country;
    private String continent;
    private Double longitude;
    private Double latitude;
    private Integer cost;
    private String image;
    private String description;

    // constructors
    public Destination() {

    }

    public Destination(String city, String country, String continent, Double longitude, Double latitude, Integer cost, String image, String description) {
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.longitude = longitude;
        this.latitude = latitude;
        this.cost = cost;
        this.image = image;
        this.description = description;
    }

    // setters and getters


    public Integer getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(Integer destination_id) {
        this.destination_id = destination_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destination_id=" + destination_id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", cost=" + cost +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
