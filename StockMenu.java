package week2.product;

/**
 * 新增商品庫存量可選選單
 */
public class StockMenu {
    private int[] menu = new int[10];

    public String stringMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menu.length; i++) {
            menu[i] = i + 1;
            sb.append(menu[i] + " ");
        }
        return sb.toString();
    }
}
