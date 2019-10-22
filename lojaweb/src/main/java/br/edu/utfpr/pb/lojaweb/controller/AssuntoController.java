package br.edu.utfpr.pb.lojaweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.lojaweb.model.Assunto;
import br.edu.utfpr.pb.lojaweb.service.AssuntoService;
import br.edu.utfpr.pb.lojaweb.service.CategoriaService;

@Controller
@RequestMapping("assunto")
public class AssuntoController {

	
	@Autowired
	private AssuntoService assuntoService;
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("assuntos", assuntoService.findAll());
		return "assunto/list";
	}
	
	@GetMapping(value = {"json"})
	@ResponseBody
	public List<Assunto> assuntoJson() {
		return assuntoService.findAll();
	}
	
	@GetMapping(value = {"new", "novo", "form"})
	public String form(Model model) {
		model.addAttribute("assunto", new Assunto());
		carregarCombos(model);
		return "assunto/form";
	}

	
	@PostMapping
	public String save(@Valid Assunto assunto, BindingResult result,
			   Model model,
			   RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("assunto", assunto);
			return "assunto/form";
		}
		assuntoService.save(assunto);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/assunto";
	}
	private void carregarCombos(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());		
	}
	
	
	@GetMapping("{id}")
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("assunto", assuntoService.findOne(id));
		carregarCombos(model);
		return "assunto/form";
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id,
						 RedirectAttributes attributes) {
		try {
			assuntoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
