package com.example.optimizerpc.configurations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cloudinary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryProperties {
    private String cloudName;
    private String apiKey;
    private String apiSecret;
    }

