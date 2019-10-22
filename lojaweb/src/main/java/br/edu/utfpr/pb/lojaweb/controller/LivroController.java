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

import br.edu.utfpr.pb.lojaweb.model.Livro;
import br.edu.utfpr.pb.lojaweb.service.AssuntoService;
import br.edu.utfpr.pb.lojaweb.service.EditoraService;
import br.edu.utfpr.pb.lojaweb.service.LivroService;

@Controller
@RequestMapping("livro")
public class LivroController {

	
	@Autowired
	private EditoraService editoraService;
	@Autowired
	private AssuntoService assuntoService;
	@Autowired
	private LivroService livroService;
	
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("livros", livroService.findAll());
		return "livro/list";
	}
	
	@GetMapping(value = {"new", "novo", "form"})
	public String form(Model model) {
		model.addAttribute("livro", new Livro());
		carregarCombos(model);
		return "livro/form";
	}
	
	@GetMapping(value = {"json"})
	@ResponseBody
	public List<Livro> livroJson() {
		return livroService.findAll();
	}
	
	@PostMapping
	public String save(@Valid Livro livro, BindingResult result,
			   Model model,
			   RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("livro", livro);
			return "livro/form";
		}
		livroService.save(livro);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/livro";
	}

	private void carregarCombos(Model model) {
		model.addAttribute("editoras",
				editoraService.findAll() );
		model.addAttribute("assuntos",
				assuntoService.findAll() );		
	}
	
	@GetMapping("{id}")
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("livro", livroService.findOne(id));
		carregarCombos(model);
		return "livro/form";
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id,
						 RedirectAttributes attributes) {
		try {
			livroService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
