package org.example.frontendservice;

import org.example.frontendservice.Models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class FrontendController {

    private List<Message> messageList = new ArrayList<>();

    @Autowired
    private FrontendProxy proxy;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @PostMapping("/{id}/operation")
    public ResponseEntity<String> addMessage(@RequestBody String message, @PathVariable int id) {

        try{
            String response = proxy.supportOperation(message);
            Message mess = new Message(id, message, response);
            messageList.add(mess);
            return new ResponseEntity<>(mess.toString(), HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//    @GetMapping("/{id}/operation")
//    public ResponseEntity<String> doOperation(@PathVariable int id, @RequestBody String data) {
//
//            String response = proxy.supportOperation(data, id);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
    }

