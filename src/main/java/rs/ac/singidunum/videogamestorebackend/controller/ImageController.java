package rs.ac.singidunum.videogamestorebackend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/api/image")
class ImageController {

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping(path = "/{title}")
    public void serveImageHandler(@PathVariable String title, HttpServletResponse response) {

        try {
            InputStream fileInputStream = new FileInputStream("src/main/resources/img/" + title + ".jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            try {
                InputStream fileInputStream = new FileInputStream("src/main/resources/img/no-image.jpg");
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                StreamUtils.copy(fileInputStream, response.getOutputStream());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
