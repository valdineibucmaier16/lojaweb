package br.edu.utfpr.pb.lojaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompraController {

	@GetMapping("compra")
	public String compra() {
		return "compra/compra";
	}
	
	
}
