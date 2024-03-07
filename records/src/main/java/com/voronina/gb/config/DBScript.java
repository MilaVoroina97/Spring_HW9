package com.voronina.gb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DBScript {

    private String getAll;
    private String save;
    private String deleteById;
    private String getOneRecord;
    private String updateRecord;
}
