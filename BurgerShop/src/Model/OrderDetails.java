/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ygpra
 */
public class OrderDetails {

    private String orderIds;
    private String customerIds;
    private String names;
    private int qtys;
    private int status;
    public OrderDetails next;

    public static final double BURGERPRICE = 500.00;

    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;

    // best customer
    private int bestQtys;
    private String bestCustNames;
    private String bestCustIds;

    public OrderDetails(String orderIds, String customerIds, String names, int qtys, int status) {
        this.orderIds = orderIds;
        this.customerIds = customerIds;
        this.names = names;
        this.qtys = qtys;
        this.status = status;
    }

    public OrderDetails(int qty, String name, String id) {
        bestQtys = qty;
        bestCustNames = name;
        bestCustIds = id;
    }

    public String getOrderId() {
        return orderIds;
    }

    public String getCustomerId() {
        return customerIds;
    }

    public String getName() {
        return names;
    }

    public int getStatus() {
        return status;
    }

    public int getQtys() {
        return qtys;
    }

    public int getBestQtys() {
        return bestQtys;
    }

    public String getBestCustNames() {
        return bestCustNames;
    }

    public String getBestCustIds() {
        return bestCustIds;
    }

    public void setBestQtys(int qty) {
        bestQtys = qty;
    }

    public void updateBestCustList(int qty, String name, String id) {
        bestQtys = qty;
        bestCustNames = name;
        bestCustIds = id;
    }

    public void updateQtys(int value) {
        qtys = value;
    }

    public void updateStatus(int sta) {
        status = sta;
    }
}
