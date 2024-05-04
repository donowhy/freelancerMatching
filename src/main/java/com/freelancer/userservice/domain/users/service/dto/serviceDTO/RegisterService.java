package com.freelancer.userservice.domain.users.service.dto.serviceDTO;

import com.freelancer.userservice.domain.users.entity.enumType.Jobs;
import lombok.Builder;

@Builder(toBuilder = true)
public record RegisterService(
        String nickname,

        Jobs job,

        String phone,
        String email,
        String password,

        boolean gender
) {
}
