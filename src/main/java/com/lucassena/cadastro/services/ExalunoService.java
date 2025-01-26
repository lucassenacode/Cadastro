package com.lucassena.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassena.cadastro.dto.ExalunoMinDTO;
import com.lucassena.cadastro.entities.Exaluno;
import com.lucassena.cadastro.repositories.ExalunoRepository;

@Service
public class ExalunoService {

  @Autowired
  private ExalunoRepository exalunoRepository;

  public List<ExalunoMinDTO> findAll() {
    List<Exaluno> result = exalunoRepository.findAll();
    List<ExalunoMinDTO> dto = result.stream().map(x -> new ExalunoMinDTO(x)).toList();
    return dto;

  }
}
