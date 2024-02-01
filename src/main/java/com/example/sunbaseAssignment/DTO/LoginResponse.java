package com.example.sunbaseAssignment.DTO;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    String token;

    String username;


}
