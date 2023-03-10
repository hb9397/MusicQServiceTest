package com.kakao.musicqservicetest.Member.service;


import com.kakao.musicqservicetest.Member.dto.MemberSignUpDto;
import com.kakao.musicqservicetest.util.RequestUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final RequestUtil requestUtil;

    private final RestTemplate restTemplate;
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

    public ResponseEntity<String> signup2(MemberSignUpDto memberSignUpDto){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:81/api/v1/members/signup",memberSignUpDto ,String.class);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        return response;
    }

}
