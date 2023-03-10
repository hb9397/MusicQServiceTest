package com.kakao.musicqservicetest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RequestUtil {
	public String request(Object obj, String uri, String method) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		String requestDto = objectMapper.writeValueAsString(obj);

		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod(method);
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
