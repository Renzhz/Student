package cloud.cloud_provider_payment_8001.controller;

import cloud.cloud_common.constant.ReturnCode;
import cloud.cloud_common.entities.PayDTO;
import cloud.cloud_common.response.ResultDate;
import cloud.cloud_provider_payment_8001.entities.Pay;
import cloud.cloud_provider_payment_8001.service.PayService;
import cn.hutool.core.bean.BeanUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 支付交易 controller
 * <p>
 *
 * @since 2024/8/21
 */
@Slf4j
@RestController
public class PayController {
    @Resource
    private PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/pay/add")
    public ResultDate<String> addPay(@RequestBody Pay pay) {
        int result = payService.add(pay);

        return result == 1 ? ResultDate.success("成功插入记录，返回值：" + result) : ResultDate.fail(ReturnCode.FAIL.getCode(), "插入记录失败，返回值：" + result);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public ResultDate<String> deletePay(@PathVariable(name = "id") Integer id) {
        int result = payService.delete(id);
        return result == 1 ? ResultDate.success("成功删除记录，返回值：" + result) : ResultDate.fail(ReturnCode.FAIL.getCode(), "删除记录失败，返回值：" + result);
    }

    @PutMapping("/pay/update")
    public ResultDate<String> updatePay(@RequestBody PayDTO payDTO) {
        log.info(payDTO.toString());

        Pay newPay = new Pay();
        BeanUtil.copyProperties(payDTO, newPay);
        int result = payService.update(newPay);

        return result == 1 ? ResultDate.success("成功更新记录，返回值：" + result) : ResultDate.fail(ReturnCode.FAIL.getCode(), "更新记录失败，返回值：" + result);
    }

    @GetMapping("/pay/getById/{id}")
    public ResultDate<Pay> getById(@PathVariable(name = "id") Integer id) {
        if (id <= 0) throw new RuntimeException("查询条件无效.");
        Pay pay = payService.getById(id);
        return Objects.isNull(pay) ? ResultDate.fail(ReturnCode.FAIL.getCode(), "未查询到支付记录.") : ResultDate.success(pay);
    }

    @PostMapping("/")
    public ResultDate<List<Pay>> getAll() {
        List<Pay> payList = payService.getAll();
        return payList.isEmpty() ? ResultDate.fail(ReturnCode.FAIL.getCode(), "获取数据失败.") : ResultDate.success(payList);
    }

    @GetMapping("/service/info")
    public String getInfo() {
        return "cloud-payment-service, port " + serverPort;
    }

    @GetMapping("/service/timeout")
    String getInfoTimeout() {
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException exception) {
            log.error(exception.getMessage());
        }

        return "success! cloud-payment-service, port " + serverPort;
    }
}
