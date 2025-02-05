package com.example.board.repository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "해당 이름과 일치하는 유저가 없습니다 username = " + username));
    }

    default Member findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist id = " + id));
    }
}
