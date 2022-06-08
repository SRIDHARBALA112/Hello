package com.springboot.Test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Test {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder enc=new BCryptPasswordEncoder();
		String s=enc.encode("john");
		System.out.println(s);
		
		// TODO Auto-generated method stub

	}

}
