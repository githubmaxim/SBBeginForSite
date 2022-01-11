package com.example.demo2.admin.service;

import com.example.demo2.dto.registration.LogPasDto;
import com.example.demo2.dto.users.UsersDto;
import com.example.demo2.repository.admin.LogPasRepository;
import com.example.demo2.service.admin.AdminService;
import com.example.demo2.service.admin.DefaultAdminService;
import com.example.demo2.service.registration.LogPasConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.demo2.admin.prototype.AdminPrtotypeFofUnitTest.aLogPas;
import static com.example.demo2.admin.prototype.AdminPrtotypeFofUnitTest.aLogPas2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultAdminServiceTest {

    private LogPasRepository logPasRepository;
    private LogPasConverter logPasConverter;
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        logPasRepository = mock(LogPasRepository.class);
        logPasConverter = new LogPasConverter();
        adminService = DefaultAdminService.builder().logPasRepository(logPasRepository).logPasConverter(logPasConverter).build();
    }

    @Test
    void putLogPasOK(){
        when(logPasRepository.findById(anyInt())).thenReturn(Optional.of(aLogPas()));
        String a = adminService.putLogPas(1, "ADMIN");
        assertThat(a).isEqualTo("OK");
    }

    @Test
    void deleteLogPas() {}
    @Test
    void findAll(){}
}
