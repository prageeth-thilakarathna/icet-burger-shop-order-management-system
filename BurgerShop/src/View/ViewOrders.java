/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ygpra
 */
public class ViewOrders extends JFrame {

    private Image img;
    private JButton BtnDeliveredOrders;
    private JButton BtnPreparingOrders;
    private JButton BtnCancelOrders;
    private JButton BtnBack;
    private final JPanel banner;
    private final JLabel label;
    private final JPanel labelPanel;
    private final JPanel body;
    private final JPanel navLink;

    public ViewOrders() {
        setSize(1100, 640);
        setTitle("Burger Shop - View Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);
        setLayout(new GridLayout(1, 2));
        
        // set image icon
        setIconImage(OrderController.favicon);

        // banner
        banner = new JPanel();
        banner.setLayout(new BorderLayout());
        banner.setBackground(Color.white);

        // add image
        MyBurger img = new MyBurger();
        banner.add(img, BorderLayout.CENTER);
        
        // body
        body = new JPanel();
        body.setLayout(new BorderLayout());
        
        // add label
        // panel
        labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());
        labelPanel.setBackground(OrderController.MainColor);
        body.add(labelPanel, BorderLayout.NORTH);

        // label
        label = new JLabel("View Orders", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);
        
        // nav links
        navLink = new JPanel();
        navLink.setLayout(null);
        navLink.setBackground(OrderController.headerColor);
        body.add(navLink, BorderLayout.CENTER);

        BtnDeliveredOrders = new JButton("Delivered Orders");
        BtnDeliveredOrders.setBounds(125, 150, 300, 35);
        BtnDeliveredOrders.setFont(new Font("", 1, 16));
        BtnDeliveredOrders.setBackground(OrderController.MainColor);
        BtnDeliveredOrders.setForeground(Color.white);
        BtnDeliveredOrders.setBorderPainted(false);
        BtnDeliveredOrders.setFocusPainted(false);
        navLink.add(BtnDeliveredOrders);

        BtnDeliveredOrders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnDeliveredOrders.setBackground(OrderController.OverMain);
                BtnDeliveredOrders.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnDeliveredOrders.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnDeliveredOrders.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnDeliveredOrders.setForeground(Color.white);
            }
        });

        BtnPreparingOrders = new JButton("Preparing Orders");
        BtnPreparingOrders.setBounds(125, 210, 300, 35);
        BtnPreparingOrders.setFont(new Font("", 1, 16));
        BtnPreparingOrders.setBackground(OrderController.MainColor);
        BtnPreparingOrders.setForeground(Color.white);
        BtnPreparingOrders.setBorderPainted(false);
        BtnPreparingOrders.setFocusPainted(false);
        navLink.add(BtnPreparingOrders);

        BtnPreparingOrders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnPreparingOrders.setBackground(OrderController.OverMain);
                BtnPreparingOrders.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnPreparingOrders.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnPreparingOrders.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnPreparingOrders.setForeground(Color.white);
            }
        });

        BtnCancelOrders = new JButton("Cancel Orders");
        BtnCancelOrders.setBounds(125, 270, 300, 35);
        BtnCancelOrders.setFont(new Font("", 1, 16));
        BtnCancelOrders.setBackground(OrderController.MainColor);
        BtnCancelOrders.setForeground(Color.white);
        BtnCancelOrders.setBorderPainted(false);
        BtnCancelOrders.setFocusPainted(false);
        navLink.add(BtnCancelOrders);

        BtnCancelOrders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnCancelOrders.setBackground(OrderController.OverMain);
                BtnCancelOrders.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnCancelOrders.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnCancelOrders.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnCancelOrders.setForeground(Color.white);
            }
        });

        BtnBack = new JButton("Back to Home");
        BtnBack.setBounds(350, 460, 150, 35);
        BtnBack.setFont(new Font("", 1, 16));
        BtnBack.setBackground(OrderController.MainColor);
        BtnBack.setForeground(Color.white);
        BtnBack.setBorderPainted(false);
        BtnBack.setFocusPainted(false);
        navLink.add(BtnBack);

        BtnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnBack.setBackground(OrderController.OverMain);
                BtnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnBack.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnBack.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnBack.setForeground(Color.white);
            }
        });

        // button action events
        BtnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        BtnDeliveredOrders.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new DeliveredOrders().setVisible(true);
                setVisible(false);
            }
        });

        BtnPreparingOrders.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new PreparingOrders().setVisible(true);
                setVisible(false);
            }
        });

        BtnCancelOrders.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new CancelOrders().setVisible(true);
                setVisible(false);
            }
        });

        add("West", banner);
        add("East", body);
    }
}
