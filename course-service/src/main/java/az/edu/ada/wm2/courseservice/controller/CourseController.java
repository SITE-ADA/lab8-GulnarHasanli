package az.edu.ada.wm2.courseservice.controller;

import az.edu.ada.wm2.courseservice.model.dto.CourseRequestDto;
import az.edu.ada.wm2.courseservice.model.dto.CourseResponseDto;
import az.edu.ada.wm2.courseservice.model.dto.CourseStudentsResponseDto;
import az.edu.ada.wm2.courseservice.model.dto.EnrollmentResponseDto;
import az.edu.ada.wm2.courseservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(
        name = "Kurs əməliyyatları",
        description = "Kursların yaradılması, yenilənməsi, silinməsi və tələbələrin kurslara yazılması üçün API-lər"
)
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @Operation(
            summary = "Yeni kurs yarat",
            description = "Verilən məlumatlara əsasən sistemdə yeni kurs yaradır."
    )
    public ResponseEntity<CourseResponseDto> createCourse(@Valid @RequestBody CourseRequestDto requestDto) {
        CourseResponseDto createdCourse = courseService.createCourse(requestDto);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            summary = "Bütün kursları göstər",
            description = "Sistemdə mövcud olan bütün kursların siyahısını qaytarır."
    )
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/by-student-name")
    @Operation(
            summary = "Tələbə adına görə kursları göstər",
            description = "Verilən tələbə adına və ya soyadına uyğun tələbələri tapır və həmin tələbələrin qeydiyyatda olduğu kursları qaytarır."
    )
    public ResponseEntity<List<CourseResponseDto>> getCoursesByStudentName(@RequestParam String name) {
        return ResponseEntity.ok(courseService.getCoursesByStudentName(name));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Kursu ID-yə görə göstər",
            description = "Verilən ID-yə əsasən bir kursun məlumatlarını qaytarır."
    )
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Kursu yenilə",
            description = "Verilən ID-yə əsasən kurs məlumatlarını yeniləyir."
    )
    public ResponseEntity<CourseResponseDto> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDto requestDto) {
        return ResponseEntity.ok(courseService.updateCourse(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Kursu sil",
            description = "Verilən ID-yə əsasən kursu sistemdən silir."
    )
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    @Operation(
            summary = "Tələbəni kursa yaz",
            description = "Tələbəni kursa yazır, student-service vasitəsilə tələbə məlumatlarını yoxlayır və ön şərt kursunu tamamlayıb-tamamlamadığını yoxlayır."
    )
    public ResponseEntity<EnrollmentResponseDto> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId) {
        EnrollmentResponseDto responseDto = courseService.enrollStudent(courseId, studentId);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}/students")
    @Operation(
            summary = "Kursdakı tələbələri göstər",
            description = "Verilən kurs ID-yə əsasən həmin kursa yazılmış tələbələrin siyahısını qaytarır."
    )
    public ResponseEntity<CourseStudentsResponseDto> getCourseStudents(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseStudents(courseId));
    }
}