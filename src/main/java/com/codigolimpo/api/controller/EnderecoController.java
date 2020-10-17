package com.codigolimpo.api.controller;

import com.codigolimpo.api.dto.EnderecoDto;
import com.codigolimpo.domain.service.impl.EnderecoServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoServiceImpl enderecoService;

    @ApiOperation(value = "Cadastrar endereço no banco de dados")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDto criar(@RequestBody final EnderecoDto dto){
        return enderecoService.criar(dto);
    }

    @ApiOperation(value = "Listar endereços cadastrados no banco de dados")
    @GetMapping
    public ResponseEntity<List<EnderecoDto>> listar(){
        return ResponseEntity.ok(enderecoService.listar());
    }

    @ApiOperation(value = "Atualizar endereço no banco de dados")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EnderecoDto buscar(@PathVariable final Long id){
        return enderecoService.buscar(id);
    }

    @ApiOperation(value = "Atualizar endereço do banco de dados")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable final Long id){
        enderecoService.deletar(id);
    }

    @ApiOperation(value = "Atualizar endereco no banco de dados")
    @PutMapping
    public ResponseEntity<EnderecoDto> atualizar(@RequestBody final EnderecoDto enderecoDto){
        return ResponseEntity.ok(enderecoService.atualizar(enderecoDto));
    }
}
