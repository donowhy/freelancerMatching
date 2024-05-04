package com.freelancer.userservice.domain.users.entity;

import com.freelancer.userservice.domain.users.entity.enumType.AccountState;
import com.freelancer.userservice.domain.users.entity.enumType.Role;
import com.freelancer.userservice.domain.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 7)
    private String nickname;

    @NotBlank
    @Column(length = 7)
    private String name;

    @Column(length = 25, unique = true)
    private String email;

    @NotBlank
    @Column(length = 200)
    private String password;

    @NotBlank
    @Column(length = 13, unique = true)
    private String phone;

    @NotBlank
    @Column(length = 13)
    private String location;

    private LocalDateTime lastLogin;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private AccountState accountState;

    @NotBlank
    private String profileImage;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role role;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserInfo(String email, String nickname, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
    }
}
