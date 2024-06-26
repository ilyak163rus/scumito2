package com.svarto.sitespringredis.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.svarto.sitespringredis.Response;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
    List<Response> findByProductId(Long id);
}
