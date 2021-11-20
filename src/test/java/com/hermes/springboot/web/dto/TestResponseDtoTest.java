package com.hermes.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "이름";
        int amount = 3;

        // when
        TestResponseDto dto = new TestResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
