package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalizedPropertiesEnvironmentLoader {
    @Autowired
    private Environment env;
    private Map<String, String> environmentDataMap;
    @PostConstruct
    public void createAndSetEnvData(){
        String hospitalName = env.getProperty("HOSPITAL_NAME");
        String userName = env.getProperty("USER_NAME");
        environmentDataMap = new HashMap<>();
        environmentDataMap.put("hospitalName", hospitalName);
        environmentDataMap.put("userName", userName);
    }
    public Map<String, String> getEnvironmentDataMap() {
        return environmentDataMap;
    }
}
