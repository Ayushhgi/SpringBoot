package com.RestDemo.RestDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		int []arr={1,2,3,4,5,6};
//		IntStream s= Arrays.stream(arr);
//		s.forEach(System.out::print);
//		int a=s.sum();
//		List<Integer> ls=Arrays.stream(arr).boxed().collect(Collectors.toList());
		Arrays.stream(arr).boxed().map(x->x*x).forEach(System.out::println);
//		System.out.println(ls1);


		SpringApplication.run(RestDemoApplication.class, args);
	}

}
