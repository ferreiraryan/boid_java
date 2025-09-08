package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GerenciadorDeEntrada implements MouseListener, MouseMotionListener {
  private final Mundo mundo;

  public GerenciadorDeEntrada(Mundo mundo) {
    this.mundo = mundo;
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }

  // Métodos não utilizados
  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    mundo.atualizarPosicaoMouse(e.getX(), e.getY());
  }
}
