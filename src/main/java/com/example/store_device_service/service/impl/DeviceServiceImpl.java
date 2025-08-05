package com.example.store_device_service.service.impl;

import com.example.store_device_service.data.repository.DeviceRepository;
import com.example.store_device_service.dto.device.DeviceDto;
import com.example.store_device_service.service.DeviceService;
import com.example.store_device_service.util.message.ErrorMessages;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public DeviceDto getDeviceBySerialNumber(String serialNumber) {
        return deviceRepository.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorMessages.DEVICE_NOT_FOUND, serialNumber)));
    }

    @Override
    public Page<DeviceDto> getDevicesByCity(String city, Pageable pageable) {
        return deviceRepository.findAllByMarketCity(city, pageable);
    }

    @Override
    public Page<DeviceDto> getDevicesByMarketId(UUID marketId, Pageable pageable) {

        return deviceRepository.findAllByMarketId(marketId, pageable);
    }
}
