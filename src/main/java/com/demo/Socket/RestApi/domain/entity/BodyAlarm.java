package com.demo.Socket.RestApi.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BodyAlarm {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cameraName;

    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String trigger;

    @Builder
    public BodyAlarm(String cameraName, String channel, String deviceId, String trigger) {
        this.cameraName = cameraName;
        this.channel = channel;
        this.deviceId = deviceId;
        this.trigger = trigger;
    }
}
