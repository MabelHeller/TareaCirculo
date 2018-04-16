/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Heller
 */
public class Oval {

    //atributos
    private int x;
    private int y;
    private final int d;
    private int addressX;
    private int addressY;

    //constructores
    public Oval(int x, int y, int d, int addressX, int addressY) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.addressX = addressX;
        this.addressY = addressY;
    }

    //metodos accesores
    public void setX(int x) {
        this.x = x;

    }

    public int getX() {
        return x;

    }

    public void setY(int y) {
        this.y = y;

    }

    public int getY() {
        return y;

    }

    public int getDiametro() {
        return d;

    }

    //metodo para cambiar la direccion X
    public void changeAddressX() {
        this.addressX = addressX * -1;
    }

    //metodo para cambiar la direccion Y
    public void changeAddressY() {
        this.addressY = addressY * -1;
    }

    //metodo para cambiar la X
    public void moveX() {
        this.x = x + addressX;
    }

    //metodo para cambiar la X
    public void moveY() {
        this.y = y + addressY;
    }

}
