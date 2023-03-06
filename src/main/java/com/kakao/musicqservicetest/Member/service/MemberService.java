package com.kakao.musicqservicetest.Member.service;

import com.kakao.musicqservicetest.Member.dto.MemberSignUpDto;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface MemberService {
    String signup(MemberSignUpDto memberInfoCUDto) throws IOException;
    String checkEmail(String email) throws IOException;
}
