package com.example.board.controller;

import com.example.board.dto.response.BoardResponseDto;
import com.example.board.dto.response.BoardWithAgeResponseDto;
import com.example.board.dto.request.CreatedBoardRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreatedBoardRequestDto requestDto) {
        BoardResponseDto responseDto = boardService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        List<BoardResponseDto> responseDtos = boardService.findAll();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id) {
        BoardWithAgeResponseDto responseDto = boardService.findById(id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
