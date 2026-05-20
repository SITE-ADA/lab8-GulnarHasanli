package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Qeydiyyat nəticəsini qaytaran DTO")
public class EnrollmentResponseDto {

    @Schema(description = "Qeydiyyat ID-si", example = "10")
    private Long enrollmentId;

    @Schema(description = "Kurs ID-si", example = "1")
    private Long courseId;

    @Schema(description = "Tələbə ID-si", example = "15")
    private Long studentId;

    @Schema(description = "Əməliyyat nəticəsi mesajı", example = "Student enrolled successfully.")
    private String message;
}