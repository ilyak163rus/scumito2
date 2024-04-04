package com.svarto.sitespringredis.services;

import java.security.Principal;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import com.svarto.sitespringredis.Product;
import com.svarto.sitespringredis.Response;
import com.svarto.sitespringredis.User;
import com.svarto.sitespringredis.repos.ResponseRepository;
import com.svarto.sitespringredis.repos.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseService {

    @Autowired
    private RedisAtomicLong idGenerator;

    private  ResponseRepository responseRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Response> getResponseByProductId(Long id) {
        return responseRepository.findByProductId(id);
    }

    public void makeResponse(Response response, Principal principal, Product product) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("No user found for email: " + email);
            return;
        }
        Long newId = idGenerator.incrementAndGet();
        response.setId(newId);
        log.info("Saving new Response");
        response.setCustomerId(user.getId());
        response.setProductId(product.getId());
        response.setMessage_date(ZonedDateTime.now());
        responseRepository.save(response);
    }

}
