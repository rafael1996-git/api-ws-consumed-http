package com.upaxer.serverless.serviceImplement;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upaxer.serverless.IServiceDao.IDaoHttp;
import com.upaxer.serverless.entity.ResponseToken;
import com.upaxer.serverless.entity.UserLogin;
import com.upaxer.serverless.models.RequestModel;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class Repository implements IDaoHttp {
	private static final String AUTHENTICATION_URL = "https://gateway.aivo.co/api/v1/auth";
	private static final String SET_SOLICITUDES = "https://gateway.aivo.co/api/v1/conversation-whatsapp-native-templates";

	private static final Logger logger = LoggerFactory.getLogger(Repository.class);
	@Autowired
	RestTemplate restTemplate;
	@Override
	public String Auth(UserLogin user)throws Exception {
		String response = null;
			String authenticationBody = getBody(user);
			HttpHeaders authenticationHeaders = getHeaders();
			HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
					authenticationHeaders);
			// Authenticate User and get JWT
			ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
					HttpMethod.POST, authenticationEntity, ResponseToken.class);
			// if the authentication is successful
			System.out.println(authenticationResponse.getStatusCode().equals(HttpStatus.OK));
			System.out.println(authenticationResponse.getBody().getAuthorization());
			// if the authentication is successful		
			if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
				response=authenticationResponse.getBody().getAuthorization();

			}
		    return response;
			}
			
			@Override
			public String Conv_What_nat_templ(String requestJson)throws Exception {
				String response = null;

				System.out.println( requestJson);

				OkHttpClient client = new OkHttpClient().newBuilder()
						  .build();
						MediaType mediaType = MediaType.parse("application/json");
						RequestBody body = RequestBody.create(mediaType, requestJson);
						Request request = new Request.Builder()
						  .url(SET_SOLICITUDES)
						  .method("POST", body)
						  .addHeader("Content-Type", "application/json")
						  .addHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik5VSTBRa0V4TmpZNU5rUTJOek5GUmpWRU1qQTBOMFU1UVRZelJUQkVSamhDUkRreU5ESXhOZyJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYyNzMwOThhMDc3NDZlMDA2Zjg2YzM2ZiJ9LCJuaWNrbmFtZSI6ImRzb2xhbm9nIiwibmFtZSI6IkRpZWdvIEFkcmnDoW4gU29sYW5vIEd1YXJuZXJvcyIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9mOGE5YjE1MTkzMmM5Njg3ZjY2MjM2YWMxNWYwNmYyOD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmRhLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIzLTAxLTA0VDAwOjE4OjM5LjE0NVoiLCJlbWFpbCI6ImRzb2xhbm9nQHVwYXguY29tLm14IiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOi8vYWl2b2NvLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MjczMDk4YTA3NzQ2ZTAwNmY4NmMzNmYiLCJhdWQiOiJSeE4yWjlJQjFiaG5nVEE2MDJ4dFRDUWFUTkpEUlZtOCIsImlhdCI6MTY3Mjc5MTUxOSwiZXhwIjoxNjcyODI3NTE5fQ.bWULaiR1ccDLO0VAO2bnp1zg4TqVpV1u1alchN2suGqHFErg3Z_MqEC2kWqK8ixfIxDETjBgj0gvEvgBR9JiqLt35nAVP5oZwua7pbDImQa3D8IauZP3k7iqFGZssdzQLf0Vb64SlQn5Fkk9nxcCtvTYPOFpXNVe_ZxFuD7UQUNUy25YGhvC_okwMGWYaigaMem-nT2PSfrNFqkh1vsskrWXAFLs_0sHUMlWM55h1iOKXecT6Eh8J4mvfIf_jCIhI60yDeYwo0x5XwneDelk91YnlK0e7rmHfZwV-WKhme-thtZ6MUPEOX9KYHQOOUdy32-6u56Tw5zpo0qEe-L11w")
						  .addHeader("X-Token", "TnpVNE16aGxaVFU0TVRFd1pqZzNPRGxoTjJJM1ptWmlZbVUzWlRCaU5tWT0=")
						  .build();
						Response Response = client.newCall(request).execute();
						System.out.println( Response);
						response=Response.toString();
				return response;
			}
			
			
			private HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Content-Type", "application/json");
				headers.set("Accept", "application/json");
				return headers;
			}
			private String getBody(final UserLogin user) throws JsonProcessingException {
				return new ObjectMapper().writeValueAsString(user);
			}
			private String getBodyJson(final RequestModel request) throws JsonProcessingException {
				return new ObjectMapper().writeValueAsString(request);
			}

}
