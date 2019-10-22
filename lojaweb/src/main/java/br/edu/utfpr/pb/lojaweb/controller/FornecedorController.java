package br.edu.utfpr.pb.lojaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.lojaweb.model.Fornecedor;
import br.edu.utfpr.pb.lojaweb.service.FornecedorService;

@Controller
@RequestMapping("fornecedor")
public class FornecedorController {

	@Autowired
	FornecedorService fornecedorService;
	
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("fornecedores", fornecedorService.findAll());
		return "fornecedor/list";
	}
	@GetMapping(value = {"new", "novo", "form"})
	public String form(Model model) {
		model.addAttribute("fornecedor", new Fornecedor());
		return "fornecedor/form";
	}
	
	@PostMapping
	public String save(@Valid Fornecedor fornecedor, BindingResult result,
			   Model model,
			   RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("fornecedor", fornecedor);
			return "fornecedor/form";
		}
		fornecedorService.save(fornecedor);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/fornecedor";
	}
}
