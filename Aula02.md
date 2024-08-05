# CRUD ANDROID SQLITE
## LISTAR ALUNO
### Aula 02

---

### Listar Aluno Criar uma nova activity
- Clicar com botão direito em cima do pacote.
- `New > Activity > Empty Views Activity`
- Colocar o nome: `ListarAlunosActivity` ou o que preferir

---

### Listar Aluno Inserir um ListView
- Ir em `Legacy > ListView` e inserir o componente sobre a tela.
- Definir os atributos `layout_width` e `height` com `match constraint`
- Ancorar os pontos na tela como anteriormente, com margens = 8

---

### Classe Aluno.java

```java
public class Aluno implements Serializable {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return nome;
    }
}
```
## Classe ListarAlunosActivity.java
````java
package com.example.exemplocrud;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {
    private ListView listView;
    private AlunoDao dao;
    private List<Aluno> alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        listView = findViewById(R.id.lista_alunos);
        dao = new AlunoDao(this);
        alunos = dao.obterTodos();
        alunosFiltrados.addAll(alunos);

        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listView.setAdapter(adaptador);
    }
}
````
## Classe AlunoDao.java
````java
public class AlunoDao {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDao(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        return banco.insert("aluno", null, values);
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "nome", "cpf", "telefone"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCpf(cursor.getString(2));
            a.setTelefone(cursor.getString(3));
            alunos.add(a);
        }
        return alunos;
    }
}
````
### Alterar a Activity Principal

- Antes de rodar o projeto, mudar a activity principal para `ListarAlunosActivity`, porque a tela de cadastro irá aparecer lá, pois ela era a activity principal até o momento!
- Clicar na raiz do projeto `App > manifests > abrir AndroidManifest.xml`
- Colocar `true` na activity que queremos como principal e a tag `<intent-filter>` e seu conteúdo devem estar apenas na activity principal, na outra deve ser comentada ou apagada.

---

### Resultado ListarAlunosActivity

- Após rodar o projeto, podemos visualizar todos os nomes que foram cadastrados na etapa anterior e estão no banco de dados SQLLite.
- Porém ainda não existe controle sobre os dados cadastrados. O que será feito nas próximas etapas, junto com botões de link para a tela de cadastrar.

---

### Inserir Botões de navegação entre as activity’s

- Poderíamos colocar um botão na tela `Cadastrar` para ir ao `ListarAlunos`?
- Poderíamos colocar um botão na tela `ListarAlunos` para ir ao `Cadastrar`?
- Como poderíamos fazer isso?

Obs: Cadastrar é chamado de `MainActivity.java` no nosso projeto.

---

### Inserir Botões de navegação entre as activity’s

#### Resposta:

- Devemos inserir um botão no layout (xml) de cada tela (`MainActivity` e `ListarAlunosActivity`), ancorar ele para não ficar solto, tratar o evento `onClick` para quando o botão for clicado levar a outra tela.

#### Método:

```java
public void irParaListar(View view) {
    Intent intent = new Intent(this, ListarAlunosActivity.class);
    startActivity(intent);
}
```
### Inserir Botões de navegação entre as activity’s
- Definição de Intent no Android:
Um Intent em Android é um objeto que permite a comunicação entre diferentes componentes de uma aplicação, como atividades, serviços e broadcast receivers. Ele é usado para solicitar uma ação de outro componente, seja dentro da mesma aplicação ou de uma aplicação diferente.
#### Tipos de Intents:
1. Explicit Intent (Intent Explícito): Especifica o componente exato que deve ser chamado pela intenção. Geralmente é usado para iniciar uma atividade ou serviço dentro da própria aplicação.
```java
Intent intent = new Intent(this, ListarAlunosActivity.class);
startActivity(intent);
`````
2. Implicit Intent (Intent Implícito): Não especifica o componente exato, mas declara uma ação geral que pode ser tratada por qualquer aplicativo capaz de executar essa ação. Geralmente é usado para interagir com outros aplicativos.

````java
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com"));
startActivity(intent);
````

## Inserir Botões de navegação entre as activity’s
#### Exemplo:

- Vamos usar id=`'btnVoltar'`
- `onClick='voltarParaCadastro'`
- `Text='Voltar'`

## Verificação do Código
- Verificar se no código da `activity_listar_alunos.xml` se foi realmente alterada as ações que foram programadas.
- Fazer o mesmo processo na `activity_main.xml` e verificar o código como anteriormente.

## Inserir Método irParaListar na MainActivity.java

```java
public void irParaListar(View view) {
    Intent intent = new Intent(this, ListarAlunosActivity.class);
    startActivity(intent);
}
````

### Inserir Método na ListarAlunosActivity.java
- Agora faça o mesmo no método `ListarAlunosActivity.java`

### Configuração do AndroidManifest.xml

- Após tudo estar pronto, veja se o arquivo `AndroidManifest.xml` está configurado corretamente para executar a `MainActivity` como principal!

---

### Gerar o APK do App

Para gerar o instalador (APK) do seu aplicativo Android e compartilhá-lo com outras pessoas, você precisa seguir alguns passos no Android Studio. Aqui estão os passos detalhados para gerar um APK (modo depuração):

#### Passos para Gerar o APK no Android Studio:

1. Abra o seu projeto no Android Studio:
   - Certifique-se de que seu projeto está aberto e compilando corretamente.
2. Configure as opções de build:
   - Vá para `Build > Build Bundle(s) / APK(s) > Build APK(s)`.
   - O Android Studio começará a compilar seu projeto e gerar o APK.
3. Localize o APK:
   - Após a conclusão do build, o Android Studio exibe uma notificação no canto inferior direito.
   - Clique em `locate` para abrir o diretório onde o APK foi gerado.
   - O APK geralmente é salvo na pasta `app/build/outputs/apk/debug` para builds de debug ou `app/build/outputs/apk/release` para builds de release.

---

### Gerar APK para Release

Para gerar um APK que você pode distribuir publicamente, é melhor criar uma versão de release assinada. Aqui estão os passos para isso:

1. Configure uma Keystore:
   - Vá para `Build > Generate Signed Bundle / APK...`.
   - Escolha `APK` e clique em `Next`.
   - Selecione ou crie uma nova keystore. Uma keystore é um arquivo que contém informações de segurança e é necessário para assinar seu APK.
   - Preencha os campos necessários e clique em `Next`.

2. Configure a assinatura do APK:
   - Selecione o tipo de build (geralmente release).
   - Clique em `Finish`.

3. Build o APK:
   - O Android Studio irá gerar o APK assinado.
   - Após a conclusão, o Android Studio exibirá uma notificação. Clique em `locate` para abrir o diretório onde o APK assinado foi salvo.

---

### Exercício para a Próxima Aula

- Implementar o método excluir e atualizar, criar um botão para levar a tela do layout excluir/atualizar ou criar um botão que seleciona o item no método listar.
- Pensar numa solução e mostrar para o professor na próxima aula. Será aberto um link de exercício 02 no moodle para entregar a tarefa. Serão chamados alunos para apresentar o resultado.

---

## Referências:

- LECHETA, Ricardo R. Google Android: aprenda a criar aplicações para dispositivos móveis com o android SDK. São Paulo: Novatec, 2009.
- TALUKDER, Asoke; YAVAGAL, Roopa. Mobile computing. New Delhi - India: McGraw-Hill, 2007.
- SILVA, D. Desenvolvimento para dispositivos móveis. Pearson, 2017.
- ANDROID. Android Developers. Disponível em [Android Developers](https://developer.android.com). Acesso em agosto de 2018.
- MIKKONEN, T. Programming mobile devices: an introduction for practitioners. Chichester, England: Wiley, 2007.
- ROGERS, Rick et al. Desenvolvimento de aplicações Android. O’Reilly: Novatec, 2009.
- SILVA, D. Arquitetura para computação móvel. Pearson, 2018.
- YAVAGAL, Roopa R.; TALUKDER, Asoke K. Mobile computing: technology, applications, and service creation. New York, NY: McGraw-Hill, 2007.

---

## Thank you for your attention!!

### Contato:
- Email: andre.flores@ufn.edu.br
