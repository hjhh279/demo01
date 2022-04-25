package com.demo;

import com.demo.config.OrderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;



//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Component
    public class OrderRunner implements CommandLineRunner{

        private final Logger logger = LoggerFactory.getLogger(getClass());
        @Autowired
        private OrderProperties orderProperties;
        @Override
        public void run(String... args) throws Exception {
            logger.info("pay"+orderProperties.getPayTimeoutSeconds());
            logger.info("create"+orderProperties.getCreateFrequencySeconds());
            logger.info("desc"+orderProperties.getDesc());
        }
    }

    @Component
    public class ValueCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value("${order.pay-timeout-seconds}")
        private Integer payTimeoutSeconds;

        @Value("${order.create-frequency-seconds}")
        private Integer createFrequencySeconds;

        @Override
        public void run(String... args) {
            logger.info("payTimeoutSeconds:" + payTimeoutSeconds);
            logger.info("createFrequencySeconds:" + createFrequencySeconds);
        }

    }
}
