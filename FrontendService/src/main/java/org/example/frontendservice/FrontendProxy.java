package org.example.frontendservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SupportService")
public interface FrontendProxy {

    @PostMapping("/operation")
    String supportOperation(@RequestBody String data);

}
