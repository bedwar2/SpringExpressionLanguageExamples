package com.example.speldemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
@Data
public class User {

    @Value("#{'Fred Jones'}")
    private String name;

    @Value("#{50}")
    private int age;

    @Value("#{systemProperties['user.country']}")
    private String country;
    @Value("#{systemProperties['user.language']}")
    private String language;
    @Value("#{systemProperties['user.timezone']}")
    private String timeZone;


}
