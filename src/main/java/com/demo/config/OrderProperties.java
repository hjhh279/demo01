package com.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yyk
 * @description: TODO
 * @date 2022/4/25  9:51
 */
@Component
@ConfigurationProperties(prefix = "order")
@Data
public class OrderProperties {

    private Integer payTimeoutSeconds;

    private Integer createFrequencySeconds;

    private String desc;
}
