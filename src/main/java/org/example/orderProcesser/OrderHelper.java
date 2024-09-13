package org.example.orderProcesser;

import org.jspecify.annotations.NonNull;

public class OrderHelper {

    String orderStatus;

    public void verifyOrderStatus(@NonNull String orderStatus) {
        //using checker framework in my gradle dependency i am unable to compile the code due to potential NPE
        // System.out.println("orderStatus:" + orderStatus);
    }

}
