package com.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mybatis.mapper.HotelMapper;

/**
 * @author arun
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private HotelMapper hotelMapper;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(this.hotelMapper.selectByCityId(1));
	}
}
