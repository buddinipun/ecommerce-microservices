package dto;

import enums.common.SortDirection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Sorting request")
public class SortRequestDto {

    @Schema(
            description = "Field to sort by",
            example = "createdAt"
    )
    private String field;

    @Schema(
            description = "Sorting direction",
            example = "DESC"
    )
    @Builder.Default
    private SortDirection direction =
            SortDirection.DESC;

}