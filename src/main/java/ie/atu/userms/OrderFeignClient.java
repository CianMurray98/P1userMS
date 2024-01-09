package ie.atu.userms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orderms")
public interface OrderFeignClient {

    @GetMapping("/order/{orderId}")
    String getOrderById(@PathVariable String orderId);
}