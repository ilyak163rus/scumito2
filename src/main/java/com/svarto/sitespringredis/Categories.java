package com.svarto.sitespringredis;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories implements Serializable {
    @Id
    private Long id;
    private String category_name;
}
