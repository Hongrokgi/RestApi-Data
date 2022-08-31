package com.demo.Socket.RestApi.controller;

import com.demo.Socket.RestApi.dto.HeartbeatDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.DataInput;
import java.util.List;

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
//        String key = request.getParameter("key");
        String json = request.getParameter("json");
        JsonNode parent = new ObjectMapper().readTree(json);
        String msgId = String.valueOf(parent.findValue("msg_id")); //TODO: 774 or 775
        JsonNode data = parent.findValue("data");
        ObjectMapper objectMapper = new ObjectMapper();
        switch (msgId) {
            case "774":
                System.out.println("====================");
                break;
            case "775":
                HeartbeatDto heartbeatDto = objectMapper.treeToValue(data, HeartbeatDto.class);
                System.out.println("heartbeatDto = " + heartbeatDto);
                System.out.println("heartbeatDto.getDeviceId() = " + heartbeatDto.getDeviceId());
                System.out.println("heartbeatDto.getTrigger() = " + heartbeatDto.getTrigger());
                log.info("**** Change Json to DTO ***");
                break;
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
