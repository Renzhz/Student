package cloud.controller;

import cloud.entities.Pay;
import cloud.entities.PayDTO;
import cloud.service.PayService;
import cn.hutool.core.bean.BeanUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 支付交易 controller
 * <p>
 * 2024/8/21
 */
@Slf4j
@RestController
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int result = payService.add(pay);

        return result == 1 ? "成功插入记录，返回值：" + result : "插入记录失败，返回值：" + result;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable(name = "id") Integer id) {
        log.info(String.valueOf(id));
        return payService.delete(id);
    }

    @PutMapping("/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO) {
        log.info(payDTO.toString());

        Pay newPay = new Pay();
        BeanUtil.copyProperties(payDTO, newPay);
        int result = payService.update(newPay);

        return result == 1 ? "成功更新记录，返回值：" + result : "更新记录失败，返回值：" + result;
    }

    @GetMapping("/pay/getById/{id}")
    public Pay getById(@PathVariable(name = "id") Integer id) {
        return payService.getById(id);
    }

    @PostMapping("/")
    public List<Pay> getAll() {
        List<Pay> payList = payService.getAll();
        log.info("获取所有支付记录成功");
        return payList;
    }
}
