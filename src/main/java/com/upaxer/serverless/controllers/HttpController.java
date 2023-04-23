package com.upaxer.serverless.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upaxer.serverless.IServiceDao.IDaoHttp;
import com.upaxer.serverless.entity.UserLogin;
import com.upaxer.serverless.models.RequestModel;
import com.upaxer.serverless.models.Response;
import com.upaxer.serverless.util.Helpers;



@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class HttpController {
	private static final Logger logging = LoggerFactory.getLogger(HttpController.class);
    private final String canonicalName = HttpController.class.getCanonicalName();
    @Autowired
	private IDaoHttp daoHttp;
	
	@RequestMapping(path = "/auth", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> Auth(@RequestBody  UserLogin request) throws Exception {
		Map<String, Object> dataResponse = new HashMap<>();
		Response response = new Response();
			try {
			        String json = daoHttp.Auth(request);
			        dataResponse.put("json", json);
			        response.setCode(200);
					response.setMessage("The client has been successfully!");
			} catch (Exception e) {
				logging.error(e.getMessage());
				response.setCode(500);
				response.setMessage("");
				response.setError(e.getMessage().toString());
			}
	       
	        return   Helpers.ResponseClass(response.getCode(), dataResponse, response.getMessage(), response.getError());
	}

	@RequestMapping(path = "/conversation-whatsapp-native-templates", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> Conv_What_nat_templ(@RequestBody  String requestJson) throws Exception {
		Map<String, Object> dataResponse = new HashMap<>();
		Response response = new Response();
			try {
			        String json = daoHttp.Conv_What_nat_templ(requestJson);
			        dataResponse.put("jsonResponse", json);
			        response.setCode(200);
					response.setMessage("The client has been successfully!");
			} catch (Exception e) {
				logging.error(e.getMessage());
				response.setCode(500);
				response.setMessage("");
				response.setError(e.getMessage().toString());
			}
	       
	        return   Helpers.ResponseClass(response.getCode(), dataResponse, response.getMessage(), response.getError());
	}
}
