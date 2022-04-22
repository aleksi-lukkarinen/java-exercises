package fi.al.utils;




public class ALException extends Exception {
  // Tämä luokka on olemassa vain purkkavirityksellisenä keinona
  // erottaa itse luodut poikkeustilanteet Javan omista poikkeuksista.

  private static final long serialVersionUID = 42L;


  /**
   *
   *
   * @param msg
   */
  public ALException(final String msg) {
    super(msg); // Kutsutaan vain kantaluokan konstruktoria
  }
}
