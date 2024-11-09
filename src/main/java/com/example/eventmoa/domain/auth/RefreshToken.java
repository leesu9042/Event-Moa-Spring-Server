package com.example.eventmoa.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    @Id
    private String token;

    @Indexed
    private String id;

    @TimeToLive
    private Long ttl;
}
