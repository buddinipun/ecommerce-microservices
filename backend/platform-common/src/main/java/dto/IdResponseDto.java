package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response containing a resource identifier")
public class IdResponseDto {

    @Schema(
            description = "Unique resource identifier",
            example = "550e8400-e29b-41d4-a716-446655440000"
    )
    private UUID id;

}
