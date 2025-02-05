package com.example.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {

    private final String username;

    private final Integer age;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public MemberResponseDto(String username, Integer age, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.username = username;
        this.age = age;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
