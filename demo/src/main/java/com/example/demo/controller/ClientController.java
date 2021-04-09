package com.example.demo.controller;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private int count = 0;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar (){
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        count++;
        return clienteRepository.save(cliente);
    }

    @RequestMapping("/id")
    @GetMapping
    public ResponseEntity buscar(@RequestParam Long id){
        id = Objects.requireNonNull(id);
        if(id>0 && id<=count) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteRepository.findById(id));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existente");
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void remover(@RequestBody Cliente cliente){
        count--;
        clienteRepository.delete(cliente);
    }
}
