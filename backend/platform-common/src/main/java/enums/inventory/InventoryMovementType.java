package enums.inventory;

import enums.common.LookupEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum InventoryMovementType implements LookupEnum{

	PURCHASE("PURCHASE", "purchase"),

	SALE("SALE", "sale"),

	RETURN("RETURN", "return"),

	ADJUSTMENT("ADJUSTMENT", "adjustment"),

	DAMAGE("DAMAGE", "damage"),

	TRANSFER("TRANSFER", "transfer"),

	RESERVATION("RESERVATION", "reservation"),

	RELEASE("RELEASE", "release");

	private final String code;

	private final String description;

}