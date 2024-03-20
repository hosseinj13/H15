package two.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@DiscriminatorValue("student")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter

public class Student extends Person{

     String studentCode;
     String fieldOfStudy;
     int entranceYear;

}
