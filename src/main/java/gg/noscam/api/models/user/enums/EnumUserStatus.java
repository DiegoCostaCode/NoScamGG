package gg.noscam.api.models.user.enums;

public enum EnumUserStatus {
    ACTIVE("Active"),
    RESTRICTED("Restricted"),
    BANNED("Banned");

    private final String status;

    EnumUserStatus(String status) {
        this.status = status;
    }

}
