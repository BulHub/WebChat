package ru.bulat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Information {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String dateOfBirth;
    private String gender;
    private String country;
    private String aboutMySelf;
}
