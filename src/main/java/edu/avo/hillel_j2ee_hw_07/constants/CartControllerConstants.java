package edu.avo.hillel_j2ee_hw_07.constants;

public class CartControllerConstants {

    private CartControllerConstants() {
    }

    public static class InfoMessages {
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String CART_ERROR = "cartError";
        public static final String CART_DTO = "cartDTO";
        public static final String CART_MESSAGE = "cartMessage";
        public static final String MESSAGE = "message";
        public static final String CART_ID = "cartId";


        private InfoMessages() {
        }
    }

    public static class ErrorMessages {

        public static final String MAIN_FIELDS_ARE_EMPTY = "Main fields are empty";
        public static final String CART_NOT_FOUND = "Cart not found";
        public static final String CART_OR_PRODUCT_IS_NOT_FOUND = "Cart or Product is not found";

        private ErrorMessages() {
        }

    }

}
