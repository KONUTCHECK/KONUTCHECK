package com.SeniorProject.konutcheck.app.general.exceptionEnums;

public enum GeneralErrorMessage implements BaseErrorMessage{

    ENTITY_NOT_FOUND("Item not found!", "Item cannot find with this id."),
    INVALID_REQUEST("Invalid parameter", "The request sent with parameters is  incorrect."),
    INTERNAL_SERVER_ERROR("Encounter internal server", "Server encountered an unexpected condition that prevented it from fulfilling the request"),
    USER_NOT_FOUND("User not found!", "User cannot found with this id."),
    ID_NOT_FOUND("There is not anything with this id!", "This id not found anywhere."),
    HOME_INFOS_NOT_FOUND("Home information's id not found!","Home informations are not written."),
    AGE_CANNOT_BE_ZERO("Age cannot be zero!","Age cannot be zero or little than zero!"),
    CANNOT_BE_NEGATIVE("Value cannot be negative!","The value is little than zero but it must not."),
    ALREADY_USED("Email was used already!","Cannot register the same email that was used by another one."),
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
