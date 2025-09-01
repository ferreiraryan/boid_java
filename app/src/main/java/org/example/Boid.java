package org.example;

public class Boid {
  public double x, y;
  public double vx, vy;
  public double velocidade;
  public int cor = 0xFFFFFF;
  public int tamanho = 10;

  public Boid(double x, double y) {
    this.x = x;
    this.y = y;
    this.vx = (Math.random() - 0.5);
    this.vy = (Math.random() - 0.5);
  }

  public void mover() {
    this.x += this.vx;
    this.y += this.vy;

    double FATOR_ALEATORIO = 0.5;

    this.velocidade = Math.random() - 0.5;

    this.vx += this.velocidade * FATOR_ALEATORIO;
    this.vy += this.velocidade * FATOR_ALEATORIO;

    // Desafio para você: como você faria para limitar a velocidade máxima?
    // Se você só adiciona valores, a velocidade pode aumentar infinitamente.
    // Você precisaria calcular a magnitude do vetor (vx, vy) e, se passar
    // de um limite, normalizá-lo.
  }

  public boolean contemPonto(int px, int py) {
    return (px >= this.x && px < this.x + this.tamanho &&
        py >= this.y && py < this.y + this.tamanho);
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.desenharBoid((int) this.x, (int) this.y, this.tamanho, this.cor);
  }
}
