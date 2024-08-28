package cloud.cloud_gateway_9527.gateway;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate 自定义需求：自定义配置会员等级 userLevel，按照钻/金/银和 yaml 配置的会员等级，以适配是否可以访问
 *
 * @since 2024/8/28
 */
@Component
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {
    private static final String USER_LEVEL_KEY = "userLevel";

    public CustomRoutePredicateFactory() {
        super(CustomRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(CustomRoutePredicateFactory.Config config) {
        String[] userLevels = config.userLevel.split("\\|");
        return serverWebExchange -> {
            String userLevel = serverWebExchange.getRequest().getQueryParams().getFirst("userLevel");
            if (userLevel == null) return false;
            return Arrays.stream(userLevels).anyMatch(value -> value.equalsIgnoreCase(userLevel));
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(USER_LEVEL_KEY);
    }

    @Setter
    @Getter
    @Validated
    public static class Config {
        @NotEmpty
        private String userLevel;
    }
}
