package com.demo.Socket.RestApi.controller;

import com.demo.Socket.RestApi.domain.dto.Face774Dto;
import com.demo.Socket.RestApi.domain.dto.HeartbeatDto;
import com.demo.Socket.RestApi.domain.dto.Body774Dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*  192.168.0.203:8080/test */
/*  msgId.equals("774")
 *
 *
 * */
@Slf4j
@RestController
public class ApiController {
    @PostMapping("/test")
    public ResponseEntity<Void> test(MultipartHttpServletRequest request) throws Exception {
        log.info("====== Data push ======");
//        MultipartFile snap = request.getFile("snap");
        String json = request.getParameter("json");
        JsonNode parent = new ObjectMapper().readTree(json);
        String msgId = String.valueOf(parent.findValue("msg_id")); //TODO: 774 or 775
        JsonNode data = parent.findValue("data");
        ObjectMapper objectMapper = new ObjectMapper();
        switch (msgId) {
            case "774":
                JsonNode body_attr = data.findValue("body_attr");
                JsonNode face_attr = data.findValue("face_attr");
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                if(body_attr == null) {
                    if(face_attr.size() == 0) {
                        log.info("No face_attr");
                    }else {
                        log.info("face_attr.size() :"+face_attr.size());
                        try{
                            Face774Dto face774Dto = objectMapper.treeToValue(data, Face774Dto.class);
                            log.info("**** Change Data to Face774Dto ****");
                        } catch (JsonProcessingException e) {
                            log.info("Json parse error");
                        }
                    }
                }else {
                    if(body_attr.size() == 0) {
                        log.info("No body_attr");
                    }else {
                        log.info("body_attr.size() :"+body_attr.size());
                        try{
                            Body774Dto body774Dto = objectMapper.treeToValue(data, Body774Dto.class);
                            log.info("**** Change Data to Body774Dto ****");
                        }catch (JsonProcessingException e) {
                            log.info("Json parse error");
                        }
                    }
                }
                break;
            case "775":
                HeartbeatDto heartbeatDto = objectMapper.treeToValue(data, HeartbeatDto.class);
                log.info("**** Change Data to HeartbeatDTO ****");
                break;
        }
        log.info("**** Pushing Data is ended ****");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
