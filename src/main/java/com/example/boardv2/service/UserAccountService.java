package com.example.boardv2.service;

import com.example.boardv2.domain.UserAccount;
import com.example.boardv2.dto.UserAccountDto;
import com.example.boardv2.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    @Transactional
    public UserAccountDto saveUser(String userId, String userPassword, String email, String nickname, String memo) {
        return UserAccountDto.from(
          userAccountRepository.save(UserAccount.of(userId, userPassword, email, nickname, memo, userId))
        );
    }
}
