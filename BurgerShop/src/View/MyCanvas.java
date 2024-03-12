/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ygpra
 */
public class MyCanvas extends Canvas {

    @Override
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("C:/Users/ygpra/Desktop/iCET Assignments and Coursework/OOP/OOP DAY 04 - Swing Coursework Milestone 02/BurgerShop/BurgerShop/src/Resources/burgerShopVector.jpg");
        g.drawImage(i, 140, 60, this);
    }
}
