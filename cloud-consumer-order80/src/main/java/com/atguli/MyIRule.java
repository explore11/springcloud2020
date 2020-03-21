package com.atguli;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {

    @Bean
    public IRule getRandomIRule() {
        return new RandomRule();
    }
}
