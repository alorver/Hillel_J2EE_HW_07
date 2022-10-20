package edu.avo.hillel_j2ee_hw_07.constants;

public class ProductControllerConstants {

    private ProductControllerConstants() {
    }

    public static class InfoMessages {
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String PRODUCT_ERROR = "productError";
        public static final String PRODUCT_DTO = "productDTO";
        public static final String PRODUCT_MESSAGE = "productMessage";
        public static final String MESSAGE = "message";


        private InfoMessages() {
        }
    }


    public static class ErrorMessages {
        public static final String MAIN_FIELDS_ARE_EMPTY = "Main fields are empty";
        public static final String PRODUCT_NOT_FOUND = "Product not found";

        private ErrorMessages() {
        }

    }

}
