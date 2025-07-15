package Lib;

import java.util.ArrayList;

public class ShoppingCartCalculator {
    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - ถ้าจำนวนสินค้าในตะกร้า เป็น null || empty จะรีเทิร์นค่าเป็น 0 
     * - จะไม่ให้ใส่ค่าที่ติดลบ
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     * @param ถ้าตะกร้าเป็น null หรือ empty จะมีค่าเป็น 0 ถ้าตะกร้าปกติ จะคำนวณราคาตามรายการค้าแบบไม่มีส่วนลด
     * ตะกร้าแบบ BOGO ซื้อ 1 แถม 1 ตะกร้าแบบ BULK ถ้าซื้อ >= 6 จะได้ส่วนลด 10%
     * @return จะคำนวณราคาสินค้าตามตะกร้าแต่ละชนิด
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double sum = 0 ;
        if(items == null)
            return 0.0 ;
        for (CartItem cartItem : items) {
            if (cartItem.sku() == "BOGO" && cartItem.quantity() <= 2) {
             sum += cartItem.price() * Math.round(cartItem.quantity() / 2.0) ;
            } else if(cartItem.sku() == "BULK" && cartItem.quantity() >= 6){
             sum += (cartItem.price() * cartItem.quantity()) - (cartItem.price()) * cartItem.quantity() /(100/10) ;
            }
            else{
                sum += cartItem.price() * cartItem.quantity() ;
            }
        }
        
        return sum ;
    }

}
