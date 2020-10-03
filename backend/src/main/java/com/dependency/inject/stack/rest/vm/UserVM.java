package com.dependency.inject.stack.rest.vm;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class UserVM {

    List<Integer> shiftsFreeTime;

    Instant timeOfService;

    Long id;

    Long departmentId;

}
