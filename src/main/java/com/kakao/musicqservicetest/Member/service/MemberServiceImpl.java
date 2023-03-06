package com.kakao.musicqservicetest.Member.service;


import com.kakao.musicqservicetest.Member.dto.MemberSignUpDto;
import com.kakao.musicqservicetest.util.RequestUtil;

import org.springframework.stereotype.Service;

import java.io.*;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final RequestUtil requestUtil;
    @Override
    public String signup(MemberSignUpDto memberInfoCUDto) throws IOException {
        String response = requestUtil.request(memberInfoCUDto, "http://localhost:81/api/v1/members/signup", "POST");

        return response;
    }

    @Override
    public String checkEmail(String email) throws IOException {
        String response = requestUtil.request(email, "http://localhost:81/api/v1/members/email", "GET" );
        return response;
    }

}
