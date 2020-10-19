package com.example.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/main")
public class MyRestController {
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint0
	 * ----------------------------------------------------
	 */
	@GetMapping("/endpoint0")
	public String endpoint0() {
		return "Success String0";
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint1/1234
	 * ----------------------------------------------------
	 */
	@GetMapping("/endpoint1/{id}")
	public String endpoint1(@PathVariable String id) {
		return "Success String1 :: StudentId="+id;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint2?id=999
	 * ----------------------------------------------------
	 */
	@GetMapping("/endpoint2")
	public String endpoint2(@RequestParam(name="id", required=false, defaultValue="DEFAULT") String id) {
		return "Success String2 :: StudentId="+id;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint3
	 * Send this JSON in request body {"name":"TOM", "id":"123"}
	 * ----------------------------------------------------
	 */
	@PostMapping("/endpoint3")
	public String endpoint3(@RequestBody Student student) {
		return "Success String2 :: Student="+student;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint4
	 * Send this JSON in request body {"name":"TOM", "id":"123"}
	 * ----------------------------------------------------
	 */
	@PostMapping("/endpoint4")
	@ResponseBody
	public Student endpoint4(@RequestBody Student student) {
		System.out.println("received student="+student);
		Student st = new Student();
		st.setName("HARRY");
		st.setId("000");
		return st;
	}
	
}
