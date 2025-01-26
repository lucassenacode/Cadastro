package com.lucassena.cadastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassena.cadastro.dto.ExalunoMinDTO;
import com.lucassena.cadastro.services.ExalunoService;

@RestController // Indica que esta classe é um controlador REST do Spring
@RequestMapping(value = "exaluno") // Define o mapeamento base para todas as requisições deste controlador
public class ExalunoController {

  @Autowired // Injeta a dependência do serviço ExalunoService
  private ExalunoService exalunoService;

  @GetMapping // Mapeia requisições HTTP GET para este método
  public List<ExalunoMinDTO> findAll() {
    List<ExalunoMinDTO> result = exalunoService.findAll(); // Chama o serviço para buscar todos os ex-alunos
    return result; // Retorna a lista de ex-alunos como resposta
  }
}