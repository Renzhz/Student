package cloud.cloud_nacos_consumer_order_91.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单控制器 - nacos
 *
 * @since 2024/8/23
 */
@RestController
public class NacosOrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/nacos/pay/{id}")
    public String getPayInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        return result + "\t" + "NacosOrderController 91 消费者";
    }
}
