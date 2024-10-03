# Aula 09 - Persistência de Dados com Room

**Professor**: Dr. André Flores dos Santos  
Santa Maria – RS, 2024

---

## Introdução

- **Room**: É uma biblioteca de persistência de dados que faz parte do Android Jetpack.
  - Facilita a manipulação de dados locais no SQLite de forma mais segura e eficiente.
  - Abstrai detalhes complexos de trabalhar com SQL, oferecendo uma interface amigável.

### Componentes do Room:
1. **Entity**: Representa uma tabela no banco de dados.
2. **DAO (Data Access Object)**: Interface que contém métodos para acessar o banco de dados.
3. **Database**: Classe principal que mantém a conexão com o banco de dados e atua como o ponto central para o acesso aos dados persistidos.

---

## Estrutura de uma Entity

```java
@Entity(tableName = "usuarios")
public class Usuario {
  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "nome")
  private String nome;

  @ColumnInfo(name = "email")
  private String email;

  // Getters e Setters...
}
```
- Cada campo da classe representa uma coluna no banco de dados.
- @PrimaryKey define o campo como chave primária.
- @ColumnInfo define detalhes das colunas.

### Definindo o DAO

```java
@Dao
public interface UsuarioDao {

  @Insert
  void inserirUsuario(Usuario usuario);

  @Query("SELECT * FROM usuarios")
  List<Usuario> obterTodosUsuarios();
}
```
**@Insert**: Usado para inserção de dados.
**@Query**: Executa consultas personalizadas no banco de dados.

### Configurando o Database
```java
@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract UsuarioDao usuarioDao();
}
```
- @Database define a classe que será usada como ponto de acesso ao banco de dados, especificando as entidades (tabelas) e a versão do banco.

### Inicializando o Room no App

```java
AppDatabase db = Room.databaseBuilder(getApplicationContext(),
    AppDatabase.class, "banco-de-dados")
    .allowMainThreadQueries() // Evitar em produção
    .build();

UsuarioDao usuarioDao = db.usuarioDao();
```
`Room.databaseBuilder:` Cria uma instância do banco de dados.
`allowMainThreadQueries:` Permite execução no thread principal (não recomendado em produção).

### Exemplo de Inserção e Obtenção de Dados

```java
Usuario novoUsuario = new Usuario();
novoUsuario.setNome("João");
novoUsuario.setEmail("joao@example.com");
usuarioDao.inserirUsuario(novoUsuario);

List<Usuario> listaUsuarios = usuarioDao.obterTodosUsuarios();
for (Usuario usuario : listaUsuarios) {
  Log.d("Usuario", "Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail());
}
```
### Alterando o Projeto para Usar Room

```java
@Entity(tableName = "aluno")
public class Aluno implements Serializable {

  @PrimaryKey(autoGenerate = true)
  private Integer id;

  @ColumnInfo(name = "nome")
  private String nome;

  @ColumnInfo(name = "cpf")
  private String cpf;

  @ColumnInfo(name = "telefone")
  private String telefone;

  @ColumnInfo(name = "foto")
  private byte[] fotoBytes;

  // Getters e Setters...
}
```
- **@Entity**: Define a tabela no banco de dados.
- **@PrimaryKey**: Define a chave primária com auto-incremento.

### Definindo o AlunoDao

```java
@Dao
public interface AlunoDao {

  @Insert
  long inserir(Aluno aluno);

  @Update
  void atualizar(Aluno aluno);

  @Query("SELECT * FROM alunos")
  List<Aluno> obterTodos();

  @Delete
  void excluir(Aluno aluno);

  @Query("SELECT COUNT(*) FROM alunos WHERE cpf = :cpf")
  int cpfExistente(String cpf);
}
```

### Criando a Classe Database
```java
@Database(entities = {Aluno.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract AlunoDao alunoDao();

  private static AppDatabase INSTANCE;

  public static AppDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          AppDatabase.class, "banco-de-alunos")
          .allowMainThreadQueries()
          .build();
    }
    return INSTANCE;
  }
}
```
### Utilizando o Room

```java
AppDatabase db = AppDatabase.getInstance(context);
AlunoDao alunoDao = db.alunoDao();

Aluno novoAluno = new Aluno();
novoAluno.setNome("Maria");
novoAluno.setCpf("12345678900");
novoAluno.setTelefone("999999999");

long id = alunoDao.inserir(novoAluno);

List<Aluno> alunos = alunoDao.obterTodos();
for (Aluno aluno : alunos) {
  Log.d("Aluno", "Nome: " + aluno.getNome() + ", CPF: " + aluno.getCpf());
}
```

### Dependências do Room

```java
dependencies {
  implementation 'androidx.room:room-runtime:2.5.2'
  annotationProcessor 'androidx.room:room-compiler:2.5.2'
  implementation 'androidx.room:room-ktx:2.5.2'
  implementation 'androidx.room:room-rxjava2:2.5.2'
}
```

### Referências

- Lecheta, Ricardo R. *Google Android: Aprenda a Criar Aplicações para Dispositivos Móveis com o Android SDK*. Novatec, 2009.
- Talukder, Asoke; Yavagal, Roopa. *Mobile Computing*. McGraw-Hill, 2007.
- Silva, D. *Desenvolvimento para Dispositivos Móveis*. Pearson, 2017.
- Android Developers. Disponível em: [https://developer.android.com](https://developer.android.com).

---

**Contato**:  
Email: andre.flores@ufn.edu.br
