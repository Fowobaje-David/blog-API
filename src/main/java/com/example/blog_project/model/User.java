package com.example.blog_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@RequiredArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @NotBlank(message = "user must input name")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "password must be included")
    @Size(max = 10, message = "password must be up to 10 characters")
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    @NotNull(message = "Mobile must be included")
    @Size(max = 11, message = "mobile must be 11 numbers")
    private Long phonenumber;

}
