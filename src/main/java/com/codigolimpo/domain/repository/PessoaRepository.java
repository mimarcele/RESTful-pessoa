package com.codigolimpo.domain.repository;

import com.codigolimpo.api.dto.pessoa.PessoaRequestDto;
import com.codigolimpo.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
