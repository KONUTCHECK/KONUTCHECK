package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class GetTotalPoint {
    private final BigDecimal totalPoint;
}
