package org.bussiness.system_backend.constants;

public class ConstantEnums {

    /**
     * 是否
     */
    public enum YesOrNot {
        是(1),否(0);

        private final int value;

        YesOrNot(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum MenuType {
        一级菜单(1),二级菜单(2);

        private final int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum UserStatus{
        正常(1),禁用(0);

        private final int value;

        UserStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
