package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Mundo {
  private final ArrayList<Boid> boids = new ArrayList<>();
  private Boid mouseBoid;
  // private int offsetX, offsetY;

  public Mundo() {

    // boids.add(new Boid(200, 500));
    mouseBoid = new Boid(-100, -100);
    mouseBoid.forcaMaxima = 20;

    boids.add(new Boid(200, 300));

    Random gerador = new Random();
    while (boids.size() < 100) {
      int posx = gerador.nextInt(10, 890);
      int posy = gerador.nextInt(10, 690);

      boolean posicaoJaExiste = false;

      for (Boid boid : boids) {
        if (boid.position.x == posx && boid.position.y == posy) {
          posicaoJaExiste = true;
          break;
        }
      }

      if (!posicaoJaExiste) {

        boids.add(new Boid(posx, posy));
      }
    }
  }

  public void atualizarPosicaoMouse(int x, int y) {
    double velX = x - this.mouseBoid.position.x;
    double velY = y - this.mouseBoid.position.y;
    this.mouseBoid.velocidade = new Vector2D(velX, velY);

    this.mouseBoid.position.x = x;
    this.mouseBoid.position.y = y;
  }

  public void atualizar() {
    ArrayList<Boid> todosOsInfluenciadores = new ArrayList<>(boids);
    todosOsInfluenciadores.add(mouseBoid);

    for (Boid boid : boids) {
      boid.update(todosOsInfluenciadores);
      boid.verificarBordas(App.LARGURA, App.ALTURA);
    }
  }

  public void desenhar(Renderizador renderizador) {
    renderizador.limpar(0x101010);
    for (Boid p : boids) {
      p.desenhar(renderizador);
    }
  }

}
