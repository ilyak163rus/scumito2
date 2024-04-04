package com.svarto.sitespringredis;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    @Id
    private Long id;
    private Long CustomerId;
    @Indexed
    private Long ProductId;
    private String message;
    private ZonedDateTime message_date;
}
