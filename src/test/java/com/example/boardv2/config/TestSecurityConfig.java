package com.example.boardv2.config;

import com.example.boardv2.dto.UserAccountDto;
import com.example.boardv2.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class  TestSecurityConfig {
    @MockBean private UserAccountService userAccountService;

    @BeforeTestMethod
    public void securitySetup() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(creatUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(creatUserAccountDto());
    }

    private UserAccountDto creatUserAccountDto() {
        return UserAccountDto.of(
                "m5s3Test",
                "password",
                "e@mail.com",
                "nickname",
                "memo"
        );
    }
}
