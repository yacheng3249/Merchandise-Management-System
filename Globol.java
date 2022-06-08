package week2.product;

/**
 * Enum
 */
public class Globol {
    /**
     * 功能表enum
     */
    public enum Menu {
        /** 新增商品 */
        AddProduct(1),
        /** 查詢商品 */
        SearchProduct(2),
        /** 批量修改庫存 */
        ModifyStock(3),
        /** 批量上下架 */
        ModifyShelf(4),
        /** 印出所有商品資訊 */
        PrintAllItems(5),
        /** 結束 */
        End(6);

        /**
         * 指標
         */
        private int index;

        /**
         * 建構子
         *
         * @param index
         */
        Menu(int index) {
            this.index = index;
        }

        /**
         * 取得輸入指標的值
         *
         * @param index
         * @return 功能表的值
         */
        public static Menu valueOf(int index) {
            for (Menu opt : Menu.values()) {
                if (opt.index == index) {
                    return opt;
                }
            }
            return null;
        }

        /**
         * index getter
         *
         * @return index
         */
        public int getIndex() {
            return index;
        }
    }

    /**
     * 篩選方法選擇
     */
    public enum Filter {
        /** 價格區間 */
        Price(1),
        /** 分類 */
        Category(2),
        /** 生產公司 */
        Factory(3),
        /** 庫存下限 */
        Inventory(4),
        /** 名稱 */
        Name(5),
        /** 流水號範圍 */
        SerialNum(6);

        /** 指標 */
        private int index;

        /**
         * 建構子
         *
         * @param index
         */
        Filter(int index) {
            this.index = index;
        }

        /**
         * 取得輸入指標的值
         *
         * @param index
         * @return 篩選方式的值
         */
        public static Filter valueOf(int index) {
            for (Filter opt : Filter.values()) {
                if (opt.index == index) {
                    return opt;
                }
            }
            return null;
        }
    }

    /**
     * 增加或減少庫存量選擇
     */
    public enum Action {
        /** 增加 */
        Increase(1),
        /** 減少 */
        Decrease(2);

        /** 指標 */
        private int index;

        /**
         * 建構子
         *
         * @param index
         */
        Action(int index) {
            this.index = index;
        }

        /**
         * 取得輸入指標的值
         *
         * @param index
         * @return 修改庫存量方式的值
         */
        public static Action valueOf(int index) {
            for (Action opt : Action.values()) {
                if (opt.index == index) {
                    return opt;
                }
            }
            return null;
        }
    }

    /**
     * 公司選單
     */
    public enum Factory {
        Company1(1, "company1"),
        Company2(2, "company2"),
        Company3(3, "company3"),
        Company4(4, "company4"),
        Company5(5, "company5");

        private int index;
        private String str;

        Factory(int index, String str) {
            this.index = index;
            this.str = str;
        }

        public static Factory valueOf(int index) {
            for (Factory opt : Factory.values()) {
                if (opt.index == index) {
                    return opt;
                }
            }
            return null;
        }

        public String getStr() {
            return str;
        }
    }


    /**
     * 篩選及選取功能
     */
    public enum PickItemMenu {
        FilterItems(1),
        PickItems(2),
        CancelFilter(3),
        Execute(4);

        private int index;

        PickItemMenu(int index) {
            this.index = index;
        }

        public static PickItemMenu valueOf(int index) {
            for (PickItemMenu opt : PickItemMenu.values()) {
                if (opt.index == index) {
                    return opt;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }
    }
}
