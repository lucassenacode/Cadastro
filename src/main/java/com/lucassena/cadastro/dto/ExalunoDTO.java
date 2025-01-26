package com.lucassena.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.lucassena.cadastro.entities.Exaluno;

public class ExalunoDTO {

  private Integer nunQuadro;
  private Integer anoFormatura;
  private String nome;
  private String apelido;
  private String curso;
  private String cidade;
  private String estado;
  private String cep;
  private String telefone;
  private String eMail;
  private String empresaTrabalha;
  private String ultimaAtualizacao;

  // Construtor padrão
  public ExalunoDTO() {
  }

  // Construtor que inicializa o DTO com a entidade Exaluno
  public ExalunoDTO(Exaluno entity) {
    BeanUtils.copyProperties(entity, this);
  }

  // Getters e Setters
  public Integer getNunQuadro() {
    return nunQuadro;
  }

  public void setNunQuadro(Integer nunQuadro) {
    this.nunQuadro = nunQuadro;
  }

  public Integer getAnoFormatura() {
    return anoFormatura;
  }

  public void setAnoFormatura(Integer anoFormatura) {
    this.anoFormatura = anoFormatura;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public String getEmpresaTrabalha() {
    return empresaTrabalha;
  }

  public void setEmpresaTrabalha(String empresaTrabalha) {
    this.empresaTrabalha = empresaTrabalha;
  }

  public String getUltimaAtualizacao() {
    return ultimaAtualizacao;
  }

  public void setUltimaAtualizacao(String ultimaAtualizacao) {
    this.ultimaAtualizacao = ultimaAtualizacao;
  }
}