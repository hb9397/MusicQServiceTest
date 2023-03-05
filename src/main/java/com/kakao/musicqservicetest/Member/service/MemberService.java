package com.kakao.musicqservicetest.Member.service;

import com.kakao.musicqservicetest.Member.dto.MemberInfoCUDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface MemberService {
    String signup(MemberInfoCUDto memberInfoCUDto) throws IOException;
}
