package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Common lookup value")
public class LookupDto {

    @Schema(
            description = "Unique lookup code",
            example = "ACTIVE"
    )
    private String code;

    @Schema(
            description = "Human-readable lookup description",
            example = "Active"
    )
    private String description;

}
