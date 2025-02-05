package com.example.board.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {

    private final Long id;

    private final String username;

    private final Integer age;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public MemberResponseDto(Long id, String username, Integer age, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
