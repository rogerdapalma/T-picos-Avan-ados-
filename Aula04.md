# CRUD ANDROID SQLITE  
## ImageView e Acesso a Câmera  
**Aula 04**

---

## ImageView e Botão "tirarFoto"

Vamos inserir um `ImageView` e um botão `tirarFoto` para tirar uma foto na tela de `cadastrarAluno`.

1. Carregue um objeto `imageView` e ancore-o na tela, escolhendo um `id` para ele.

2. Insira um botão com `id=btnTakePhoto`, `text=Tirar Foto`, e adicione o método `onClick=tirarFoto` que será implementado a seguir.

3. Verifique no código XML se o método `onClick` foi corretamente inserido.

---

## Completar os Dados da Foto

- Complete os dados da foto na classe `Aluno.java`.

---

## Métodos para Manipulação de Dados

1. **inserir()**: Complete o método `inserir()` com os dados da foto na classe `AlunoDao.java`.
2. **atualizar()**: Complete o método `atualizar()` com os dados da foto na classe `AlunoDao.java`.
3. **obterTodos()**: Complete o método `obterTodos()` com os dados da foto na classe `AlunoDao.java`.

---

## Configurações no AndroidManifest.xml

- No arquivo `AndroidManifest.xml`, adicione as permissões necessárias para uso da câmera.

---

## Configurações em `cadastrarAlunoActivity.java`

### Declarações antes do método `onCreate()`:

```java
private static final int REQUEST_IMAGE_CAPTURE = 1;
private ImageView imageView;
private static final int REQUEST_CAMERA_PERMISSION = 200;
private ActivityResultLauncher<Intent> cameraLauncher;
```
## Dentro do método `onCreate()`:
```java
imageView = findViewById(R.id.imageView);
Button btnTakePhoto = findViewById(R.id.btnTakePhoto);
btnTakePhoto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        tirarFoto();
    }
});
```
## Configuração do `cameraLauncher`:
```java
cameraLauncher = registerForActivityResult(
    new ActivityResultContracts.StartActivityForResult(),
    result -> {
        if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
);
```
## Método `salvar()` para Envio de Dados

Complete o método `salvar()` no `cadastrarAlunoActivity.java` para enviar os dados da foto ao banco de dados.

```java
BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
if (drawable != null) {
    Bitmap bitmap = drawable.getBitmap();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
    byte[] fotoBytes = stream.toByteArray();
    aluno.setFotoBytes(fotoBytes);
}
```
## Verificação de Permissões de Câmera
Métodos para verificar e solicitar permissões de câmera no `cadastrarAlunoActivity.java`.
private void startCamera() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        cameraLauncher.launch(takePictureIntent);
    }
}

public void tirarFoto() {
    checkCameraPermissionAndStart();
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        imageView.setImageBitmap(imageBitmap);
    }
}
```
## Método para verificar permissões:
```java
private void checkCameraPermissionAndStart() {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) 
        != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, 
            new String[]{Manifest.permission.CAMERA}, 
            REQUEST_CAMERA_PERMISSION);
    } else {
        startCamera();
    }
}
```
## Tratamento de permissões:
```java
@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CAMERA_PERMISSION) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startCamera();
        } else {
            Toast.makeText(this, "A permissão da câmera é necessária para tirar fotos.", Toast.LENGTH_SHORT).show();
        }
    }
}
```
Atualização da Classe `Conexao.java`
Atualize a classe `Conexao.java` para armazenar os dados da foto no banco de dados.
```java
@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table aluno(id integer primary key autoincrement, nome varchar(50), cpf varchar(50), telefone varchar(50), foto_bytes BLOB)");
}
```
## Referências

- **LECHETA, Ricardo R.** *Google Android: aprenda a criar aplicações para dispositivos móveis com o Android SDK*. São Paulo: Novatec, 2009.
- **TALUKDER, Asoke; YAVAGAL, Roopa.** *Mobile Computing*. New Delhi - India: McGraw-Hill, 2007.
- **SILVA, D.** *Desenvolvimento para Dispositivos Móveis*. Pearson, 2017.
- **ANDROID.** *Android Developers*. Disponível em: [https://developer.android.com](https://developer.android.com). Acesso em agosto de 2018.
- **MIKKONEN, T.** *Programming Mobile Devices: An Introduction for Practitioners*. Chichester, England: Wiley, 2007.
- **ROGERS, Rick et al.** *Desenvolvimento de Aplicações Android*. O’Reilly: Novatec, 2009.
- **SILVA, D.** *Arquitetura para Computação Móvel*. Pearson, 2018.
- **YAVAGAL, Roopa R.; TALUKDER, Asoke K.** *Mobile Computing: Technology, Applications, and Service Creation*. New York, NY: McGraw-Hill, 2007.

## Contato

Email: [andre.flores@ufn.edu.br](mailto:andre.flores@ufn.edu.br)

