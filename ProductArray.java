package week2.product;

/**
 * 商品陣列類別
 */
public class ProductArray {
    /**
     * 篩選介面
     */
    public interface Filter {
        public boolean select(Product product);
    }

    /**
     * 商品陣列
     */
    private Product[] items;
    /**
     * 商品數量
     */
    private int count;

    /**
     * 建構子
     */
    public ProductArray() {
        items = new Product[2];
        count = 0;
    }

    /**
     * 取得商品陣列
     *
     * @return 商品陣列
     */
    public Product[] getItems() {
        return items;
    }

    /**
     * 商品數量 getter
     *
     * @return 總商品數
     */
    public int getCount() {
        return count;
    }

    /**
     * 新增商品到陣列
     *
     * @param product
     */
    public void add(Product product) {
        if (count == items.length) {
            items = doubleArray(items);
        }
        items[count] = product;
        count++;
    }

    /**
     * 取得陣列特定商品
     *
     * @param index
     * @return 指定商品
     */
    public Product get(int index) {
        return items[index - 1];
    }

    /**
     * 篩選商品
     *
     * @param filter
     * @return 篩選商品
     */
    public ProductArray search(Filter filter) {
        ProductArray result = new ProductArray();
        for (int i = 0; i < this.count; i++) {
            if (filter.select(items[i])) {
                result.add(items[i]);
            }
        }
        return result;
    }


    /**
     * 印出所有商品
     */
    public void print() {
        for (Product item : items) {
            if (item != null) {
                System.out.println(
                        "流水號:" + item.getSerialNum()
                        + " 名稱:" + item.getName()
                        + " 價格:" + item.getPrice()
                        + " 分類:" + item.getCategory()
                        + " 生產公司:" + item.getFactory()
                        + " 上架:" + item.isOnShelf()
                        + " 庫存量:" + item.getInventory()
                );
            }
        }
    }


    /**
     * 加長陣列方法
     *
     * @param items
     * @return 新陣列
     */
    private Product[] doubleArray(Product[] items) {
        Product[] newArray = new Product[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        return newArray;
    }
}
