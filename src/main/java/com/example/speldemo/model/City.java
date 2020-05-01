package com.example.speldemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component("city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private String name;
    private double shipping;
    private Boolean isCapital;
}
