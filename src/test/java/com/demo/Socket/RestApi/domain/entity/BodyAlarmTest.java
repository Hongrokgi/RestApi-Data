package com.demo.Socket.RestApi.domain.entity;

import com.demo.Socket.RestApi.repository.BodyAlarmRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static com.demo.Socket.RestApi.domain.entity.QBodyAlarm.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class BodyAlarmTest {
    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Test
    public void Entity_Check() throws Exception {
        queryFactory = new JPAQueryFactory(em);
        //given
        BodyAlarm body1 = new BodyAlarm("IP카메라1","채널1","1","20220901");
        BodyAlarm body2 = new BodyAlarm("IP카메라2","채널2","2","20220901");
        BodyAlarm body3 = new BodyAlarm("IP카메라3","채널3","3","20220901");
        BodyAlarm body4 = new BodyAlarm("IP카메라4","채널4","4","20220901");
        //when
        em.persist(body1);
        em.persist(body2);
        em.persist(body3);
        em.persist(body4);

        em.flush();
        em.clear();

        BodyAlarm findBodyAlarm = queryFactory
                .selectFrom(bodyAlarm)
                .where(bodyAlarm.cameraName.eq("IP카메라1"))
                .fetchOne();
        //then
        assertThat(findBodyAlarm.getId()).isEqualTo(1);
        assertThat(findBodyAlarm.getCameraName()).isEqualTo("IP카메라1");
        assertThat(findBodyAlarm.getChannel()).isEqualTo("채널1");
        assertThat(findBodyAlarm.getDeviceId()).isEqualTo("1");
    }
}