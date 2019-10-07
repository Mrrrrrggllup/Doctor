package com.WildCodeSchool.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}


	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public String doctor(@PathVariable int number) {
		if (number >= 9 && number<=13){
			switch (number)
			{
				case 9: return "number : " + number+ ", name : Christopher Eccleston";
				case 10: return "number : " + number+ ", name : David Tennant";
				case 11: return "number : " + number+ ", name : Matt Smith";
				case 12: return "number : " + number+ ", name : Peter Capaldi";
				case 13: return "number : " + number+ ", name : Jodie Whittaker";
			}
		}else if (number <9 && number > 0){
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Allez voir ailleurs vous dis-je !");
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation : "+number);

		}
		return null;
	}



}