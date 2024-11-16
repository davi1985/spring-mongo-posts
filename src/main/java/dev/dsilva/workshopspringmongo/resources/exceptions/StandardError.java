package dev.dsilva.workshopspringmongo.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1500100657361740988L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
