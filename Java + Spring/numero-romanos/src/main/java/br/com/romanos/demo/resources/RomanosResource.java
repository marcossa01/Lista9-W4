package br.com.romanos.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/romanos")
public class RomanosResource {
	
	public int [] valores = {1000, 900, 500, 100, 90, 50, 40, 10, 5, 1};
	public String [] letras = {"M", "CM", "D", "C", "XC", "L", "XL", "X", "V", "I"};
	
	//localhost:8080/romanos?number={number}
	@GetMapping
	public ResponseEntity<String> romano2(@RequestParam int number) {
		String romano2 = "";
		for (int i = 0; i < valores.length; i++) {
			if (number == 4) {
				romano2 += "IV";
				break;
			}
			
			else if (number == 9) {
				romano2 += "IX";
				break;
			}
			else {
				while(number >= valores[i]) {
					number -= valores[i];
					romano2 += letras[i];
				}
			}
		}
		return ResponseEntity.ok(romano2);
	}
	
	
	//localhost:8080/romanos/{number} 
	@GetMapping(value = "/{number}")
	public ResponseEntity<String> romano(@PathVariable int number) {
		String romano = "";
		for (int i = 0; i < valores.length; i++) {
			if (number == 4) {
				romano += "IV";
				break;
			}
			
			else if (number == 9) {
				romano += "IX";
				break;
			}
			else {
				while(number >= valores[i]) {
					number -= valores[i];
					romano += letras[i];
				}
			}
		}
		return ResponseEntity.ok(romano);
	}
	

}
