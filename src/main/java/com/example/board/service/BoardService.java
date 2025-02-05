package com.example.board.service;

import com.example.board.dto.response.BoardResponseDto;
import com.example.board.dto.response.BoardWithAgeResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);
        Board saveBoard = new Board(title, contents);

        saveBoard.setMember(findMember);
        boardRepository.save(saveBoard);

        return new BoardResponseDto(saveBoard.getId(), saveBoard.getTitle(), saveBoard.getContents());
    }

    public List<BoardResponseDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::toDto)
                .toList();
    }

    public BoardWithAgeResponseDto findById(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();
        return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
    }

    public void delete(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        boardRepository.delete(findBoard);
    }
}
