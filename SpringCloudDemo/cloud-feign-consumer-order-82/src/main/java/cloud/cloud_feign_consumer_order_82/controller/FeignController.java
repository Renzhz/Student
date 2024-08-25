package cloud.cloud_feign_consumer_order_82.controller;

import cloud.cloud_common.apis.NacosFeignApi;
import cloud.cloud_common.apis.PayFeignApi;
import cloud.cloud_common.entities.PayDTO;
import cloud.cloud_common.response.ResultDate;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * {Class 描述}
 *
 * @since 2024/8/24
 */
@RestController
public class FeignController {
    private static final Logger log = LoggerFactory.getLogger(FeignController.class);
    @Resource
    private PayFeignApi payFeignApi;

    @Resource
    private NacosFeignApi nacosFeignApi;

    @GetMapping("/feign/service/info")
    String getInfo() {
        return payFeignApi.getInfo();
    }

    @GetMapping("feign/service/timeout")
    String getInfoTimeout() {
        String result;
        try {
            log.info("开始");
            result = payFeignApi.getInfoTimeout();
        } catch (Exception e) {
            result = "失败";
            e.printStackTrace();
            log.info("结束");
        }

        return result;
    }

    @GetMapping("/feign/service/nacos/{id}")
    String getNacosInfo(@PathVariable("id") Integer id) {
        return nacosFeignApi.getInfo(id);
    }

    @GetMapping("/feign/pay/get/{id}")
    ResultDate getPayInfo(@PathVariable("id") Integer id) {
        return payFeignApi.getPayInfo(id);
    }

    @PostMapping("/feign/pay/add")
    ResultDate addPay(@RequestBody PayDTO payDTO) {
        return payFeignApi.addPay(payDTO);
    }
}
