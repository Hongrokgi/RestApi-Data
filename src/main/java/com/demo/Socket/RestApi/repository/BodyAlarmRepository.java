package com.demo.Socket.RestApi.repository;

import com.demo.Socket.RestApi.domain.entity.BodyAlarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyAlarmRepository extends JpaRepository<BodyAlarm, Long> {
}
