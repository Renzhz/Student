package cloud.cloud_nacos_consumer_order_91.controller;

import cloud.cloud_common.apis.PayFeignApi;
import cloud.cloud_common.response.ResultDate;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单网关控制器
 *
 * @since 2024/8/27
 */
@RestController
public class NacosOrderGatewayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/pay/gateway/get/{id}")
    public ResultDate getById(@PathVariable("id") Integer id) {
        return payFeignApi.getById(id);
    }

    @GetMapping("/feign/pay/gateway/info")
    public ResultDate<String> gatewayInfo() {
        return payFeignApi.gatewayInfo();
    }
}
