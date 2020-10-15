package com.codigolimpo.controller;

import com.codigolimpo.models.dto.EnderecoDto;
import com.codigolimpo.service.impl.EnderecoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @ApiOperation(value = "Cadastrar endereço no banco de dados")
    @PostMapping
    public ResponseEntity<EnderecoDto> criar(@RequestBody EnderecoDto enderecoDto1){
        EnderecoDto enderecoDto = enderecoService.criar(enderecoDto1);
        return ResponseEntity.ok(enderecoDto);
    }

    @ApiOperation(value = "Listar endereços cadastrados no banco de dados")
    @GetMapping
    public ResponseEntity<List<EnderecoDto>> listar(){
        List<EnderecoDto> enderecosDtos = enderecoService.listar();
        return ResponseEntity.ok(enderecosDtos);
    }

    @ApiOperation(value = "Atualizar endereço no banco de dados")
    @GetMapping("/{id}")
    public EnderecoDto buscar(@PathVariable Long id){
        EnderecoDto enderecoDto = enderecoService.buscar(id);
        return enderecoDto;
    }

    @ApiOperation(value = "Atualizar endereço do banco de dados")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        enderecoService.deletar(id);
    }

    @ApiOperation(value = "Atualizar endereco no banco de dados")
    @PutMapping
    public ResponseEntity<EnderecoDto> atualizar(@RequestBody EnderecoDto enderecoDto){
        EnderecoDto enderecoDto1 = enderecoService.atualizar(enderecoDto);
        return ResponseEntity.ok(enderecoDto1);
    }

}
