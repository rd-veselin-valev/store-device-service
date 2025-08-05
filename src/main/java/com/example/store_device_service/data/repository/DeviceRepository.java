package com.example.store_device_service.data.repository;

import com.example.store_device_service.data.entity.Device;
import com.example.store_device_service.dto.device.DeviceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {

    @Query(value = """
            SELECT new com.example.store_device_service.dto.device.DeviceDto(
                d.id, d.type, m.id, s.id, s.serialNumber, s.ip,
                s.manufacturer, s.status, d.created, d.updated
            )
            FROM Device d
            JOIN d.market m
            JOIN d.specification s
            WHERE m.city = :city
            """,
            countQuery = """
                    SELECT COUNT(d)
                    FROM Device d
                    JOIN d.market m
                    WHERE m.city = :city
                    """
    )
    Page<DeviceDto> findAllByMarketCity(@Param("city") String city, Pageable pageable);

    @Query(value = """
            SELECT new com.example.store_device_service.dto.device.DeviceDto(
                d.id, d.type, m.id, s.id, s.serialNumber, s.ip,
                s.manufacturer, s.status, d.created, d.updated
            )
            FROM Device d
            JOIN d.market m
            JOIN d.specification s
            WHERE m.marketId = :marketId
            """,
            countQuery = """
                    SELECT COUNT(d)
                    FROM Device d
                    JOIN d.market m
                    WHERE m.marketId = :marketId
                    """
    )
    Page<DeviceDto> findAllByMarketId(@Param("marketId") UUID marketId, Pageable pageable);


    @Query("""
                SELECT new com.example.store_device_service.dto.device.DeviceDto(
                    d.id, d.type, d.market.id, d.specification.id, 
                    s.serialNumber, s.ip, s.manufacturer, s.status, 
                    d.created, d.updated
                )
                FROM Device d
                JOIN d.specification s
                WHERE s.serialNumber = :serialNumber
            """)
    Optional<DeviceDto> findBySerialNumber(@Param("serialNumber") String serialNumber);
}

