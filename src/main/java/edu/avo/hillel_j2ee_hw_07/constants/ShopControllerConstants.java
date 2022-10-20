package edu.avo.hillel_j2ee_hw_07.constants;

public class ShopControllerConstants {

    private ShopControllerConstants() {
    }

    public static class InfoMessages {
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String SHOP_ERROR = "shopError";
        public static final String SHOP_DTO = "shopDTO";
        public static final String SHOP_MESSAGE = "shopMessage";
        public static final String MESSAGE = "message";
        public static final String SHOP_ID = "shopId";


        private InfoMessages() {
        }
    }


    public static class ErrorMessages {
        public static final String SHOP_NOT_FOUND = "Shop not found";
        public static final String SHOP_OR_PERSON_IS_NOT_FOUND = "Shop or Person is not found";
        public static final String SHOP_OR_PRODUCT_IS_NOT_FOUND = "Shop or Product is not found";
        public static final String MAIN_FIELDS_ARE_EMPTY = "Main fields are empty";


        private ErrorMessages() {
        }

    }

}
