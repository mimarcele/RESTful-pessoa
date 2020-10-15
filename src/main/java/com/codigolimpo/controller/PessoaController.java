package com.codigolimpo.controller;

import com.codigolimpo.models.dto.PessoaDto;
import com.codigolimpo.service.impl.PessoaServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaService;

    @ApiOperation(value = "Cadastrar pessoa no banco de dados")
    @PostMapping
    public ResponseEntity<PessoaDto> criar(@RequestBody PessoaDto pessoaDto1){
    PessoaDto pessoaDto = pessoaService.criar(pessoaDto1);
    return ResponseEntity.ok(pessoaDto);
    }

    @ApiOperation(value = "Listar pessoas cadastradas no banco de dados")
    @GetMapping
    public ResponseEntity<List<PessoaDto>> listar(){
    List<PessoaDto> pessoas = pessoaService.listar();
    return ResponseEntity.ok(pessoas);
    }

    @ApiOperation(value = "Consultar pessoa do banco de dados")
    @GetMapping("/{id}")
    public PessoaDto consultar(@PathVariable Long id){
       PessoaDto pessoa = pessoaService.buscar(id);
       return pessoa;
    }

    @ApiOperation(value = "Deletar pessoa do banco de dados")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
     pessoaService.deletar(id);

    }

    @ApiOperation(value = "Atualizar pessoa no banco de dados")
    @PutMapping
    public ResponseEntity<PessoaDto> atualizar(@RequestBody PessoaDto pessoaDto){
        PessoaDto pessoaDto1 = pessoaService.atualizar(pessoaDto);
        return ResponseEntity.ok(pessoaDto1);
    }

    @ApiOperation(value = "Adicionar pessoa a um endereço")
    @PatchMapping("/{idpessoa}/add/{idendereco}")
    public ResponseEntity<PessoaDto> adicionarEndereco(@PathVariable Long idpessoa, @PathVariable Long idendereco){
        PessoaDto pessoaDto = pessoaService.adicionarEndereco(idpessoa, idendereco);
        return ResponseEntity.ok(pessoaDto);
    }

    @ApiOperation(value = "Deletar endereço")
    @PatchMapping("/{idpessoa}/remove/{idendereco}")
    public ResponseEntity<PessoaDto> deletarEndereco(@PathVariable Long idendereco, @PathVariable Long idpessoa){
        PessoaDto pessoaDto = pessoaService.removerEndereco(idendereco, idpessoa);
        return ResponseEntity.ok(pessoaDto);
    }
}
