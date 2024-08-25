package cloud.cloud_nacos_config_client_9101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud-nacos-config-client-9101 模块主启动类
 *
 * @since 2024/8/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConfigClient_9101 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConfigClient_9101.class);
    }
}
