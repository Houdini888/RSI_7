package org.example.supportservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Base64;
import java.util.Base64.Encoder;

@RestController
public class SupportController {

    @PostMapping("/operation")
    public ResponseEntity<String> encode(@RequestBody(required = false) String str) throws HttpClientErrorException.BadRequest {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedStr = encoder.encodeToString(str.getBytes());
            return ResponseEntity.status(HttpStatus.OK).body(encodedStr);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during encoding");
        }
    }

}
