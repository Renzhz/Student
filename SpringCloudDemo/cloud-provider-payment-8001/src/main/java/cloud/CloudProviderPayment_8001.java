package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * cloud-provider-payment-8001 启动类
 * <p>
 * 2024/8/21
 */
@SpringBootApplication
@MapperScan("cloud.mapper")
public class CloudProviderPayment_8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment_8001.class);
    }
}
