package com.flt.marsrover.service;

import com.flt.marsrover.dto.HomeDto;
import com.flt.marsrover.response.MarsPhoto;
import com.flt.marsrover.response.MarsRoverAPIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class MarsRoverAPIService {
    private static final String API_KEY = "DEMO_KEY";
    private Map<String,List<String>> validCameras = new HashMap<>();

    public MarsRoverAPIService(){
        validCameras.put("Curiosity", Arrays.asList("FHAZ","RHAZ","MAST","CHEMCAM","MAHLI","MARDI","NAVCAM"));
        validCameras.put("Opportunity",Arrays.asList("FHAZ","RHAZ","NAVCAM","PANCAM","MINITES"));
        validCameras.put("Spirit",Arrays.asList("FHAZ","RHAZ","NAVCAM","PANCAM","MINITES"));
    }

    public MarsRoverAPIResponse getRoverData(HomeDto homeDto)throws InvocationTargetException, IllegalAccessException{
        RestTemplate rt = new RestTemplate();
        List<String> apiUrlEndPoints = getApiURLEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverAPIResponse response = new MarsRoverAPIResponse();
        apiUrlEndPoints.stream().forEach(url->{
            MarsRoverAPIResponse apiResponse = rt.getForObject(url,MarsRoverAPIResponse.class);
            photos.addAll(apiResponse.getPhotos());
        });

        response.setPhotos(photos);

        return response;
    }

    public List<String> getApiURLEndpoints(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        List<String> urls = new ArrayList<>();
        Method[] methods = homeDto.getClass().getMethods();
        for(Method method:methods){
            if(method.getName().indexOf("getCamera")>-1 &&
                    Boolean.TRUE.equals(method.invoke(homeDto))){
                String cameraName = method.getName().split("getCamera")[1].toUpperCase();
                if(validCameras.get(homeDto.getMarsApiRoverData()).contains(cameraName) ){
                    urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera="+cameraName);
                }
            }
        }
        return urls;
    }

    public Map<String,List<String>> getValidCameras(){
        return validCameras;
    }
}
