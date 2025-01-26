

# Projeto ExAluno

## Descrição
Projeto para cadastro de ex-alunos da República, utilizando Spring Boot, banco de dados H2 para testes, e PostgreSQL para produção. Este projeto implementa uma API REST com CRUD básico para gerenciar informações de ex-alunos.

---

## Sumário
1. [Configuração do Spring Initializr](#configuração-do-spring-initializr)
2. [Configuração do Maven](#configuração-do-maven)
3. [Conexão com Git](#conexão-com-git)
4. [Configuração de Perfis](#configuração-de-perfis)
5. [Modelagem da Entidade](#modelagem-da-entidade)
6. [Banco de Dados e Seeds](#banco-de-dados-e-seeds)
7. [Arquitetura e Camadas](#arquitetura-e-camadas)
8. [Testando a API](#testando-a-api)
9. [Preparando o Ambiente com Docker](#preparando-o-ambiente-com-docker)
10. [Possíveis Melhorias Futuras](#possíveis-melhorias-futuras)

---

## Configuração do Spring Initializr
1. Acesse [Spring Initializr](https://start.spring.io/).
2. Configure o projeto com os seguintes detalhes:
   - **Tipo**: Maven Project
   - **Linguagem**: Java
   - **Versão do Spring Boot**: 3.4.2
   - **Grupo**: `com.lucassena`
   - **Artifact**: `exaluno`
   - **Nome**: `ExAluno`
   - **Descrição**: Projeto para os cadastros de ex-alunos da República
   - **Dependências**:
     - Spring Web
     - Spring Data JPA
     - H2 Database
     - PostgreSQL Driver
3. Clique em "Generate" para baixar o projeto. Extraia o arquivo gerado e abra na sua IDE preferida (Eclipse, IntelliJ, ou outra).

**Nota:** Você pode acessar diretamente a configuração com o seguinte link: [Spring Initializr - ExAluno](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.4.2&packaging=jar&jvmVersion=21&groupId=com.lucassena&artifactId=exaluno&name=exaluno&description=projeto%20para%20os%20cadastro%20de%20ex-alunos%20da%20rep%C3%BAblica&packageName=com.lucassena.exaluno&dependencies=web,data-jpa,h2,postgresql).

---

## Configuração do Maven
Para evitar incompatibilidades no Maven, adicione o seguinte plug-in no arquivo `pom.xml`:

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version>
</plugin>
```

Esse plug-in garante que os recursos serão processados corretamente durante o build.

---

## Conexão com Git
1. Crie um repositório no GitHub com o nome `ExAluno`.
2. Inicialize o repositório localmente e conecte-o ao repositório remoto:
   ```bash
   git init
   git remote add origin <url-do-repositorio>
   git add .
   git commit -m "Inicialização do projeto ExAluno"
   git push -u origin main
   ```
3. Certifique-se de criar um `.gitignore` para ignorar arquivos desnecessários, como os da pasta `target/`:
   ```
   target/
   *.log
   *.iml
   .idea/
   .classpath
   .project
   .settings/
   ```

---

## Configuração de Perfis
A aplicação suporta diferentes perfis para ambientes de desenvolvimento, teste e produção. As configurações são gerenciadas em arquivos `application-{profile}.properties`.

### `application.properties`
Configure o perfil padrão e algumas variáveis genéricas:
```properties
spring.application.name=exaluno
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false
cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```

### `application-test.properties`
Configuração para testes locais com H2:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### `application-dev.properties`
Configuração para ambiente de desenvolvimento com PostgreSQL:
```properties
spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
spring.datasource.url=jdbc:postgresql://localhost:5433/exaluno
spring.datasource.username=postgres
spring.datasource.password=1234567
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none
```

### `application-prod.properties`
Configuração para ambiente de produção:
```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none
```

### Arquivo `system.properties`
Adicione na raiz do projeto para compatibilidade com algumas plataformas de deploy:
```properties
java.runtime.version=21
```

---

## Modelagem da Entidade
A entidade `ExAluno` representa os ex-alunos no sistema. O código abaixo define a estrutura da entidade:

```java
@Entity
@Table(name = "tb_exaluno")
public class Exaluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Getters e Setters
}
```

---

## Banco de Dados e Seeds
O arquivo `import.sql` é utilizado para popular o banco de dados H2 com dados iniciais:

### `src/main/resources/import.sql`
```sql
INSERT INTO tb_exaluno (nun_quadro, ano_formatura, nome, apelido, curso, cidade, estado, cep, telefone, e_mail, empresa_trabalha, ultima_atualizacao)
VALUES (1, 2010, 'Lucas Silva', 'Lu', 'Engenharia', 'São Paulo', 'SP', '01000-000', '(11) 99999-9999', 'lucas.silva@example.com', 'Empresa A', '2025-01-01');
```
Execute a aplicação e acesse o console H2 em `http://localhost:8080/h2-console`.

---

## Arquitetura e Camadas
Segue a arquitetura em camadas para organização do código:

### Camada DTO (Data Transfer Object)
Local: `src/main/java/com/lucassena/cadastro/dto/ExalunoMinDTO.java`
```java
public class ExalunoMinDTO {
    private Long id;
    private String nome;
    private String curso;

    public ExalunoMinDTO(Exaluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.curso = entity.getCurso();
    }
}
```

### Camada Repositório
Local: `src/main/java/com/lucassena/cadastro/repositories/ExalunoRepository.java`
```java
public interface ExalunoRepository extends JpaRepository<Exaluno, Long> {
}
```

### Camada de Serviço
Local: `src/main/java/com/lucassena/cadastro/services/ExalunoService.java`
```java
@Service
public class ExalunoService {
    @Autowired
    private ExalunoRepository repository;

    public List<ExalunoMinDTO> findAll() {
        return repository.findAll().stream()
            .map(ExalunoMinDTO::new)
            .collect(Collectors.toList());
    }
}
```

### Camada Controller
Local: `src/main/java/com/lucassena/cadastro/controllers/ExalunoController.java`
```java
@RestController
@RequestMapping("/exaluno")
public class ExalunoController {
    @Autowired
    private ExalunoService service;

    @GetMapping
    public List<ExalunoMinDTO> findAll() {
        return service.findAll();
    }
}
```

---

## Preparando o Ambiente com Docker
1. **Inicie o Docker Desktop** e certifique-se de que está funcionando.
2. **Suba o container** usando o `docker-compose.yml`:
   - Navegue até a pasta do arquivo:
     ```bash
     cd "C:\Users\temaj\Desktop\lucas\projetos java\ZZdocker compose"
     ```
   - Execute o comando:
     ```bash
     docker-compose up -d
     ```
3. **Acesse o pgAdmin** em `http://localhost:5050/`.

### Perfil de Desenvolvimento e Produção
Configurações detalhadas nos arquivos `application-dev.properties` e `application-prod.properties` estão descritas acima. Certifique-se de:
- Criar o banco de dados `exaluno` no pgAdmin.
- Rodar o script gerado pelo `create.sql` no ambiente desejado.

---

## Testando a API
Use o Postman ou outra ferramenta para testar os endpoints.

- **Endpoint para buscar todos os ex-alunos:**
  - **Método:** `GET`
  - **URL:** `http://localhost:8080/exaluno`

---

