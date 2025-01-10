package com.todo.taskmanager.controller.advertisementController.DTO;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ADVRequest {

    private Long carId;
    private Long userId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
