package two.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

public class Teacher extends Person{

     String teacherCode;
    @Enumerated(EnumType.STRING)
     TeacherRank teacherRank;
     double monthlySalary;
}
