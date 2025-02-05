package com.example.board.dto.request;

import lombok.Getter;

@Getter
public class CreatedBoardRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    public CreatedBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
