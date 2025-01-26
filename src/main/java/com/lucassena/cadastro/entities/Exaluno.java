package com.lucassena.cadastro.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta classe é uma entidade JPA que será mapeada para uma tabela do
        // banco de dados.
@Table(name = "tb_exaluno") // Especifica o nome da tabela no banco de dados.
public class Exaluno {

  @Id // Indica que este campo é a chave primária da tabela.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o valor do campo deve ser gerado automaticamente
                                                      // pelo banco de dados.
  private Long id;
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

  public Exaluno() {
  }

  public Exaluno(Long id, Integer nunQuadro, Integer anoFormatura, String nome, String apelido, String curso,
      String cidade, String estado, String cep, String telefone, String eMail, String empresaTrabalha,
      String ultimaAtualizacao) {
    this.id = id;
    this.nunQuadro = nunQuadro;
    this.anoFormatura = anoFormatura;
    this.nome = nome;
    this.apelido = apelido;
    this.curso = curso;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
    this.telefone = telefone;
    this.eMail = eMail;
    this.empresaTrabalha = empresaTrabalha;
    this.ultimaAtualizacao = ultimaAtualizacao;
  }

  // Getters e setters...
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(nunQuadro);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Exaluno other = (Exaluno) obj;
    return Objects.equals(nunQuadro, other.nunQuadro);
  }
}