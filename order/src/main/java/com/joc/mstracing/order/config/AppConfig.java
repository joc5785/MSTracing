package com.joc.mstracing.order.config;

import com.uber.jaeger.samplers.ProbabilisticSampler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Created by o'connell on 9/18/17.
 */

@org.springframework.context.annotation.Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        return new com.uber.jaeger.Configuration("Order-Service", new com.uber.jaeger.Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
                new com.uber.jaeger.Configuration.ReporterConfiguration())
                .getTracer();
    }
}

