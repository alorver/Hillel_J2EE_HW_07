package edu.avo.hillel_j2ee_hw_07.constants;

public class PersonControllerConstants {

    private PersonControllerConstants() {
    }

    public static class InfoMessages {
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String PERSON_ERROR = "personError";
        public static final String PERSON_DTO = "personDTO";
        public static final String PERSON_MESSAGE = "personMessage";
        public static final String MESSAGE = "message";
        public static final String PERSON_ID = "personId";


        private InfoMessages() {
        }
    }


    public static class ErrorMessages {
        public static final String PERSON_NOT_FOUND = "Person not found";
        public static final String PERSON_OR_CART_IS_NOT_FOUND = "Person or Cart is not found";

        public static final String MAIN_FIELDS_ARE_EMPTY = "Main fields are empty";


        private ErrorMessages() {
        }

    }

}
