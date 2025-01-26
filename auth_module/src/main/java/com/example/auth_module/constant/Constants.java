package com.example.auth_module.constant;

public class Constants {

    /**
     * AuthController constants.
     */
    public static final String BASE_URL = "/auth";
    public static final String USER_REGISTRATION_URL = BASE_URL + "/registration";
    public static final String USER_AUTHENTICATION_URL = BASE_URL + "/authentication";
    public static final String CONFIRMATION_OF_REGISTRATION_URL = BASE_URL + "/reg_confirm";

    /**
     * Exception constants.
     */
    public static final String BASE_EXCEPTION_MESSAGE = "There is already a user with this ";
    public static final String NOT_UNIQUE_LOGIN = BASE_EXCEPTION_MESSAGE + "login.";
    public static final String NOT_UNIQUE_EMAIL = BASE_EXCEPTION_MESSAGE + "email.";
    public static final String INCORRECT_USER = "Incorrect user.";
    public static final String INCORRECT_PASSWORD = "Incorrect password.";
    public static final String INCORRECT_EMAIL = "Incorrect email.";
    public static final String UNCONFIRMED_EMAIL = "Unconfirmed email. For authentication the user should confirm his/her email.";

    public static final int CODE_602 = 602; // NOT_UNIQUE_LOGIN
    public static final int CODE_603 = 603; // NOT_UNIQUE_EMAIL
    public static final int CODE_604 = 604; // INCORRECT_PASSWORD
    public static final int CODE_605 = 605; // INCORRECT_PASSWORD
    public static final int CODE_606 = 606; // INCORRECT_EMAIL
    public static final int CODE_607 = 607; // UNCONFIRMED_EMAIL

    /**
     * AuthService constants.
     */
    public static final String BASE_AUTH_MESSAGE = "The user has been successfully ";
    public static final String USER_REGISTRATION_SUCCESS = BASE_AUTH_MESSAGE + "registered.";
    public static final String USER_AUTHENTICATION_SUCCESS = BASE_AUTH_MESSAGE + "authenticated.";

    /**
     * Aspect constants.
     */
    public static final String POINT_CUT = "execution(* com.example.auth_module.service.impl.AuthServiceImpl.userRegistration(..))";
    public static final String RESULT = "result";

    /**
     * Entity constants
     */
    public static final String USER_PERSONAL_DATA_SEQUENCE = "user_personal_dataSequence";
    public static final String USER_PERSONAL_DATA_SEQUENCE_NAME = "user_personal_data_sequence";
    public static final String ID_COLUMN = "id";
    public static final String EMAIL_VERIFICATION_DEFAULT = "false";

    /**
     * Repository constants
     */
    public static final String FIND_USER_PERSONAL_DATA_BY_LOGIN = "select u from UserPersonalData u where u.login = :login";

    /**
     * ScheduleService constants
     */
    public static final String START = "Планировщик начал работу ";
    public static final String FINISH = "Планировщик завершил работу в ";
    public static final String NO_CURRENT_SESSIONS = "Нет текущих сессий.";
    public static final String DELIMITER = "|";
    public static final String USER_TOKEN = "Токен пользователя ";
    public static final String TOKEN_EXPIRED = " просрочен и был удалён.";

    /**
     * Integration constants
     */
    public static final String CONFIRMATION_REGISTRATION_SUBJECT = "Confirmation registration.";
    public static final String CONFIRMATION_BODY_MESSAGE = "Follow the link to confirm your registration - http://127.0.0.1:8089/auth/reg_confirm?user_email=";

    /**
     * Messages
     */
    public static final String SUCCESS_REGISTRATION = "SUCCESS REGISTRATION";

    /**
     * Request params
     */
    public static final String USER_EMAIL = "user_email";

}
