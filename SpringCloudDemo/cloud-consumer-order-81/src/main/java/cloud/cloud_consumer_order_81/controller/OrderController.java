package cloud.cloud_consumer_order_81.controller;

import cloud.cloud_common.entities.PayDTO;
import cloud.cloud_common.response.ResultDate;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单控制器
 *
 * @since 2024/8/22
 */
@RestController
public class OrderController {
    private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultDate getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/pay/getById/" + id, ResultDate.class, id);
    }

    @GetMapping(value = "/consumer/pay/add")
    public ResultDate addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/pay/add", payDTO, ResultDate.class);
    }

    @GetMapping(value = "/consumer/pay/update")
    public void updateOrder(PayDTO payDTO) {
        restTemplate.put(PAYMENT_SERVICE_URL + "/pay/update", payDTO);
    }

    @GetMapping(value = "/consumer/pay/del/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) {
        restTemplate.delete(PAYMENT_SERVICE_URL + "/pay/del/" + id);
    }
}
