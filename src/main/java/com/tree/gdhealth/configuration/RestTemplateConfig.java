package com.tree.gdhealth.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * @author 정인호
 * @apiNote 로컬에서 new 연산자로 선언된 RestTemplate과는 StringHttpMessageConverter 우선순위 차이가 있다.
 * 스프링 빈으로 생성될 경우 xml response를 자동으로 json 으로 convert 해준다. 이 점을 유의할 것.
 * 만약 MappingJackson2HttpMessageConverter 가 MappingJackson2XmlHttpMessageConverter 보다 우선순위라면 이같은 일이 발생한다.
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
                .build();
    }
}