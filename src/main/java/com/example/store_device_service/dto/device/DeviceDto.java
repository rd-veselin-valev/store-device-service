package com.example.store_device_service.dto.device;

import com.example.store_device_service.data.enums.DeviceManufacturer;
import com.example.store_device_service.data.enums.DeviceStatus;
import com.example.store_device_service.data.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {
    private UUID id;

    private DeviceType type;

    private int marketId;

    private int specificationId;

    private String serialNumber;

    private String ip;

    private DeviceManufacturer manufacturer;

    private DeviceStatus status;

    private LocalDateTime created;

    private LocalDateTime updated;
}
