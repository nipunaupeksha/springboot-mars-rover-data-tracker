package com.flt.marsrover.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class HomeDto {

    /*@RequestParam(required = false)
    String marsApiRoverData,
    @RequestParam(required = false)
    Integer marsSol,
    @RequestParam(required = false)
    Boolean defaultCheck1*/
    private String marsApiRoverData;
    private Integer marsSol;
    private Boolean cameraFhaz;
    private Boolean cameraMast;
    private Boolean cameraRhaz;
    private Boolean cameraChemcam;
    private Boolean cameraMahli;
    private Boolean cameraMardi;
    private Boolean cameraNavcam;
    private Boolean cameraPancam;
    private Boolean cameraMinites;



    public String getMarsApiRoverData() {

        return marsApiRoverData;
    }

    public void setMarsApiRoverData(String marsApiRoverData) {

        this.marsApiRoverData = marsApiRoverData;
    }

    public Integer getMarsSol() {

        return marsSol;
    }

    public void setMarsSol(Integer marsSol) {

        this.marsSol = marsSol;
    }

    public Boolean getCameraFhaz() {

        return cameraFhaz;
    }

    public void setCameraFhaz(Boolean cameraFhaz) {

        this.cameraFhaz = cameraFhaz;
    }

    public Boolean getCameraMast() {

        return cameraMast;
    }

    public void setCameraMast(Boolean cameraMast) {

        this.cameraMast = cameraMast;
    }

    public Boolean getCameraRhaz() {

        return cameraRhaz;
    }

    public void setCameraRhaz(Boolean cameraRhaz) {

        this.cameraRhaz = cameraRhaz;
    }

    public Boolean getCameraChemcam() {

        return cameraChemcam;
    }

    public void setCameraChemcam(Boolean cameraChemcam) {

        this.cameraChemcam = cameraChemcam;
    }

    public Boolean getCameraMahli() {

        return cameraMahli;
    }

    public void setCameraMahli(Boolean cameraMahli) {

        this.cameraMahli = cameraMahli;
    }

    public Boolean getCameraMardi() {

        return cameraMardi;
    }

    public void setCameraMardi(Boolean cameraMardi) {

        this.cameraMardi = cameraMardi;
    }

    public Boolean getCameraNavcam() {

        return cameraNavcam;
    }

    public void setCameraNavcam(Boolean cameraNavcam) {

        this.cameraNavcam = cameraNavcam;
    }

    public Boolean getCameraPancam() {

        return cameraPancam;
    }

    public void setCameraPancam(Boolean cameraPancam) {

        this.cameraPancam = cameraPancam;
    }

    public Boolean getCameraMinites() {

        return cameraMinites;
    }

    public void setCameraMinites(Boolean cameraMinites) {

        this.cameraMinites = cameraMinites;
    }
}