package zerobase.reservation.dto;

import lombok.*;
import zerobase.reservation.type.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class Signup {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
        @NotBlank
        private String name;

        @Enumerated(EnumType.STRING)
        private Role role;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String userId;
        private String name;
        private Role role;

        public static Response fromDto(MemberDto memberDto) {
            return Response.builder()
                    .name(memberDto.getName())
                    .userId(memberDto.getUserId())
                    .role(memberDto.getRole())
                    .build();
        }
    }
}
