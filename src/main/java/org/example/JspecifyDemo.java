package org.example;

import org.example.orderProcesser.OrderHelper;

public class JspecifyDemo {

    //static String orderStatus=null;

    public static void main(String[] args) {
        OrderHelper orderHelper = new OrderHelper();
        orderHelper.verifyOrderStatus(null);
    }
}

