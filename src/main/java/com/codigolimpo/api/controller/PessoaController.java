package com.codigolimpo.api.controller;


import com.codigolimpo.api.dto.pessoa.PessoaRequestDto;
import com.codigolimpo.api.dto.pessoa.PessoaResponseDto;
import com.codigolimpo.domain.service.impl.PessoaServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaServiceImpl pessoaService;

    @ApiOperation(value = "Cadastrar pessoa no banco de dados")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponseDto criar(@RequestBody final PessoaRequestDto dto) {
        return pessoaService.criar(dto);
    }

    @ApiOperation(value = "Listar pessoas cadastradas no banco de dados")
    @GetMapping
    public ResponseEntity<List<PessoaResponseDto>> listar() {
        return ResponseEntity.ok(pessoaService.listar());
    }

    @ApiOperation(value = "Consultar pessoa do banco de dados")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PessoaResponseDto buscar(@PathVariable final Long id) {
        return pessoaService.buscar(id);
    }

    @ApiOperation(value = "Deletar pessoa do banco de dados")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable final Long id) {
        pessoaService.deletar(id);
    }

    @ApiOperation(value = "Atualizar pessoa no banco de dados")
    @PutMapping
    public ResponseEntity<PessoaResponseDto> atualizar(@RequestBody final PessoaRequestDto pessoaRequestDto) {
        return ResponseEntity.ok(pessoaService.atualizar(pessoaRequestDto));
    }

    @ApiOperation(value = "Adicionar pessoa a um endereço")
    @PatchMapping("/{idpessoa}/add/{idendereco}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PessoaResponseDto adicionarEndereco(@PathVariable("idpessoa") final Long idPessoa, final @PathVariable("idendereco") Long idEndereco) {
        return pessoaService.adicionarEndereco(idPessoa, idEndereco);
    }

    @ApiOperation(value = "Deletar endereço")
    @PatchMapping("/{idpessoa}/remove/{idendereco}")
    public ResponseEntity<PessoaResponseDto> deletarEndereco(@PathVariable("idpessoa") final Long idPessoa, final @PathVariable("idendereco") Long idEndereco) {
        return ResponseEntity.ok(pessoaService.removerEndereco(idEndereco, idPessoa));
    }
}
