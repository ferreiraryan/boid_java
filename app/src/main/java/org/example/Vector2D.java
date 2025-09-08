package org.example;

class Vector2D {
  public double x;
  public double y;

  public static Vector2D subtract(Vector2D v1, Vector2D v2) {
    return new Vector2D(v1.x - v2.x, v1.y - v2.y);
  }

  public Vector2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void add(Vector2D outro) {
    this.x += outro.x;
    this.y += outro.y;
  }

  public void subtract(Vector2D outro) {
    this.x -= outro.x;
    this.y -= outro.y;
  }

  public void multiply(double escalar) {
    this.x *= escalar;
    this.y *= escalar;
  }

  public void divide(double escalar) {
    if (escalar != 0) {
      this.x /= escalar;
      this.y /= escalar;

    }
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y);
  }

  public void normalize() {
    double mag = magnitude();
    if (mag != 0) {
      divide(mag);
    }
  }

  public void setarMagnetude(double novaMagnetude) {
    normalize();
    multiply(novaMagnetude);
  }

  public void limit(double max) {
    if (magnitude() > max) {
      normalize();
      multiply(max);
    }
  }
}
