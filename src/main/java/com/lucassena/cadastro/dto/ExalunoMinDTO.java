package com.lucassena.cadastro.dto;

import com.lucassena.cadastro.entities.Exaluno;

public class ExalunoMinDTO {

  private Long id;
  private Integer nunQuadro;
  private Integer anoFormatura;
  private String nome;
  private String apelido;
  private String curso;

  // Construtor padrão
  public ExalunoMinDTO() {
  }

  // Construtor que inicializa o DTO com a entidade Exaluno
  public ExalunoMinDTO(Exaluno entity) {
    this.id = entity.getId();
    this.nunQuadro = entity.getNunQuadro();
    this.anoFormatura = entity.getAnoFormatura();
    this.nome = entity.getNome();
    this.apelido = entity.getApelido();
    this.curso = entity.getCurso();
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Integer getNunQuadro() {
    return nunQuadro;
  }

  public Integer getAnoFormatura() {
    return anoFormatura;
  }

  public String getNome() {
    return nome;
  }

  public String getApelido() {
    return apelido;
  }

  public String getCurso() {
    return curso;
  }
}