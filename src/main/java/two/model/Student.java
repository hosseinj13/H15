package two.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Entity
@DiscriminatorValue("student")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter

public class Student extends Person {

    @NotBlank(message = "Student code is required")
    @Size(min = 6, max = 10, message = "Student code must be between 6 and 10 characters")
    String studentCode;

    @NotBlank(message = "Field of study is required")
    String fieldOfStudy;

    @NotNull(message = "Entrance year is required")
    @Positive(message = "Entrance year must be positive")
    @Min(value = 1900, message = "Entrance year must be greater than or equal to 1900")
    int entranceYear;


}
