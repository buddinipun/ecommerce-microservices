package enums.user;

import enums.common.LookupEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType implements LookupEnum {

    HOME ("HOME", "Home Address"),

    OFFICE	("OFFICE", "Office Address"),

    BILLING ("BILLING", "Billing Address"),

    SHIPPING ("SHIPPING", "Shipping Address");
    
    private final String code;
	private final String description;

}