package br.com.contato;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContatosControle {
	
	private final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	
	
	public  ArrayList<Contato> getListaContatos() {
		return LISTA_CONTATOS;
	}
	
	public ArrayList<Contato> getLISTA_CONTATOS() {
		return LISTA_CONTATOS;
	}


//	static {
//		Contato contato = new Contato();
//		contato.setId("1");
//		contato.setNome("Vanessa");
//		contato.setTelefone("81989426772");
//		Contato contato2 = new Contato();
//		contato2.setId("2");
//		contato2.setNome("Domingos");
//		contato2.setTelefone("81989426772");
//		Contato contato3 = new Contato();
//		contato3.setId("3");
//		contato3.setNome("Luka");
//		contato3.setTelefone("81989426772");
//		Contato contato4 = new Contato();
//		contato4.setId("4");
//		contato4.setNome("Reika");
//		contato4.setTelefone("81989426772");
//		LISTA_CONTATOS.add(contato);
//		LISTA_CONTATOS.add(contato2);
//		LISTA_CONTATOS.add(contato3);
//		LISTA_CONTATOS.add(contato4);
//	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contatos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listar");
		
		modelAndView.addObject("contatos", LISTA_CONTATOS);
		
		return modelAndView;
	}
	
	@GetMapping("/contatos/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		
		modelAndView.addObject("contato", new Contato());
		
		return modelAndView;
	}	
	
	@PostMapping("/contatos")
	public String cadastrar(Contato contato) {
		String id = UUID.randomUUID().toString();
		
		contato.setId(id);
		
		LISTA_CONTATOS.add(contato);
		return "redirect:/contatos";
	}
	
	@GetMapping("/contatos/{id}/editar")
	public ModelAndView editar(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("formulario");
		
		Contato contato = procurarContato(id);
		
		modelAndView.addObject("contato", contato);
		
		return modelAndView;
	}
	
	@PutMapping("/contatos/{id}")
	public String atualizar(Contato contato) {
		Integer indice = procurarIndiceContato(contato.getId());
		
		Contato contatoVelho = LISTA_CONTATOS.get(indice);
		
		LISTA_CONTATOS.remove(contatoVelho);
		LISTA_CONTATOS.add(indice, contato);
		return "redirect:/contatos";
	}
	
	
	@DeleteMapping("/contatos/{id}")
	public String remover(@PathVariable String id) {
		Contato contato = procurarContato(id);
		LISTA_CONTATOS.remove(contato);
		return "redirect:/contatos";
	}
	
	// -------------------------------------- Métodos auxiliares
	
	private Contato procurarContato(String id) {
		Integer indice = procurarIndiceContato(id);
		
		if (indice != null) {
			Contato contato = LISTA_CONTATOS.get(indice);
			return contato;
		}
		
		return null;
	}
	
	private Integer procurarIndiceContato(String id) {
		for (int i = 0; i < LISTA_CONTATOS.size(); i++) {
			Contato contato = LISTA_CONTATOS.get(i);
			
			if (contato.getId().equals(id)) {
				return i;
			}
		}
		
		return null;
	}
	
}

	
	
	
