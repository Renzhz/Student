package cloud.cloud_nacos_provider_payment_9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Pay 控制器
 *
 * @since 2024/8/23
 */
@RestController
public class PayController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/service/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}
