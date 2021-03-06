package com.SeniorProject.konutcheck.app.general.exceptionEnums;

public enum GeneralErrorMessage implements BaseErrorMessage{

    ENTITY_NOT_FOUND("Item not found!", "Item cannot find with this id."),
    INVALID_REQUEST("Invalid parameter", "The request sent with parameters is  incorrect."),
    INTERNAL_SERVER_ERROR("Encounter internal server", "Server encountered an unexpected condition that prevented it from fulfilling the request"),
    USER_NOT_FOUND("User not found!", "User cannot found with this id."),
    ID_NOT_FOUND("There is not anything with this id!", "This id not found anywhere."),
    HOME_INFOS_NOT_FOUND("Home information's id not found!","Home informations are not written."),
    HOME_ADDRESS_NOT_FOUND("Home address not found with this id!","Home address not added."),
    AGE_CANNOT_BE_ZERO("Age cannot be zero!","Age cannot be zero or little than zero!"),
    CANNOT_BE_NEGATIVE("Value cannot be negative!","The value is little than zero but it must not."),
    ALREADY_USED("Email was used already!","Cannot register the same email that was used by another one."),
    PHONENUMBER_ALREADY_USED("Phone number was used already!","Cannot register the same phoneNumber that was used by another one."),
    HOME_NOT_FOUND ( "Home not found!", "There is no home related to this id." ),
    INVALID_USER_TYPE("Invalid user type!", "User type mus be tenant or landlord."),
    ID_NOT_MATCH("Id not match!", "Id may be null or not match."),
    INVALID_GRADE("Grade is not available!", "Grade must be between 0 - 5."),
    TOTAL_POINT_NOT_FOUND("Total point not found!","This user doesn't have evaluation."),
    USER_NOT_ACTIVE("User is not active", "User must be active!"),
    USER_IS_ACTIVE("User is active", "User is active so this is a invalid process!"),
    EVALUATION_WAS_MADE("This owner has an evaluation!", "Each owner can make one evaluation for home."),
    USER_MUST_BE_ACTIVE("User status isn't active", "In order to make evaluation, user status must be active"),
    ;

    private String errorMessage;
    private String messageDetails;

    GeneralErrorMessage(String errorMessage, String messageDetails) {
        this.errorMessage = errorMessage;
        this.messageDetails = messageDetails;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Override
    public String getDetailMessage() {
        return this.messageDetails;
    }

}
