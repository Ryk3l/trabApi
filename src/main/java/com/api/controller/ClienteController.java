package com.api.controller;

import com.api.entity.Cliente;
import com.api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // http://localhost:8085/clientes/listar-clientes
    @GetMapping("/listar-clientes")
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    // http://localhost:8085/clientes/salvar-cliente
    @PostMapping("/salvar-cliente")
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    // http://localhost:8085/clientes/buscar-cliente/
    @GetMapping("/buscar-cliente/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clienteService.buscarClientePorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // http://localhost:8085/clientes/atualizar-cliente/id
    @PutMapping("/atualizar-cliente/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.atualizarClientePorId(id, cliente));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // http://localhost:8085/clientes/deletar-cliente/3
    @DeleteMapping("/deletar-cliente/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletarClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}

//estrutura para envio:

//        {
//        "nome": "pedro Ryquerlme",
//        "tipoPessoa":"PF",
//        "cpfCnpj": "4214251",
//        "telefone": "5123324",
//        "email": "dwadawsadwddwa",
//        "logradouro": "dwaasdawddwadawdaw",
//        "numero": "25125",
//        "bairro": "dqwadqdwawd",
//        "cep": "dawddawwdaad"
//        }