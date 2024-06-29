<p align="center" width="100%">
    <img width="50%" src="https://55content.com.br/wp-content/uploads/2022/05/Uber_Logo_Black.png"> 
</p>


<h1 align="center">
  Desafio Backend Uber
</h1>

Repositório dedicado para a resolução do desafio backend Uber.
O desafio consiste em criar um serviço de email, utilizando o Amazon Simple Email Service.


### Tecnologias Utilizadas

- Java 17
- Spring Boot
- AWS SES
<hr>

### Clonando o Repositório

```bash
git clone https://github.com/uFelps/Desafio-Backend-Uber.git
cd Desafio-Backend-Uber
```

### Rodando o Docker
Por questões de seguranças, o usuário que for utilizar a API deve configurar a
sua própria conta AWS para utilizar o serviço SES.

Deve ser fornecido:
- Chave de Acesso (AWS_ACCESSKEY)
- Chave secreta (AWS_SECRETKEY)
- Email configurado na AWS SES (EMAIL_SOURCE)


```bash
docker build -t email-service .
docker run -p 8080:8080 -e AWS_ACCESSKEY='{chave de acesso}' -e AWS_SECRETKEY='{chave privada}' -e EMAIL_SOURCE='{email configurado}' email-service
```


## Utilizando a API
Você pode começar enviando uma request POST na url: `http://localhost:15672`,
com o seguinte body:
```bash
{
    "to": "seuEmailAws@gmail.com",
    "subject": "Hello, Welcome to AWS SES!",
    "body": "This email is testing the AWS email service."
}
```

Caso ocorra tudo OK, você pode conferir se o email chegou na sua caixa de entrada
<div align="center">
  <img width="100%" margin="30px" src="https://github.com/uFelps/assets/blob/main/Desafio-Backend-Uber/image.png?raw=true"/>
  </div>



Caso ocorra algum erro relacionado as suas credenciais ou com o próprio serviço
da AWS, deeve ser retornado algo parecido com isso:
```bash
{
    "timestamp": "2024-06-29T19:27:11.669091900Z",
    "status": 503,
    "error": "Error on Email Service",
    "message": "Error on AWS SES. Check your credentials",
    "path": "/api/email"
}
```