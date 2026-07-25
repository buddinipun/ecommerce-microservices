package enums.payment;

import enums.common.LookupEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus implements LookupEnum {

    PENDING ("PENDING", "Pending"),

    AUTHORIZED ("AUTHORIZED", "Authorized"),

    PAID ("PAID", "Paid"),

    FAILED ("FAILED", "Failed"),

    CANCELLED ("CANCELLED", "Cancelled"),

    REFUNDED ("REFUNDED", "Refunded");
    
    private final String code;	
	private final String description;

}