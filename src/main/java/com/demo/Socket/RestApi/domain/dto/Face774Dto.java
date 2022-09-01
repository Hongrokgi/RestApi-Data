package com.demo.Socket.RestApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Face774Dto {

    @JsonProperty("alarm_type")
    private int alarmType;                  // Face alarm type(0: no alarm, 1:blocklist/allowlist alarm, 3:matched stranger database alarm)

    @JsonProperty("alive_type")
    private int aliveType;                  // Type of liveness; 0:unKnown, 1:non-liveness, 2:liveness

    @JsonProperty("appear_count")
    private int appearCount;                // Frequency of current appearances

    @JsonProperty("camera_name")
    private String cameraName;              // Camera name

    @JsonProperty("channel")
    private String channel;                 // Channel; M4s range:[1,16], M8s range:[1,32]

    @JsonProperty("device_id")
    private String deviceId;                // Device ID

    @JsonProperty("event_type")
    private int eventType;                  // Event_Alarm(0: no alarm, 1: wandering alarm, 2:loitering alarm)

    @JsonProperty("face_attr")
    private FaceAttr faceAttr;              // When Obj_label is 1, facial attributes

    @JsonProperty("img_id")
    private String imgId;                   // the id or the face image in the matched database

    @JsonProperty("img_path")
    private String imgPath;                 // the base database image path(currently is a reserved field) to download images

    @JsonProperty("lib_id")
    private int libId;                      // database d

    @JsonProperty("lib_name")
    private String libName;                 // database name

    @JsonProperty("lib_type")
    private int libType;                    // Database type(1: allowlist, 2:blocklist)

    @JsonProperty("obj_label")
    private int objLabel;                   // Identification (1: face, 2:body, 8:fire, 9:fire extinguisher)

    @JsonProperty("ora_pos_bottom")
    private int oraPosBottom;

    @JsonProperty("ora_pos_left")
    private int oraPosLeft;

    @JsonProperty("ora_pos_right")
    private int oraPosRight;

    @JsonProperty("ora_pos_top")
    private int oraPosTop;

    @JsonProperty("person_addr")
    private String personAddress;           // Address

    @JsonProperty("person_age")
    private String personAge;               // Age

    @JsonProperty("person_gender")
    private String personGender;            // Gender(0:female, 1:male)

    @JsonProperty("person_idcard")
    private String personIdCard;            // Identify identification code

    @JsonProperty("person_name")
    private String personName;              // Name

    @JsonProperty("pos_bottom")
    private int posBottom;                  // Face coordinates bottom right Y

    @JsonProperty("pos_left")
    private int posLeft;                    // Face coordinates top left X

    @JsonProperty("pos_right")
    private int posRight;                   // Face coordinates bottom right X

    @JsonProperty("pos_top")
    private int posTop;                     // Face coordinates top left Y

    @JsonProperty("position")
    private String position;                // Camera position

    @JsonProperty("quality")
    private int quality;                    // Quality Score, range:[0,100]

    @JsonProperty("ranking")
    private int ranking;                    // Comparison similarity ranking

    @JsonProperty("similarity")
    private int similarity;                 // Similarity score with the base image, range[0,100]; default value is -1.

    @JsonProperty("snap_feat")
    private String snapFeat;                // Capture image features

    @JsonProperty("snap_id")
    private String snapId;                  // Capture image id

    @JsonProperty("snap_path")
    private String snapPath;                // Capture image path

    @JsonProperty("stranger_appear_channel")
    private int strangerAppearChannel;      // Stranger base database image capture channel

    @JsonProperty("threshold")
    private int threshold;                  // Comparison threshold(bound to the camera), range:[0,100]

    @JsonProperty("trigger")
    private String trigger;                 // Trigger time(capture time)

    @JsonProperty("wander_channels")
    private String wanderChannels;          // Wandering channel settings

    @JsonProperty("wander_deviceId")
    private String wanderDeviceId;          // Wandering channel name

    @JsonProperty("wander_threshold")
    private int wanderThreshold;            // Loitering threshold

    @JsonProperty("wander_trigger")
    private String wanderTrigger;           // Wandering stranger's appearance time;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    private class FaceAttr {

        @JsonProperty("cap_style")
        private String capStyle;            // hat_style_type_none : no / cap : yes

        @JsonProperty("gender_code")
        private String genderCode;          // female, male

        @JsonProperty("glass_style")
        private String glassStyle;          // glasses_style_type_none : without glasses / transparent_glasses : transparent glasses / sunglasses : sunglasses

        @JsonProperty("mustache_style")
        private String mustacheStyle;       // mustache_style_type_none : without mustache / whiskers : beard

        @JsonProperty("respirator_color")
        private String respiratorColor;

        @JsonProperty("st_age")
        private String stAge;               // Enum : st_old, st_adult, st_child

        @JsonProperty("st_age_value")
        private String stAgeValue;

        @JsonProperty("st_expression")
        private String stExpression;        // st_angry : angry / st_happy : happy / st_sorrow : sad / st_calm : calm / st_surprised : surprised / st_scared : scared / st_disgust : disappointed / st_yawn : yawning

        @JsonProperty("st_helmet_style")
        private String stHelmetStyle;       // st_helmet_style_type_none : without helmet / st_helmet : with helmet

        @JsonProperty("st_respirator")
        private String stRespirator;        // st_respirator_full : wearing properly / st_respirator_nose : not wearing properly / st_respirator_mouth : not wearing
    }
}
