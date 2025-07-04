package com.example.roomwebapp.aysnc;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.roomwebapp.service.RoomService;
import com.example.roomwebapp.web.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }
    //接收消息，判断消息类型是不是“ROOM”
    public void receiveMessage(String message){
        try{
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if("ROOM".equals(payload.getModel())){
                Room room = roomService.getRoomById(payload.getId());
                LOG.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            }else{
                LOG.warn("Unknown model type");
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}

