package com.insta.clone.response;

import lombok.Data;

@Data
public class MessageResponse {
    
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }

}
