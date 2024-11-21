package vttp.ssf.day11.day11.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/RandomImages")

public class ImageController {     

    //tertiary
    // @Controller
    // @RequestMapping

    // @GetMapping(path={"/", "/index.html"})
    // public String getIndex(Model model) { //Model model is used to pass any data to view via model.addattribute
    //    model.addAttribute("imageOfTheDay", getPictureOfTheDay());
    //    return "picture_of_the_day";
    // }

    // private String getPictureOfTheDay() {

    //     Random rnd = new SecureRandom();
    //     int idx = rnd.nextInt(Constants.PICTURES.length);
    //     return "/images/%s".formatted(Constants.PICTURES[idx]); //image path of the randomly chosen image
  
    //  }

    //picture_of_the_day html
    // <h1>Picture of the Day</h1>

    // <hr>
 
    // <div>
    //    <img data-th-src="${imageOfTheDay}" >
    // </div>



    @GetMapping("/randomised") //maps to /RandomImages/randomised endpoint
    public ResponseEntity<byte[]> getImage() throws IOException{
        String  imagePath = "src/main/resources/static/images/";

        List<String> imageFiles = Files.walk(Paths.get(imagePath))
                                .filter(Files::isRegularFile)
                                .filter(path -> path.toString().matches(".*\\.(jpg|jpeg|png|gif)$")) // Only image files
                                .map(path -> path.toString())
                                .collect(Collectors.toList());
        Random random = new Random();
        String randomImagePath = imageFiles.get(random.nextInt(imageFiles.size()));

        // Read the image file into bytes
        byte[] imageBytes = Files.readAllBytes(Paths.get(randomImagePath));

        // Set headers for the image response (based on file type)
        HttpHeaders headers = new HttpHeaders();
        String contentType = "image/jpeg"; // Default to JPEG, but this can be dynamically set based on file extension
        if (randomImagePath.endsWith(".png")) {
            contentType = "image/png";
        } else if (randomImagePath.endsWith(".gif")) {
            contentType = "image/gif";
        }
        headers.setContentType(MediaType.parseMediaType(contentType));

        // Return the random image in the response body
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }


    //seperate theimage serving logic under randomised. It was previously overriding the html with just the random image
    @GetMapping("/display") //maps to RandomImages/display endpoint
    public String displayImagePage() {
        return "images"; // This will refer to the images.html template
    }

    
}
