package com.bookSmart.reserva.utils;

import com.bookSmart.reserva.DTO.APIResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity extends ResponseEntity<APIResponseDTO> {

    /**
     * Construye un ResponseEntity personalizado que devuelve el objeto de la operación + message personalizado + código estado
     * @param object resultado de la consulta/operación realizada
     * @param message personalizado de la operación realizada
     * @param status código de estado de la operación realizada
     */
    public CustomResponseEntity(Object object, String message, HttpStatus status){
        super(new APIResponseDTO(status.value(), message, object), status);
    }

    /**
     * Construye un ResponseEntity personalizado que devuelve el objeto de la operación + status message default + codigo estado
     * @param object resultado de la consulta/operación realizada
     * @param status código de estado de la operación realizada
     */
    public CustomResponseEntity(Object object, HttpStatus status) {
        super(new APIResponseDTO(status.value(), getStatusMessage(status), object),status);
    }

    /**
     * Devuelve un mensaje en base al código de estado obtenido en la operación
     * @param status
     * @return String salida de la operación
     */
    public static String getStatusMessage(HttpStatus status){
        if(status.is2xxSuccessful()){
            return "Operation was successfully created";
        }
        else if(status.is4xxClientError()){
            return "Client error occurred";
        }
        else if(status.is5xxServerError()){
            return "Server error occurred";
        } else{
            return "Unknown error occurred";
        }
    }
}
