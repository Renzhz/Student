package cloud.cloud_nacos_config_client_9101.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nacos Config Client 控制器
 *
 * @since 2024/8/23
 */
@RestController
@RefreshScope // 在控制器类加入 @RefreshScope 注解是当前类下的配置支持 nacos 的动态刷新功能
public class NacosConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
