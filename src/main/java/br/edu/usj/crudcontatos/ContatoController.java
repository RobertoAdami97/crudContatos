package br.edu.usj.crudcontatos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;



@ResponseBody
@Controller
@CrossOrigin
public class ContatoController {
    
    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping(value="/")
    public List<Contato> getContatos() {
        List<Contato> listaContatos = contatoRepository.findAll();
        return listaContatos;
    }

    @GetMapping(value="/{id}")
    public Contato getContatoId(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        return contato;
    }
    
    @PostMapping(value="/cadastrar")
    public Contato postContato(Contato contato) {
        Contato cadastrarContato = contatoRepository.save(contato);        
        return cadastrarContato;
    }
    
    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }
}