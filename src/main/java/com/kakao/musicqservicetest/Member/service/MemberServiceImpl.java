package com.kakao.musicqservicetest.Member.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakao.musicqservicetest.Member.dto.MemberInfoCUDto;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService{
    @Override
    public String signup(MemberInfoCUDto memberInfoCUDto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestDto = objectMapper.writeValueAsString(memberInfoCUDto);

        URL url = new URL("http://localhost:81/api/v1/members/signup");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        OutputStream outputStream = connection.getOutputStream();

        outputStream.write(requestDto.getBytes());
        outputStream.flush();
        outputStream.close();

        int statusCode = connection.getResponseCode();

        String responseData = null;

        if(statusCode == HttpURLConnection.HTTP_OK){
            InputStream inputStream = connection.getInputStream();
            responseData = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining());
            inputStream.close();
            System.out.println(responseData);
        } else {
            System.out.println("Error: " + statusCode);
        }
        connection.disconnect();
        return responseData;
    }

}
