package two.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "First name is required and should contain only letters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName must contain only letters")
    String firstName;

    @NotBlank(message = " lastName is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contain only letters")
    String lastName;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    Date dateOfBirth;
}
