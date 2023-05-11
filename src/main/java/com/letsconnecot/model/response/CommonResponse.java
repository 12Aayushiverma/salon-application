package com.letsconnecot.model.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    private Object data;

    private String message;

    private int statusCode;
}
