package com.demo.Socket.RestApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
* {"data": {
*   "device_id" : "value",
*   "trigger" : "value",
*   },
*  "msg_id" : 775
*   }
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatDto {
    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("trigger")
    private String trigger;

}
