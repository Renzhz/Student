package cloud.cloud_common.apis;

import cloud.cloud_common.entities.PayDTO;
import cloud.cloud_common.response.ResultDate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 支付 API
 *
 * @since 2024/8/24
 */
//@FeignClient(value = "cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayFeignApi {
    @GetMapping("/service/info")
    String getInfo();

    @GetMapping("/service/timeout")
    String getInfoTimeout();

    @GetMapping("/pay/getById/{id}")
    ResultDate<PayDTO> getPayInfo(@PathVariable("id") Integer id);

    @PostMapping("/pay/add")
    ResultDate<String> addPay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/gateway/get/{id}")
    ResultDate getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/info")
    ResultDate<String> gatewayInfo();
}
