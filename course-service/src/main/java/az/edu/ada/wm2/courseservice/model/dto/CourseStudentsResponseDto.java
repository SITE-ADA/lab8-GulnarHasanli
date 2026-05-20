package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Kursa yazılmış tələbələrin siyahısını qaytaran DTO")
public class CourseStudentsResponseDto {

    @Schema(description = "Kurs ID-si", example = "1")
    private Long courseId;

    @Schema(description = "Kursun adı", example = "Data Structures")
    private String courseTitle;

    @Schema(description = "Kursa qeydiyyatdan keçmiş tələbələrin siyahısı")
    private List<StudentDto> students;
}