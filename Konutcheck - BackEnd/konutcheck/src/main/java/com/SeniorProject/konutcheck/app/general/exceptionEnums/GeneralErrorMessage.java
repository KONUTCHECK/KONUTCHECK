package com.SeniorProject.konutcheck.app.general.exceptionEnums;

public enum GeneralErrorMessage implements BaseErrorMessage{

    ENTITY_NOT_FOUND("Item not found!", "Item cannot find with this id."),
    INVALID_REQUEST("Invalid parameter", "The request sent with parameters is  incorrect."),
    INTERNAL_SERVER_ERROR("Encounter internal server", "Server encountered an unexpected condition that prevented it from fulfilling the request"),
    USER_NOT_FOUND("User not found!", "User cannot found with this id."),
    ID_NOT_FOUND("There is not this id!", "This id not found anywhere."),
    HOME_INFOS_NOT_FOUND("Such informations not found!","These informations are not written."),
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
