package two.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@DiscriminatorValue("teacher")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter

public class Teacher extends Person {

    @NotBlank(message = "Teacher code is required")
    String teacherCode;

    @NotNull(message = "Teacher rank is required")
    @Enumerated(EnumType.STRING)
    TeacherRank teacherRank;

    @Positive(message = "Monthly salary must be positive")
    double monthlySalary;
}
