# 🚀 Boid Java - Simulação de Enxame

Uma implementação em Java do algoritmo Boids, criado por Craig Reynolds, para simulação de comportamento coletivo de aves, peixes e outros enxames. O projeto mostra como regras simples podem gerar comportamentos complexos e emergentes em sistemas multiagente.

---

## ⚙️ Tecnologias

Este projeto foi desenvolvido com as seguintes tecnologias:

-   [Java](https://www.java.com/)
-   [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/) e [AWT (Abstract Window Toolkit)](https://docs.oracle.com/javase/tutorial/awt/) para a interface gráfica.

---

## ✨ Funcionalidades

### Simulação de Enxame (Boids)
-   **Separação:** Evita colisões mantendo distância mínima entre boids.
-   **Coesão:** Faz com que os boids se movimentem em direção ao centro do grupo.
-   **Alinhamento:** Os boids ajustam sua direção de acordo com os vizinhos próximos.
-   
### Interação Visual
-   **Renderização em Tempo Real:** Cada boid é representado na tela com atualização contínua.
-   **Parâmetros Flexíveis:** Fácil adaptação para testar diferentes comportamentos alterando constantes no código.

### Renderização Gráfica
-   **Múltiplos Objetos:** Renderiza e gerencia o estado de diversos quadrados (Pixels) na tela simultaneamente.

---

## 📂 Estrutura do Projeto

A lógica do projeto está dividida nos seguintes arquivos principais:

```
/boid_java
├── src/
│   ├── App.java          # Ponto de entrada, cria a janela e inicia a simulação.
│   ├── Boid.java         # Representa cada agente (boid), com posição, velocidade e regras de movimento.
│   ├── Mundo.java        # Representa o lugar onde os boids se movimentam.
│   ├── Vector2D.java     # Classe auxiliar para melhor controle sobre os vetores.
│   ├── Renderizador.java # Responsável por desenhar os boids na tela.
│   └── GerenciadorDeEntrada.java  # Captura e processa os inputs do mouse (cliques, arrastar).
├── .gitignore
└── README.md

```

---

## 📥 Instalação e Configuração

Para executar este projeto, você precisa ter o **JDK (Java Development Kit)** instalado em sua máquina.

```bash
# 1. Clone este repositório
git clone https://github.com/ferreiraryan/boid_java.git

# 2. Acesse o diretório
cd boid_java

# 3. Compile e execute
javac src/*.java
java -cp src App

```

---

## 🤝 Contribuindo

Sinta-se à vontade para contribuir! Basta seguir os passos abaixo:

1. Faça um **fork** do projeto.
2. Crie uma **branch** com a sua feature: `git checkout -b minha-feature`
3. Faça **commit** das suas alterações: `git commit -m 'Adiciona nova feature'`
4. Envie para o GitHub: `git push origin minha-feature`
5. Abra um **Pull Request**

---

## 📬 Contato

- **Ryan Ferreira** - [ryanferreira4883@gmail.com](mailto:ryanferreira4883@gmail.com)
- **GitHub** - [https://github.com/ferreiraryan](https://github.com/ferreiraryan)
- **LinkedIn** - [https://www.linkedin.com/in/ferryan/](https://www.linkedin.com/in/ferryan/)

---
