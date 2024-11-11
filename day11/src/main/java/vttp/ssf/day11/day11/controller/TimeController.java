package vttp.ssf.day11.day11.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//make this class a request handler, it will handle https requests and return responses
@Controller

//RequestMapping handles the /time resource. Any request starting with /time will be routed to the below class methods
@RequestMapping(path = "/time")
public class TimeController {
    
    @GetMapping("/gmt") //maps to /time/gmt endpoint
    public String getTimeGmt(Model model){
        String currentTime = (new Date()).toString();   
        model.addAttribute("currTime", "this is the GMT time: %s".formatted(currentTime));
        return "time"; //refers to the name of the html file
    }


    //this method will handle the request "GET /time" (VERB/NOUN)
    @GetMapping() //only maps to the base /time endpoint
    public String getTime(Model model){
        //generate data for your view
        String currentTime = (new Date()).toString();
        //bind the data to the model
        model.addAttribute("currTime", currentTime);
        //display the template/view
        return "time"; //refers the the name of the html file
    }



}
