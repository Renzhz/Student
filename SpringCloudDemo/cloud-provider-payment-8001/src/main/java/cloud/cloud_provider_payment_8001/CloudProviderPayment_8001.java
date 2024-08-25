package cloud.cloud_provider_payment_8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * cloud-provider-payment-8001 启动类
 *
 * @since 2024/8/21
 */
@SpringBootApplication
@MapperScan("cloud.cloud_provider_payment_8001.mapper")
@EnableDiscoveryClient
public class CloudProviderPayment_8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment_8001.class);
    }
}
