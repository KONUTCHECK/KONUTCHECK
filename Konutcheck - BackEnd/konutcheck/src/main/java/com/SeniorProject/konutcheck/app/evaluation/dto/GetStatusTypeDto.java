package com.SeniorProject.konutcheck.app.evaluation.dto;

import com.SeniorProject.konutcheck.app.user.enums.StatusType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GetStatusTypeDto {
    private final StatusType statusType;
}
