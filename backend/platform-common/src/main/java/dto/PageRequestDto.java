package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Pagination request")
public class PageRequestDto {

    @Min(value = 0, message = "Page number cannot be negative")
    @Schema(
            description = "Zero-based page number",
            example = "0",
            defaultValue = "0"
    )
    @Builder.Default
    private int page = 0;


    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size cannot exceed 100")
    @Schema(
            description = "Number of records per page",
            example = "20",
            defaultValue = "20"
    )
    @Builder.Default
    private int size = 20;


    @Valid
    private SortRequestDto sort;

}
