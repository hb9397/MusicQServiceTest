package com.kakao.musicqservicetest.Member.controller;

import com.kakao.musicqservicetest.Member.dto.MemberInfoCUDto;
import com.kakao.musicqservicetest.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberRestController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(
            @Valid @RequestBody MemberInfoCUDto memberInfoCUDto
            ){
        try {
            return ResponseEntity.ok(memberService.signup(memberInfoCUDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
