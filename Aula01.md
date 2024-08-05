# CIÊNCIA DA COMPUTAÇÃO
## ANDROID
### TÓPICOS AVANÇADOS II
#### Aula 01

---

## Apresentação sobre Android

Bem-vindo a esta apresentação sobre o sistema operacional Android, uma plataforma móvel líder no mercado mundial. Vamos explorar sua história, evolução, ferramentas de desenvolvimento e recursos essenciais para construir aplicativos extraordinários.

---

## Unidade 1 - Introdução ao Desenvolvimento Android

### 1. Início do Android
Conheça as origens do Android, desde sua criação pela empresa Open Handset Alliance em 2003 até sua aquisição pela Google em 2005.

### 2. Evolução Constante
Acompanhe as versões do Android, desde o lançamento do Android 1.0 em 2008 até as atualizações mais recentes, observando as inovações e melhorias ao longo dos anos.

### 3. Adoção em Larga Escala
Entenda como o Android se tornou o sistema operacional móvel dominante, alcançando uma participação de mercado global de mais de 70%.

---

## História e Evolução do Android

### 1. Origem e Aquisição
O Android foi criado em 2003 pela empresa Android Inc. e adquirido pela Google em 2005, tornando-se a base do sistema operacional móvel mais usado no mundo.

### 2. Versões e Atualizações
Desde seu lançamento inicial em 2008, o Android recebeu constantes atualizações, cada uma trazendo novos recursos, melhorias de desempenho e uma experiência mais refinada.

### 3. Adoção em Larga Escala
Graças à sua natureza open-source e ao suporte de fabricantes de smartphones, o Android alcançou uma participação de mercado impressionante, se tornando o sistema operacional móvel dominante.

---

## Ferramentas de Desenvolvimento

- Nas versões mais recentes do SDK, a IDE recomendada para o desenvolvimento de aplicativos móveis para o sistema operacional Android é o Android Studio.
- O Android Studio contempla todas as ferramentas necessárias, tais como:
  - Android Studio IDE;
  - Android SDK;
  - Plataforma Android;
  - Emulador para Android com Google APIs.

---

## Instalação e Configuração do Android Studio

### Baixe o Android Studio
Visite o site oficial do Android Developers e faça o download da última versão estável do Android Studio, a principal ferramenta de desenvolvimento para a plataforma Android.

### Instale e Configure
Siga as instruções de instalação para o seu sistema operacional e configure o Android Studio com os SDKs, emuladores e outras ferramentas necessárias.

### Atualize Regularmente
Mantenha o Android Studio atualizado para ter acesso às últimas melhorias, correções de bugs e suporte para novas versões do Android.

---

## Requisitos de Sistema

- O computador deve ter o JDK 16 ou superior instalado para nossas aulas, pois apenas o JRE não é suficiente.
  - Link: [Download do JDK](https://www.oracle.com/java/technologies/downloads/?er=221886)

- Download do Android Studio para Windows:
  - [Android Studio](https://developer.android.com/studio?hl=pt-br)

Este pacote já contém todas as ferramentas necessárias.

---

## Configuração do SDK

O Android Studio vem preparado com o SDK de desenvolvimento para a versão 14.0 do Android ou também Android API 34. Caso desejem trabalhar com uma versão anterior (mais leve), clique em: `Tools > SDK Manager`.

---

## Device Manager

No Device Manager escolhemos qual aparelho e qual Android escolheremos para rodar no emulador e testar o App. Podemos conectar o cabo USB do nosso celular e testar o app diretamente nele (não indicado em fase de testes porque talvez seja necessário ficar instalando e desinstalando o app, ou alterando o banco de dados).

---

## Estrutura de um Projeto Android

### 1. Manifesto
O arquivo `AndroidManifest.xml` define as principais características do seu aplicativo, como permissões, atividades e serviços.

### 2. Código-fonte
O diretório `/src` contém os arquivos Java ou Kotlin que implementam a lógica do seu aplicativo.

### 3. Recursos
O diretório `/res` armazena os recursos estáticos, como layouts, imagens, strings e arquivos de configuração.

### 4. Dependências
O arquivo `build.gradle` configura as dependências e bibliotecas utilizadas no seu projeto.

---

## Android Studio

### Área de Desenvolvimento
### Área de Projetos

---

## Criação de Projeto Android

### Criar Projeto Novo

Após a criação do projeto, devemos clicar na raiz do projeto `app > res > layout > activity_main.xml` (ou o nome que for definido para o arquivo de atividade principal).

Existem 3 opções para exibir o layout:
- Code (código)
- Split
- Design (visual gráfico)

Na opção gráfica podemos arrastar diferentes tipos de objetos de texto e botões para a tela.

---

## Criar Layout

### Opções de Layout

Existem 3 opções para exibir o layout:
- Code (código)
- Split
- Design (visual gráfico)

---

## Criar Layout

Neste Layout usamos:
- 3 Text > TextView (Nome, CPF, Telefone)
- 3 Text > Plain Text (campo de texto em branco)
- 1 Buttons > button

Essas opções ficam abertas à esquerda do layout na parte `Design` ou visual.

Para mudar o texto dentro dos objetos, primeiro selecionamos eles e depois vamos em `Attributes > Common attributes > Text` e mudamos para o valor que queremos.

---

## Ancoragem dos Componentes com a Tela Layout

---

## Criar Nova Classe

Clicar com o botão direito em cima do nosso projeto `app > java > com.example.exemplocrud1` (ou no nome que foi definido para o pacote). Escolher `New > Java Class` e dar o nome para a classe desejada.

Iremos criar as seguintes classes:
- MainActivity (já criada, p cadastrar)
- Aluno.java
- Conexao.java
- AlunoDao.java
- ListarAlunos.java

---

## Classe Aluno

O aluno terá os seguintes campos: Id, nome, cpf, telefone.

Se houver problemas com bibliotecas, o texto ficará vermelho. Para resolver, devemos parar o mouse em cima e abrirá uma opção `import class`. Após clicar nessa opção, o problema é resolvido e a biblioteca é importada.

---

## Classe Aluno

Mandar gerar getter and setter automaticamente, clicando com o botão direito dentro do código. Opção `generate > getter and setter`, e marcar todos os campos. Deverá ficar como a tela ao lado.

---

## Classe Aluno DAO

---

## Classe Conexao

---

## Classe MainActivity

---

## Activity_main.xml

Devemos configurar o botão `salvar` para o evento `onClick`, então ele irá executar o método `salvar` da `MainActivity` quando for clicado. Editamos esse campo dentro do arquivo `res > activity_main.xml`.

---

## Testar o App no Emulador

Clicar no ícone de `Play` para rodar o aplicativo.

Se tudo der certo, a imagem do app deverá aparecer para nós cadastrarmos um aluno no aplicativo. Devemos preencher os campos (ainda sem validação) e clicar no botão `salvar`.

---

## Testar o App no Emulador

Após preencher os campos, clicar no `enter`, que nos levará ao `salvar`.

---

## Testar o App no Emulador

Se tudo der certo, irá aparecer uma mensagem `Aluno inserido com sucesso id *`.

---

## Recursos e Ferramentas Adicionais

### Livros
Expanda seus conhecimentos com livros especializados em desenvolvimento Android, como guias práticos e referências técnicas.

### Tutoriais Online
Aproveite os inúmeros tutoriais e cursos disponíveis na internet para aprender de forma interativa e autodidata.

### Dispositivos Físicos
Teste seu aplicativo em dispositivos Android reais para obter uma experiência de usuário mais autêntica e identificar problemas.

### Comunidade Android
Participe da comunidade Android, interaja com outros desenvolvedores e aproveite os recursos e fóruns disponíveis.

---

## Objetivo da Aula

- Navegar nas opções de interface
- Inserir objetos (elementos gráficos)
- Compilar o projeto
- Emular aplicações com os objetos inseridos

Objetivo: familiarizar-se com o ambiente.

---

## CRUD ANDROID SQLITE CADASTRO ALUNO - Part I

### Criar Projeto Novo

---

## Criar Layout

Após a criação do projeto, devemos clicar na raiz do projeto `app > res > layout > activity_main.xml` (ou o nome que for definido para o arquivo de atividade principal).

Existem 3 opções para exibir o layout:
- Code (código)
- Split
- Design (visual gráfico)

---

## Criar Layout

Neste Layout usamos:
- 3 Text > TextView (Nome, CPF, Telefone)
- 3 Text > Plain Text (campo de texto em branco)
- 1 Buttons > button

Essas opções ficam abertas à esquerda do layout na parte `Design` ou visual.

Para mudar o texto dentro dos objetos, primeiro selecionamos eles e depois vamos em `Attributes > Common attributes > Text` e mudamos para o valor que queremos.

---

## Ancoragem dos Componentes com a Tela Layout

---

## Criar Nova Classe

Clicar com o botão direito em cima do nosso projeto `app > java > com.example.exemplocrud1` (ou no nome que foi definido para o pacote). Escolher `New > Java Class` e dar o nome para a classe desejada.

Iremos criar as seguintes classes:
- MainActivity (já criada, p cadastrar)
- Aluno.java
- Conexao.java
- AlunoDao.java
- ListarAlunos.java

---

## Classe Aluno

O aluno terá os seguintes campos: Id, nome, cpf, telefone.

Se houver problemas com bibliotecas, o texto ficará vermelho. Para resolver, devemos parar o mouse em cima e abrirá uma opção `import class`. Após clicar nessa opção, o problema é resolvido e a biblioteca é importada.

---

## Classe Aluno

Mandar gerar getter and setter automaticamente, clicando com o botão direito dentro do código. Opção `generate > getter and setter`, e marcar todos os campos. Deverá ficar como a tela ao lado.

---

## Classe Aluno DAO

---

## Classe Conexao

---

## Classe MainActivity

---

## Activity_main.xml

Devemos configurar o botão `salvar` para o evento `onClick`, então ele irá executar o método `salvar` da `MainActivity` quando for clicado. Editamos esse campo dentro do arquivo `res > activity_main.xml`.

---

## Testar o App no Emulador

Clicar no ícone de `Play` para rodar o aplicativo.

Se tudo der certo, a imagem do app deverá aparecer para nós cadastrarmos um aluno no aplicativo. Devemos preencher os campos (ainda sem validação) e clicar no botão `salvar`.

---

## Testar o App no Emulador

Após preencher os campos, clicar no `enter`, que nos levará ao `salvar`.

---

## Testar o App no Emulador

Se tudo der certo, irá aparecer uma mensagem `Aluno inserido com sucesso id *`.

---

## CRUD ANDROID SQLITE LISTAR ALUNO - Part II

### Listar Aluno

#### Exercício:
Implementar para a próxima aula o `Listar Aluno`.

Vídeo auxílio: [YouTube](https://www.youtube.com/watch?v=2xGwbstHwrA)

O professor irá pedir para alguns alunos apresentar como realizaram a implementação, iremos discutir os problemas e dificuldades em aula.

OBS: Entregar a atividade no moodle. (Link do github ou pasta do projeto compactada `zip ou rar`).

---

## Referências:

- LECHETA, Ricardo R. Google Android: aprenda a criar aplicações para dispositivos móveis com o Android SDK. São Paulo: Novatec, 2009.
- TALUKDER, Asoke; YAVAGAL, Roopa. Mobile computing. New Delhi - India: McGraw-Hill, 2007.
- SILVA, D. Desenvolvimento para dispositivos móveis. Pearson, 2017.
- ANDROID. Android Developers. Disponível em [Android Developers](https://developer.android.com). Acesso em agosto de 2018.
- MIKKONEN, T. Programming mobile devices: an introduction for practitioners. Chichester, England: Wiley, 2007.
- ROGERS, Rick et al. Desenvolvimento de aplicações Android. O’Reilly: Novatec, 2009.
- SILVA, D. Arquitetura para computação móvel. Pearson, 2018.
- YAVAGAL, Roopa R.; TALUKDER, Asoke K. Mobile computing: technology, applications, and service creation. New York, NY: McGraw-Hill, 2007.

---

## Contato:
Email: andre.flores@ufn.edu.br

---

# Obrigado pela Atenção!

Santa Maria – RS 2024
