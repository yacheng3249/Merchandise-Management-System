package week2.product;


public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        ProductArray items = new ProductArray();


        /**
         * 功能表
         * Enum將使用者輸入代號轉換
         */
        int menu = input.numberInARange("請選擇使用功能，【1】新增商品 【2】查詢商品 【3】批量修改庫存 【4】批量上/下架 【5】印出所有商品資訊 【6】結束： ", 1, 6);
        Globol.Menu opt = Globol.Menu.valueOf(menu);
        final int end = Globol.Menu.End.getIndex();

        /**
         * 依使用者的選擇執行
         * 若沒選擇結束迴圈將無法結束
         */
        while (menu != end) {
            switch (opt) {
                case AddProduct:
                    items.add(new Product(
                            input.string("商品名稱: "),
                            input.number("價格: "),
                            input.string("分類: "),
                            Globol.Factory.valueOf(input.numberInARange("選擇生產公司，【1】公司1 【2】公司2 【3】公司3 【4】公司4 【5】公司5 : ", 1, 5)).getStr(),
                            input.aBoolean("上架: "),
                            input.numberInARange("選擇庫存量，" + new StockMenu().stringMenu() + ": ", 1, 10)
                    ));
                    break;
                case SearchProduct:
                    ProductArray result = pickItems(input, items);
                    result.print();
                    break;
                case ModifyStock:
                    int action = input.numberInARange("選擇【1】增加【2】減少: ", 1, 2);
                    int changeAmount = input.number("輸入增加或減少的庫存量: ");
                    ProductArray changeStockItems = pickItems(input, items);
                    Globol.Action actionOpt = Globol.Action.valueOf(action);

                    for (Product item : changeStockItems.getItems()) { //欲修改庫存量的商品
                        if (item == null) {
                            break;
                        }
                        for (Product originalItem : items.getItems()) { //原始全商品陣列
                            //對照原始商品陣列和欲修改商品陣列的流水號，在原始全商品陣列裡做更改
                            if (originalItem.getSerialNum() == item.getSerialNum()) {
                                switch (actionOpt) {
                                    case Increase:
                                        originalItem.setInventory(originalItem.getInventory() + changeAmount);
                                        break;
                                    case Decrease:
                                        originalItem.setInventory(originalItem.getInventory() - changeAmount);
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    System.out.println("庫存量已更改完成");
                    break;
                case ModifyShelf:
                    //欲上或下架的商品陣列
                    ProductArray pickItems = pickItems(input, items);
                    //改變上下架
                    for (Product item : pickItems.getItems()) {
                        item.setOnShelf(!item.isOnShelf());
                    }
                    break;
                case PrintAllItems:
                    items.print();
                    break;
            }

            menu = input.numberInARange("請選擇使用功能，【1】新增商品 【2】查詢商品 【3】批量修改庫存 【4】批量上/下架 【5】印出所有商品資訊 【6】結束： ", 1, 6);
            opt = Globol.Menu.valueOf(menu);
        }
    }

    /**
     * 篩選商品方法
     *
     * @param input
     * @param items
     * @return
     */
    public static ProductArray filterItems(Input input, ProductArray items) {
        ProductArray result = new ProductArray();
        int filterMethod = input.numberInARange("篩選方式，【1】價格區間【2】分類【3】生產公司【4】庫存下限【5】名稱【6】流水號範圍: ", 1, 6);
        Globol.Filter filterOpt = Globol.Filter.valueOf(filterMethod);
        switch (filterOpt) {
            case Price:
                result = items.search((Product product) -> product.getPrice() >= input.number("最低價: ") && product.getPrice() <= input.number("最高價: "));
                break;
            case Category:
                result = items.search((Product product) -> product.getCategory().equals(input.string("欲搜尋商品分類: ")));
                break;
            case Factory:
                result = items.search((Product product) -> product.getFactory().equals(input.string("欲搜尋商品生產公司: ")));
                break;
            case Inventory:
                result = items.search((Product product) -> product.getInventory() > input.number("庫存下限: "));
                break;
            case Name:
                result = items.search((Product product) -> product.getName().equals(input.string("欲搜尋商品名稱")));
                break;
            case SerialNum:
                result = items.search((Product product) -> product.getSerialNum() >= input.numberInARange("最小流水號: ", 0, 2147483647) && product.getSerialNum() <= input.numberInARange("最大流水號: ", 0, 2147483647));
                break;
        }
        return result;
    }

    /**
     * 回傳被選取商品陣列
     * @param input
     * @param originalArr
     * @return
     */
    public static ProductArray pickItems(Input input, ProductArray originalArr) {
        //被選取商品陣列
        ProductArray pickItems = new ProductArray();
        //篩選後陣列
        ProductArray result = originalArr;
        //功能表
        int pickMenu = input.numberInARange("【1】篩選商品 【2】選取商品【3】取消所有篩選【4】執行: ", 1, 4);
        //enum
        Globol.PickItemMenu pickOpt = Globol.PickItemMenu.valueOf(pickMenu);
        final int execute = Globol.PickItemMenu.Execute.getIndex();

        //在執行前，可重複篩選並從中選取欲被執行動作的商品
        while (pickMenu != execute) {
            switch (pickOpt) {
                case FilterItems:
                    result = filterItems(input, result);
                    break;
                case PickItems:
                    int pickIndex = input.numberInARange("取得指定位置商品資訊: ", 1, result.getCount());
                    pickItems.add(result.get(pickIndex));
                    break;
                case CancelFilter:
                    result = originalArr;
                    break;
            }
            pickMenu = input.numberInARange("【1】篩選商品 【2】選取商品【3】取消所有篩選【4】執行: ", 1, 4);
            pickOpt = Globol.PickItemMenu.valueOf(pickMenu);
        }
        return pickItems;
    }
}
