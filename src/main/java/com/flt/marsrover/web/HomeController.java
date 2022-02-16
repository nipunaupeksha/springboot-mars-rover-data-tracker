package com.flt.marsrover.web;

import com.flt.marsrover.dto.HomeDto;
import com.flt.marsrover.response.MarsRoverAPIResponse;
import com.flt.marsrover.service.MarsRoverAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverAPIService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model, HomeDto homeDto) throws IllegalAccessException, InvocationTargetException{
        //if request param is empty
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("Opportunity");
        }
        if(homeDto.getMarsSol()==null){
            homeDto.setMarsSol(1);
        }
        MarsRoverAPIResponse roverData = roverService.getRoverData(homeDto);
        model.put("roverData", roverData);
        model.put("homeDto",homeDto);
        model.put("validCameras", roverService.getValidCameras().get(homeDto.getMarsApiRoverData()));
        return "index";
    }
}
