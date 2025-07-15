package Lib;

import java.util.ArrayList;

public class ShoppingCartManualTest {
     public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
         // test 4: คำนวนBoGo 1 แถม 1 
        ArrayList<CartItem> BOGOCart = new ArrayList<>();
        BOGOCart.add(new CartItem("BOGO", "Bread", 25.0, 2));
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BOGOCart);
        if (total4 == 25.0) {
            System.out.println("PASSED: BOGOCart total is correct quantity 2");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOCart total expected 2 but got " + total4);
            failedCount++;
        }

        // test 5: คำนวณBULK ซื้อ 6 ชิ้นจะได้ลดราคา 10%
         ArrayList<CartItem> BULK = new ArrayList<>();
        BULK.add(new CartItem("BULK", "Bread", 25, 7));
        double total5 = ShoppingCartCalculator.calculateTotalPrice(BULK);
        if (total5 == 157.5) {
            System.out.println("PASSED: BULK total is correct");
            passedCount++;
        } else {
            System.out.println("FAILED: BULK total expected 2 but got " + total5);
            failedCount++;
        }
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
