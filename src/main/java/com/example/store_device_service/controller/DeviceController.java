package com.example.store_device_service.controller;

import com.example.store_device_service.dto.device.DeviceDto;
import com.example.store_device_service.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/{serialNumber}")
    public ResponseEntity<DeviceDto> getDeviceBySerialNumber(@PathVariable String serialNumber) {
        return ResponseEntity.ok(deviceService.getDeviceBySerialNumber(serialNumber));
    }

    @GetMapping("/market/{marketId}")
    public ResponseEntity<Page<DeviceDto>> getDevicesByMarketId(@PathVariable UUID marketId, Pageable pageable) {
        return ResponseEntity.ok(deviceService.getDevicesByMarketId(marketId, pageable));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<Page<DeviceDto>> getDevicesByCity(@PathVariable String city, Pageable pageable) {
        return ResponseEntity.ok(deviceService.getDevicesByCity(city, pageable));
    }
}
