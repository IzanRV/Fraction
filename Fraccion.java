/**
 * Esta clase representa una fracción matemática.
 */
public class Fraccion {
  
  private int signo;
  private int numerador;
  private int denominador;

  /**
   * Construye un objeto Fraccion con el numerador y denominador dados.
   *
   * @param n el numerador
   * @param d el denominador
   * @throws IllegalArgumentException si el denominador es cero
   */
  
  public Fraccion(int n, int d) {
    if (d == 0) {
      System.out.println("Una fracción no puede tener como denominador el número 0");
    } else {
      if (n * d < 0) {
        this.signo = -1;
      } else {
        this.signo = 1;
      }
      this.numerador = Math.abs(n);
      this.denominador = Math.abs(d);
    }
  }

  /**
   * Devuelve el numerador de esta fracción.
   *
   * @return el numerador
   */

  int getNumerador(){
    return this.numerador;
  }

  /**
   * Devuelve el denominador de esta fracción.
   *
   * @return el denominador
   */

  int getDenominador(){
    return this.denominador;
  }

  /**
   * Devuelve una representación en cadena de esta fracción.
   *
   * @return una cadena en el formato "numerador/denominador"
   */

  public String toString() {
    if (signo == -1) {
      return "-" + this.numerador + "/" + this.denominador;
    } else {
      return this.numerador + "/" + this.denominador;
    }
  }

  /**
   * Devuelve la inversa de esta fracción.
   *
   * @return un nuevo objeto Fraccion que es la inversa de esta fracción
   */

  public Fraccion invierte() {
    return new Fraccion(this.signo * this.denominador, this.numerador);
  }

  /**
   * Multiplica esta fracción por un número entero.
   *
   * @param n el número entero por el cual multiplicar
   * @return un nuevo objeto Fraccion que es el resultado de la multiplicación
   */

  public Fraccion multiplica(int n) {
    return new Fraccion(this.signo * this.numerador * n, this.denominador);
  }

  /**
   * Multiplica esta fracción por otra fracción.
   *
   * @param f la fracción por la cual multiplicar
   * @return un nuevo objeto Fraccion que es el resultado de la multiplicación
   */
 
  public Fraccion multiplica(Fraccion f) {
    return new Fraccion(
      this.signo * this.numerador * f.getNumerador(),
      this.denominador * f.getDenominador());
  }

  /**
   * Divide esta fracción por un número entero.
   *
   * @param n el número entero por el cual dividir
   * @return un nuevo objeto Fraccion que es el resultado de la división
   */
 
  public Fraccion divide(int n) {
    return new Fraccion(this.signo * this.numerador, this.denominador * n);
  }

  /**
   * Divide esta fracción por otra fracción.
   *
   * @param f la fracción por la cual dividir
   * @return un nuevo objeto Fraccion que es el resultado de la división
   */
  
  public Fraccion divide(Fraccion f) {
    return new Fraccion(
      this.signo * this.numerador * f.getDenominador(),
      denominador * f.getNumerador());
  }

  /**
   * Simplifica esta fracción a sus términos más bajos.
   *
   * @return un nuevo objeto Fraccion que es la fracción simplificada
   */

  public Fraccion simplifica() {
    
    final int s = this.signo;
    int n = this.numerador;
    int d = this.denominador;
      
    for (int i = 2; i < Math.min(this.numerador, this.denominador); i++) {
      while (((n % i) == 0) && ((d % i) == 0)) {
        n /= i;
        d /= i;
      }
    }

    return new Fraccion(s * n, d);
  }
}
