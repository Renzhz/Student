package cloud.cloud_common.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 支付 API
 *
 * @since 2024/8/24
 */
@FeignClient(value = "nacos-payment-provider")
public interface NacosFeignApi {
    @GetMapping("/service/nacos/{id}")
    String getInfo(@PathVariable("id") Integer id);
}
