package cloud.cloud_provider_payment_8001.controller;

import cloud.cloud_common.response.ResultDate;
import cloud.cloud_provider_payment_8001.entities.Pay;
import cloud.cloud_provider_payment_8001.service.PayService;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Pay 网关控制器
 *
 * @since 2024/8/27
 */
@RestController
public class PayGatewayController {
    @Resource
    private PayService payService;

    @GetMapping("/pay/gateway/get/{id}")
    public ResultDate<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultDate.success(pay);
    }

    @GetMapping("/pay/gateway/info")
    public ResultDate<String> gatewayInfo() {
        return ResultDate.success("gateway info: " + IdUtil.simpleUUID());
    }
}
