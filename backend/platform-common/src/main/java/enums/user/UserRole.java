package enums.user;

import enums.common.LookupEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole implements LookupEnum {

    SUPER_ADMIN ("SUPER_ADMIN", "Super Administrator"),

    ADMIN ("ADMIN", "Administrator"),

    CUSTOMER ("CUSTOMER", "Customer"),

    VENDOR ("VENDOR", "Vendor"),

    SUPPORT ("SUPPORT", "Support Agent");
    
    private final String code;
	private final String description;

}