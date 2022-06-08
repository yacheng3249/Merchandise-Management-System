package week2.product;

/**
 * 商品類別
 */
public class Product {
    /**
     * 流水號計數器
     */
    private static int count = 1;

    /**
     * 流水號
     */
    private int serialNum;
    /**
     * 商品名稱
     */
    private String name;
    /**
     * 價格
     */
    private int price;
    /**
     * 分類
     */
    private String category;
    /**
     * 生產公司
     */
    private String factory;
    /**
     * 上下架
     */
    private boolean onShelf;
    /**
     * 庫存量
     */
    private int inventory;


    /**
     * 建構子
     *
     * @param name
     * @param price
     * @param category
     * @param factory
     * @param onShelf
     * @param inventory
     */
    public Product(String name, int price, String category, String factory, boolean onShelf, int inventory) {
        this.serialNum = count;
        count++;
        this.name = name;
        this.price = price;
        this.category = category;
        this.factory = factory;
        this.onShelf = onShelf;
        this.inventory = inventory;
    }


    /**
     * 流水號 getter
     * @return 流水號
     */
    public int getSerialNum() {
        return serialNum;
    }

    /**
     * 商品名稱 getter
     * @return 商品名稱
     */
    public String getName() {
        return name;
    }

    /**
     * 價格 getter
     * @return 價格
     */
    public int getPrice() {
        return price;
    }

    /**
     * 分類 getter
     * @return 分類
     */
    public String getCategory() {
        return category;
    }

    /**
     * 生產公司 getter
     * @return 生產公司
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 上下架 getter
     * @return 是否上下架
     */
    public boolean isOnShelf() {
        return onShelf;
    }

    /**
     * 庫存量 getter
     * @return 庫存量
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * 庫存量 setter
     * @param inventory
     */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    /**
     * 上下架 setter
     * @param onShelf
     */
    public void setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
    }


    /**
     * 印出商品
     */
    public void print() {
        System.out.println(
                "流水號:" + serialNum
                + " 名稱:" + name
                + " 價格:" + price
                + " 分類:" + category
                + " 生產公司:" + factory
                + " 上架:" + onShelf
                + " 庫存量:" + inventory
        );
    }
}