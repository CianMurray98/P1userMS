package ie.atu.userms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "menums", url = "http://localhost:8080")
public interface MenuFeignClient {

    @GetMapping("/menu/{itemId}")
    String getMenuItemById(@PathVariable String itemId);
}