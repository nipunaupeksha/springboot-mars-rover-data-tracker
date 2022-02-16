package com.flt.marsrover.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MarsRover {

    private Long id;
    private String name;
    @JsonProperty("landing_date")
    private String landingDate;
    @JsonProperty("launch_date")
    private String launchDate;

    public MarsRover() {

    }

    public MarsRover(Long id, String name, String landingDate, String launchDate) {

        this.id = id;
        this.name = name;
        this.landingDate = landingDate;
        this.launchDate = launchDate;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLandingDate() {

        return landingDate;
    }

    public void setLandingDate(String landingDate) {

        this.landingDate = landingDate;
    }

    public String getLaunchDate() {

        return launchDate;
    }

    public void setLaunchDate(String launchDate) {

        this.launchDate = launchDate;
    }
}
