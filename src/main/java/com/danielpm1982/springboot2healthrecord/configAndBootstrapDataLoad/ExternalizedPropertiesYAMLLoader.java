package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("policy.yaml")
public class ExternalizedPropertiesYAMLLoader {
    @Value("${policy.statement}")
    private String statement;
    public String getPolicyStatement() {
        return statement;
    }
}
