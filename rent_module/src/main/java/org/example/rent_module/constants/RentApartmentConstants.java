package org.example.rent_module.constants;

public class RentApartmentConstants {

    /**
     * URL's
     */
    public final static String REGISTRATION_APARTMENT_URL = "/registration_apartment";
    public final static String CHOOSE_DISCOUNT_URL = "/choose_discount";
    public final static String GET_FILE_URL = "/getFile/{id}";
    public final static String APARTMENTS_BY_LOCATION_URL = "/apartments_by_location";

    /**
     * Common column names
     */
    public static final String ID_COLUMN = "id";

    /**
     * AddressInfo entity constants
     */
    public static final String ADDRESS_INFO = "address_info";
    public static final String HOUSE_NUMBER_COLUMN = "house_number";
    public static final String REGISTRATION_DATE_COLUMN = "registration_date";
    public static final String APARTMENT_ID = "apartment_id";

    /**
     * ApartmentInfo entity constants
     */
    public static final String APARTMENT_INFO = "apartment_info";
    public static final String ROOMS_COUNT_COLUMN = "rooms_count";
    public static final String APARTMENT_INFO_MAPPING = "apartmentInfo";
    public static final String FILE_ID = "file_id";
    public static final String DEFAULT_AVAILABILITY = "false";

    /**
     * ApartmentAttachment entity constants
     */
    public static final String APARTMENT_ATTACHMENT = "apartment_attachment";
    public static final String FILE_COLUMN = "file";
    public static final String PHOTO_COLUMN = "photo";

    /**
     * UserPersonalData entity constants
     */
    public static final String USER_PERSONAL_DATA = "user_personal_data";
    public static final String DEFAULT_EMAIL_VERIFICATION = "false";

    /**
     * Integration info
     */
    public static final String INTEGRATION_INFO = "integration_info";

    /**
     * Sequences names
     */
    public static final String SEQUENCE = "Sequence";
    public static final String _SEQUENCE = "_sequence";
    public static final String ADDRESS_INFO_SEQUENCE = ADDRESS_INFO + SEQUENCE;
    public static final String ADDRESS_INFO_SEQUENCE_NAME = ADDRESS_INFO + _SEQUENCE;
    public static final String APARTMENT_INFO_SEQUENCE = APARTMENT_INFO + SEQUENCE;
    public static final String APARTMENT_INFO_SEQUENCE_NAME = APARTMENT_INFO + _SEQUENCE;
    public static final String APARTMENT_ATTACHMENT_SEQUENCE = APARTMENT_ATTACHMENT + SEQUENCE;
    public static final String APARTMENT_ATTACHMENT_SEQUENCE_NAME = APARTMENT_ATTACHMENT + _SEQUENCE;
    public static final String USER_PERSONAL_SEQUENCE = USER_PERSONAL_DATA + SEQUENCE;
    public static final String USER_PERSONAL_SEQUENCE_NAME = USER_PERSONAL_DATA + _SEQUENCE;

    /**
     * Mapper constants
     */
    public static final String REGISTRATION_DATE = "registrationDate";

    /**
     * Geo response constants
     */
    public static final String COMPONENTS = "components";

    /**
     * Messages
     */
    public final static String APARTMENT_SAVED_MESSAGE = "Апартаменты сохранены.";
    public final static String PATH_EXCEPTION_MESSAGE = "Путь для сохранения не доступен или не существует.";
    public static final String NO_SUCH_USER_WITH_GIVEN_TOKEN_MESSAGE = "Нет пользователя с таким токеном.";

    /**
     * Local file path
     */
    public final static String LOCAL_FILE_PATH = "rent_module/src/main/resources/fileStorage/";

    /**
     * Queries
     */
    public static final String USER_PERSONAL_DATA_QUERY = "select u from UserPersonalData u where u.token = :token";

    /**
     * IntegrationService constants
     */
    public static final String GEO = "GEO";
    public static final String KEY = "key";

    public final static String TOKEN_FIELD = "token";
    public final static String APARTMENT_INFO_REQUEST_PART = "apartmentInfo";
    public final static String FILE_REQUEST_PART = "file";

}
