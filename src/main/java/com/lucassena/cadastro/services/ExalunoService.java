package com.lucassena.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucassena.cadastro.dto.ExalunoDTO;
import com.lucassena.cadastro.dto.ExalunoMinDTO;
import com.lucassena.cadastro.entities.Exaluno;
import com.lucassena.cadastro.repositories.ExalunoRepository;

@Service
public class ExalunoService {

  @Autowired
  private ExalunoRepository exalunoRepository;

  // Método que retorna um ExalunoDTO pelo nunQuadro
  @Transactional(readOnly = true)
  public ExalunoDTO findByNunQuadro(Integer nunQuadro) {
    Exaluno result = exalunoRepository.findByNunQuadro(nunQuadro);
    ExalunoDTO dto = new ExalunoDTO(result);
    return dto;
  }

  @Transactional(readOnly = true)
  public ExalunoDTO findById(Long id) {
    Exaluno result = exalunoRepository.findById(id).get();
    ExalunoDTO dto = new ExalunoDTO(result);
    return dto;
  }

  @Transactional(readOnly = true)
  public List<ExalunoMinDTO> findAll() {
    List<Exaluno> result = exalunoRepository.findAll();
    List<ExalunoMinDTO> dto = result.stream().map(x -> new ExalunoMinDTO(x)).toList();
    return dto;

  }
}
