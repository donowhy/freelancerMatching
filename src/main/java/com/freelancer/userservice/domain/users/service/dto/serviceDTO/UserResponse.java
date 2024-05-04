package com.freelancer.userservice.domain.users.service.dto.serviceDTO;

import com.freelancer.userservice.domain.users.entity.Users;
import com.freelancer.userservice.domain.users.entity.enumType.Jobs;
import lombok.Builder;

@Builder(toBuilder = true)
public record UserResponse(
      String nickname,
      Jobs job,
      String phone,
      boolean gender
){

    public static UserResponse of (Users user) {
        return UserResponse.builder()
                .nickname(user.getNickname())
                .job(user.getJob())
                .phone(user.getPhone())
                .gender(user.getGender())
                .build();
    }
}
