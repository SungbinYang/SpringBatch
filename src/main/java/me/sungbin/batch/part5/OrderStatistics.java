package me.sungbin.batch.part5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class OrderStatistics {

    private String amount;

    private LocalDate date;
}
