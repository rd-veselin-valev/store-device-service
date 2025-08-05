package com.example.store_device_service.service;

import com.example.store_device_service.dto.device.DeviceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DeviceService {
    DeviceDto getDeviceBySerialNumber(String serialNumber);

    Page<DeviceDto> getDevicesByCity(String city, Pageable pageable);

    Page<DeviceDto> getDevicesByMarketId(UUID marketId, Pageable pageable);
}
