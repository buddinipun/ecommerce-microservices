package enums.order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PENDING("PENDING", "Pending"),

    CONFIRMED("CONFIRMED", "Confirmed"),

    PROCESSING("PROCESSING", "Processing"),

    PACKED("PACKED", "Packed"),

    SHIPPED("SHIPPED", "Shipped"),

    OUT_FOR_DELIVERY("OUT_FOR_DELIVERY", "Out for Delivery"),

    DELIVERED("DELIVERED", "Delivered"),

    CANCELLED("CANCELLED", "Cancelled"),

    RETURNED("RETURNED", "Returned"),

    REFUNDED("REFUNDED", "Refunded");

    private final String code;
    private final String description;
}