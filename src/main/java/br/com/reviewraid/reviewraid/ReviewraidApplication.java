package br.com.reviewraid.reviewraid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableCaching
public class ReviewraidApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewraidApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home() {
		return "Review Raid";
	}
}
