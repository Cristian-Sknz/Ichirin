<img align="right" width="300px" alt="Ichirin no Hana Logo" src="https://github.com/Cristian-Sknz/Ichirin/blob/master/ichirin-frontend/public/logo.svg">

<h1 align="left">Ichirin</h1>

<div>
  <img align="left" width="165px" height="165px" alt="Chika Fujiwara" src="https://c.tenor.com/S_Bm_Ect9uMAAAAC/chika-delicious.gif">
  <h2>Sobre</h2>
  Este projeto será apresentado em meu portfolio, mostrando algumas das tecnologias que sei atualmente. Este projeto é um projeto full-stack, com o front-end feito com ReactJS e NextJS utilizando o TypeScript e o back-end feito em Java utilizando o Spring Framework.
</div>

## :fire: Status
> Como este projeto ainda não está concluido, recomendo que teste em ambiente de desenvolvimento.

Atualmente o projeto irá passar por um "replanejamento", no começo criei este projeto sem nenhum planejamento apenas fui desenvolvendo com as ideias que tinha na cabeça. Bem isso não foi algo que deu muito certo, o projeto tomou uma proporção alem das minhas expectativas e continua a evoluir tomando porporções de desenvolvimento ainda maiores. Este replanejamento será feito para deixar as ideias e objetivos do projeto mais claros.

Decidi replanejar pois como disse, o projeto está ficando bem grande e com isso, eu estava começando a desenvolvendo de forma desorganizada sem completar o desenvolvimento de features e desenvolvendo varias features ao mesmo tempo. Este replanejamento irá fazer com que o desenvolvimento do projeto fique mais saudavel e fazendo com que seja mais produtivo até chegar no resultado final.

### Desenvolvimento atual:
Você pode ver o progresso do projeto em [Issues](https://github.com/Cristian-Sknz/Ichirin/issues).
As modificações que não estão totalmente prontas, não serão commitados na [`master`](https://github.com/Cristian-Sknz/Ichirin/tree/master), tente dar uma olhada em outras branches para ver o progresso do projeto.

## Como iniciar em modo de produção?
<div>
  <a href="https://www.docker.com/get-started">
    <img align="left" width="90px" alt="Docker logo" src="https://icon-library.com/images/docker-icon/docker-icon-15.jpg">
  </a>
  Para isso você irá precisar utilizar o <a href="https://www.docker.com/get-started">Docker</a> para deixar todos os ambientes funcionando em conjunto, corretamente e sem problemas!
Tem duas formas de criar o ambiente de produção com o Docker.
</div>
<hr>
  

### 1. Build completo com o docker-compose
  
A primeira forma requer menos etapas e não precisa ter as ferramentas de desenvolvimento instaladas na sua maquina, porem é mais demorado por conta do processo de building. Comece editando o arquivo **docker-compose.yml** na raiz do projeto.

Modifique os seguintes campos:
```yml
services:
  backend:
    container_name: ichirin-backend
    build:
      context: ./ichirin-backend
      dockerfile: dockerfile_build
      # Aqui estará como 'dockerfile', altere para 'dockerfile_build'
....
```
Agora você só precisa rodar o comando `docker-compose up -d`, que o docker irá criar a build da imagem e irá rodar o projeto automaticamente,
fique ligado no terminal para ver as etapas sendo concluidas. Depois é só acessar o link da aplicação que estará funcionando sem problemas!

### 2. Usando a build pronta do backend
Aqui você precisará ter instalado o [Gradle](https://gradle.org) na sua maquina e utilizar o comando `gradle build` em `./ichirin-backend`, após fazer isso
você precisará apenas rodar o comando `docker-compose up -d` na raiz do projeto **utilizando** o arquivo **docker-compose.yml** padrão que vem na raiz do projeto.

Criar as imagens e containers Docker utilizando este metodo é muito mais rapido, pois o docker não terá que baixar todas as dependências do gradle (que são muitas) 
a cada build, com isso as proximas builds do projeto serão menos custosas.

## Como iniciar em modo de desenvolvimento?
Como este projeto é um projeto que tem tanto o front-end e back-end, caso queira desenvolver ambas as partes, terá que ter uma serie de ferramentas instaladas em seu sistema, abaixo separei quais ferramentas você irá precisar em cada stack.

### Back-end com Java e Spring Framework
Para iniciar o ambiente de desenvolvimento back-end, você precisará ter instalado o JDK/Java 11, a versão do [Gradle](https://gradle.org) que tenha suporte a JDK 11 e uma IDE para desenvolver e editar codigo, recomendo que utilize o [**IntelliJ IDEA**](https://www.jetbrains.com/pt-br/idea/download/), mas você pode utilizar outra IDE de sua preferência, o unico requisito para a IDE será ter suporte a Java e Gradle.

Após ter preparado o ambiente, dê um build do projeto para se certificar que todas as dependências estão instaladas, depois de tudo pronto, o projeto está preparado para ser editado e desenvolvido sem problemas.
Lembre-se de mudar a url do banco de dados em `./resources/application.yml`

#### Utilize o Postman!
<div>
  <img align="left" width="90px" alt="Postman Logo" src="https://seeklogo.com/images/P/postman-logo-0087CA0D15-seeklogo.com.png">

  Aqui está disponivel uma coleção do postman com todas as rotas e campos necessarios para cada resposta preenchidos:
  <p>
    :writing_hand: <a href="https://github.com/Cristian-Sknz/Ichirin/raw/master/Ichirin%20API%20Postman%20Collection.json">Ichirin API Postman Collection</a>
  <p/>
</div>

<hr>

### Front-end com typescript, React e NextJS.
Para iniciar o ambiente de desenvolvimento front-end, primeiramente você precisará ter uma instancia do backend funcionando (você pode criar um container com o backend utilizando o docker-compose.yml). Para declarar o caminho da API você precisa editar o arquivo `.env.development`
```properties
# Troque o valor da chave a seguir:
API_HOST=<ip do backend>
# Exemplo
API_HOST=http://192.168.99.100:8080
```

Após concluir o passo anterior, você precisará ter instalado em sua maquina o NodeJS, execute o comando `npm install` ou `yarn install` na raiz do front-end.

Após instalar todas as dependências o projeto está pronto para ser editar e desenvolvido, recomendo você utilizar o [**Visual Studio Code**](https://code.visualstudio.com), mas você pode utilizar a IDE de sua preferência, os requisitos da IDE são ter suporte a Typescript e Sintaxe JSX/TSX.

Para iniciar o ambiente basta utilizar o comando `npm run dev` ou `yarn dev`.

## Pull Requests
> Ainda não estou aceitando pull-requests pois este é um projeto pessoal e apenas está open-source, ao concluir este projeto pull-requests poderão ser aceitas, caso o intuito seja melhorar e aprimorar o projeto.

