/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.OrderDetails;

/**
 *
 * @author ygpra
 */
public class OrderList {

    private OrderDetails orders;
    private OrderDetails bestCustList;

    public void add(OrderDetails data) {
        OrderDetails n1 = new OrderDetails(data.getOrderId(), data.getCustomerId(), data.getName(), data.getQtys(), data.getStatus());

        if (isEmpty()) {
            orders = n1;
        } else {
            OrderDetails lastOrder = orders;

            while (lastOrder.next != null) {
                lastOrder = lastOrder.next;
            }
            lastOrder.next = n1;
        }

    }

    public void bestCustAdd(OrderDetails data) {
        OrderDetails b1 = new OrderDetails(data.getBestQtys(), data.getBestCustNames(), data.getBestCustIds());

        if (isBestCustEmpty()) {
            bestCustList = b1;
        } else {
            OrderDetails lastBestCust = bestCustList;

            while (lastBestCust.next != null) {
                lastBestCust = lastBestCust.next;
            }
            lastBestCust.next = b1;
        }
    }

    public boolean isEmpty() {
        return orders == null;
    }

    public boolean isBestCustEmpty() {
        return bestCustList == null;
    }

    public int size() {
        OrderDetails temp = orders;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int bestSize() {
        OrderDetails temp = bestCustList;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public String getCustomerId(int index) {
        OrderDetails temp = orders;
        int count = 0;
        String id = "";

        while (temp != null) {
            if (index == count) {
                return temp.getCustomerId();
            }

            temp = temp.next;
            count++;
        }
        return id;
    }

    public String getName(int index) {
        OrderDetails temp = orders;
        int count = 0;
        String name = "";

        while (temp != null) {
            if (index == count) {
                return temp.getName();
            }

            temp = temp.next;
            count++;
        }
        return name;
    }

    public String getOrderId(int index) {
        OrderDetails temp = orders;
        int count = 0;
        String id = "";

        while (temp != null) {
            if (index == count) {
                return temp.getOrderId();
            }

            temp = temp.next;
            count++;
        }
        return id;
    }

    public int getStatus(int index) {
        OrderDetails temp = orders;
        int count = 0;
        int sta = -1;

        while (temp != null) {
            if (index == count) {
                return temp.getStatus();
            }

            temp = temp.next;
            count++;
        }
        return sta;
    }

    public int getQtys(int index) {
        OrderDetails temp = orders;
        int count = 0;
        int qty = -1;

        while (temp != null) {
            if (index == count) {
                return temp.getQtys();
            }

            temp = temp.next;
            count++;
        }
        return qty;
    }

    public int getBestQtys(int index) {
        OrderDetails temp = bestCustList;
        int count = 0;
        int qty = -1;

        while (temp != null) {
            if (index == count) {
                return temp.getBestQtys();
            }

            temp = temp.next;
            count++;
        }
        return qty;
    }

    public void setQty(int index, int qty) {
        if (index == 0) {
            bestCustList.setBestQtys(qty);
        } else {
            int count = 0;
            OrderDetails temp = bestCustList;

            while (temp != null) {
                if (index == count) {
                    temp.setBestQtys(qty);
                }

                temp = temp.next;
                count++;
            }
        }
    }

    public String getBestCustNames(int index) {
        OrderDetails temp = bestCustList;
        int count = 0;
        String name = "";

        while (temp != null) {
            if (index == count) {
                return temp.getBestCustNames();
            }

            temp = temp.next;
            count++;
        }
        return name;
    }

    public String getBestCustIds(int index) {
        OrderDetails temp = bestCustList;
        int count = 0;
        String id = "";

        while (temp != null) {
            if (index == count) {
                return temp.getBestCustIds();
            }

            temp = temp.next;
            count++;
        }
        return id;
    }

    public void bestCustUpdate(int index, OrderDetails data) {
        OrderDetails temp = bestCustList;
        int count = 0;

        while (temp != null) {
            if (index == count) {
                temp.updateBestCustList(data.getBestQtys(), data.getBestCustNames(), data.getBestCustIds());
            }

            temp = temp.next;
            count++;
        }
    }

    public void updateQtys(int index, int value) {
        OrderDetails temp = orders;
        int count = 0;

        while (temp != null) {
            if (index == count) {
                temp.updateQtys(value);
            }

            temp = temp.next;
            count++;
        }
    }

    public void updateStatus(int index, int sta) {
        OrderDetails temp = orders;
        int count = 0;

        while (temp != null) {
            if (index == count) {
                temp.updateStatus(sta);
            }

            temp = temp.next;
            count++;
        }
    }
}
