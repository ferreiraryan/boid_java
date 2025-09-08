package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Boid {
  public Vector2D position;
  public Vector2D velocidade;
  public Vector2D aceleracao;

  public int cor = 0xFFFFFF;
  public int tamanho = 5;
  final double velocidadeMaxima = 2.0;
  public double forcaMaxima = 1;

  public Boid(double x, double y) {
    this.position = new Vector2D(x, y);

    Random ramdom = new Random();
    double angulo = ramdom.nextDouble() * 2 * Math.PI;
    this.velocidade = new Vector2D(Math.cos(angulo), Math.sin(angulo));
    this.velocidade.multiply(2.0);

    this.aceleracao = new Vector2D(0, 0);
  }

  public void update(ArrayList<Boid> todosOsBoids) {
    // aceleracao.add(this.alinhar(todosOsBoids));
    velocidade.add(aceleracao);
    velocidade.add(alinhar(todosOsBoids));
    velocidade.add(coersao(todosOsBoids));
    velocidade.add(separation(todosOsBoids));
    velocidade.limit(velocidadeMaxima);
    position.add(velocidade);
    aceleracao.multiply(0);
  }

  public Vector2D separation(ArrayList<Boid> boids) {
    double raioDeSeparacao = 10.0;
    Vector2D forcaTotal = new Vector2D(0, 0);
    int vizinhosProximos = 0;

    for (Boid outro : boids) {
      double distanciaSq = (this.position.x - outro.position.x) * (this.position.x - outro.position.x)
          + (this.position.y - outro.position.y) * (this.position.y - outro.position.y);

      if (outro != this && distanciaSq > 0 && distanciaSq < raioDeSeparacao * raioDeSeparacao) {

        Vector2D diferenca = Vector2D.subtract(this.position, outro.position);

        diferenca.normalize();
        diferenca.divide(Math.sqrt(distanciaSq));

        forcaTotal.add(diferenca);
        vizinhosProximos++;
      }
    }

    if (vizinhosProximos > 0) {
      forcaTotal.divide(vizinhosProximos);

      forcaTotal.setarMagnetude(this.velocidadeMaxima);

      Vector2D forcaDirecao = Vector2D.subtract(forcaTotal, this.velocidade);
      forcaDirecao.limit(this.forcaMaxima);

      return forcaDirecao;
    }

    return new Vector2D(0, 0);
  }

  public Vector2D alinhar(ArrayList<Boid> boids) {

    double raioDeVisao = 20;
    Vector2D mediaAceleracao = new Vector2D(0, 0);
    int quantidadeBoids = 0;
    for (Boid boid : boids) {
      double dx = this.position.x - boid.position.x;
      double dy = this.position.y - boid.position.y;
      double distance = Math.sqrt(dx * dx + dy * dy);
      if (boid != this && distance < raioDeVisao) {

        mediaAceleracao.add(boid.velocidade);
        quantidadeBoids++;
      }
    }

    if (quantidadeBoids > 0) {
      mediaAceleracao.divide(quantidadeBoids);
      mediaAceleracao.setarMagnetude(this.velocidadeMaxima);
      mediaAceleracao.subtract(this.velocidade);
      mediaAceleracao.limit(this.forcaMaxima);

    } else {
      mediaAceleracao.multiply(0);
    }
    return mediaAceleracao;
  }

  public Vector2D coersao(ArrayList<Boid> boids) {

    double raioDeVisao = 10;
    Vector2D mediaPosicao = new Vector2D(0, 0);
    int quantidadeBoids = 0;
    for (Boid boid : boids) {
      if (boid != this) {
        double dx = this.position.x - boid.position.x;
        double dy = this.position.y - boid.position.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance < raioDeVisao) {

          mediaPosicao.add(boid.position);
          quantidadeBoids++;
        }
      }
    }

    if (quantidadeBoids > 0) {
      mediaPosicao.divide(quantidadeBoids);
      mediaPosicao.subtract(this.position);
      mediaPosicao.setarMagnetude(this.velocidadeMaxima);
      mediaPosicao.subtract(this.velocidade);
      mediaPosicao.limit(this.forcaMaxima);

    } else {
      mediaPosicao.multiply(0);
    }
    return mediaPosicao;
  }

  public void verificarBordas(int largura, int altura) {
    if (this.position.x > largura)
      this.position.x = 0;
    else if (this.position.x < 0)
      this.position.x = largura;
    if (this.position.y > altura)
      this.position.y = 0;
    else if (this.position.y < 0)
      this.position.y = altura;
  }

  public boolean contemPonto(int px, int py) {
    return (px >= this.position.x && px < this.position.x + this.tamanho &&
        py >= this.position.y && py < this.position.y + this.tamanho);
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.desenharBoid((int) this.position.x, (int) this.position.y, this.tamanho, this.cor);
  }
}
