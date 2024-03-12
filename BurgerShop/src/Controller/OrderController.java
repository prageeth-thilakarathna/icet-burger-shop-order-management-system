/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.OrderList;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author ygpra
 */
public class OrderController {

    // order list
    public static OrderList orList = new OrderList();

    // best customer
    public static OrderList bestCust = new OrderList();

    // icons
    public static final ImageIcon successIcon = new ImageIcon("C:/Users/ygpra/Desktop/iCET Assignments and Coursework/OOP/OOP DAY 04 - Swing Coursework Milestone 02/BurgerShop/BurgerShop/src/Resources/success-icon.png");
    public static final ImageIcon questionIcon = new ImageIcon("C:/Users/ygpra/Desktop/iCET Assignments and Coursework/OOP/OOP DAY 04 - Swing Coursework Milestone 02/BurgerShop/BurgerShop/src/Resources/question-icon.png");
    public static final ImageIcon errorIcon = new ImageIcon("C:/Users/ygpra/Desktop/iCET Assignments and Coursework/OOP/OOP DAY 04 - Swing Coursework Milestone 02/BurgerShop/BurgerShop/src/Resources/error-icon.png");

    // favicon
    public static final Image favicon = Toolkit.getDefaultToolkit().getImage("C:/Users/ygpra/Desktop/iCET Assignments and Coursework/OOP/OOP DAY 04 - Swing Coursework Milestone 02/BurgerShop/BurgerShop/src/Resources/burger-favicon.png");

    // colors
    public static final Color SecondColor = new Color(100, 140, 13);
    public static final Color MainColor = new Color(187, 37, 37);
    public static final Color OverSecond = new Color(57, 89, 8);
    public static final Color OverMain = new Color(125, 10, 10);
    public static final Color whiteBack = new Color(245, 247, 248);
    public static final Color typography = new Color(25, 25, 25);
    public static final Color textBoxBackG = new Color(227, 225, 217);
    public static final Color headerColor = new Color(199, 200, 204);

    public static DecimalFormat df = new DecimalFormat("0.00");

    // check order id
    public static boolean checkOrderId(String id) {
        for (int i = 0; i < orList.size(); i++) {
            String id1 = orList.getOrderId(i);

            if (id1.equals(id)) {
                return true;
            }
        }
        return false;
    }

    // find order id index
    public static int findOrderIdIndex(String id) {
        for (int i = 0; i < orList.size(); i++) {
            String id1 = orList.getOrderId(i);

            if (id1.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // find order status
    public static int findOrderStatus(int index) {
        int sta = orList.getStatus(index);
        return sta;
    }

    // generate id
    public static String generateId() {
        if (orList.size() > 0) {
            String lastId = orList.getOrderId(orList.size() - 1);

            String[] part = lastId.split("[B]");
            int num = Integer.parseInt(part[1]);
            num++;

            return String.format("B%03d", num);
        }
        return "B001";
    }

    // check customer id
    public static boolean checkCustomerId(String id) {
        for (int i = 0; i < orList.size(); i++) {
            String id2 = orList.getCustomerId(i);

            if (id2.equals(id)) {
                return true;
            }
        }
        return false;
    }

    // find customer id index
    public static int findCustomerIdIndex(String id) {
        for (int i = 0; i < orList.size(); i++) {
            String id2 = orList.getCustomerId(i);

            if (id2.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // create best customer objects list
    public static void createBestCust() {
        int create = 0, update = 0;
        for (int i = 0; i < orList.size(); i++) {
            boolean validate = validateCustomerId(i);
            if (validate == false) {
                create = 101;
            }

            for (int j = (i + 1); j <= orList.size() - 1; j++) {
                String custId = orList.getCustomerId(i);
                String custId2 = orList.getCustomerId(j);
                int sta = orList.getStatus(j);
                int sta2 = orList.getStatus(i);

                if (custId.equals(custId2) & validate == true & sta != 2 & sta2 != 2) {
                    create++;
                    update++;
                }

                // create
                if (create == 1) {
                    int qty = orList.getQtys(i);
                    String name = orList.getName(i);
                    String id = orList.getCustomerId(i);

                    bestCust.bestCustAdd(new OrderDetails(qty, name, id));
                    create = 102;
                }

                // update
                if (update == 1) {
                    int qty = orList.getQtys(j);
                    int qty2 = bestCust.getBestQtys(bestCust.bestSize() - 1);

                    int total = qty + qty2;

                    bestCust.setQty(bestCust.bestSize() - 1, total);
                    update = 0;
                }
            }

            // not duplicate create
            int sta = orList.getStatus(i);
            if (create == 0 & validate == true & sta != 2) {
                int qty = orList.getQtys(i);
                String name = orList.getName(i);
                String id = orList.getCustomerId(i);

                bestCust.bestCustAdd(new OrderDetails(qty, name, id));
            }
            create = 0;
        }
    }

    // customer id validate
    public static boolean validateCustomerId(int index) {
        for (int i = index; i > 0; i--) {
            String custId = orList.getCustomerId(index);
            String custId2 = orList.getCustomerId(i - 1);
            int sta = orList.getStatus(i - 1);

            if (custId.equals(custId2) & sta != 2) {
                return false;
            }
        }
        return true;
    }

    // clear best cust objects list
    public static void clearBestCust() {
        OrderList tempBestCust = new OrderList();
        bestCust = tempBestCust;
    }

    // short best customers
    public static void shortBestCust() {
        for (int i = 0; i < bestCust.bestSize() - 1; i++) {
            for (int j = 0; j < bestCust.bestSize() - 1; j++) {
                int qty = bestCust.getBestQtys(j);
                int qty2 = bestCust.getBestQtys(j + 1);

                if (qty < qty2) {
                    String name = bestCust.getBestCustNames(j + 1);
                    String id = bestCust.getBestCustIds(j + 1);

                    String name2 = bestCust.getBestCustNames(j);
                    String id2 = bestCust.getBestCustIds(j);

                    bestCust.bestCustUpdate(j + 1, new OrderDetails(qty, name2, id2));

                    bestCust.bestCustUpdate(j, new OrderDetails(qty2, name, id));
                }
            }
        }
    }
}
