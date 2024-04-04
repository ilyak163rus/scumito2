package com.svarto.sitespringredis;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories implements Serializable {
    private Long id;
    private String name;
}
