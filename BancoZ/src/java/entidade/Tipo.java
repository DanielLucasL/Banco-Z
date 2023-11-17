/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author User
 */
public class Tipo {
    public static final String VALUE_ONE = "";
    public static final String VALUE_TWO = "cliente";
    public static final String VALUE_THREE = "administatdor";

    private String Tipo;
    
     public String getTipo() {
        return Tipo;
    }

    public Tipo(String value) {
        // Check if the provided value is valid
        if (VALUE_ONE.equals(value) || VALUE_TWO.equals(value) || VALUE_THREE.equals(value)) {
            this.Tipo = value;
        } else {
            // Handle invalid values, throw an exception, or set a default value
            this.Tipo = VALUE_ONE;
        }
    }
}
