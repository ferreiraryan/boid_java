package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Mundo {
  private final ArrayList<Boid> boids = new ArrayList<>();

  // private int offsetX, offsetY;

  public Mundo() {
    Random gerador = new Random();
    while (boids.size() < 20) {
      int posx = gerador.nextInt(10, 890);
      int posy = gerador.nextInt(10, 690);

      boolean posicaoJaExiste = false;

      for (Boid boid : boids) {
        if (boid.x == posx && boid.y == posy) {
          posicaoJaExiste = true;
          break;
        }
      }

      if (!posicaoJaExiste) {
        boids.add(new Boid(posx, posy));

      }
    }
  }

  public void atualizar() {
    for (Boid boid : boids) {
      boid.mover();
      verificarLimites(boid);
    }
  }

  private void verificarLimites(Boid boid) {
    if (boid.x > App.LARGURA)
      boid.x = 0;
    if (boid.x < 0)
      boid.x = App.LARGURA;
    if (boid.y > App.ALTURA)
      boid.y = 0;
    if (boid.y < 0)
      boid.y = App.ALTURA;

  }

  public void desenhar(Renderizador renderizador) {
    renderizador.limpar(0x101010);
    for (Boid p : boids) {
      p.desenhar(renderizador);
    }
  }

}
