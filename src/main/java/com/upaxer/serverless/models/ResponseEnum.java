package com.upaxer.serverless.models;

public enum ResponseEnum {
	REQUEST_NO_VALIDO(500,1,"E001","Request no valido","Excepción que indica que el cuerpo del request es null o vacio",false),
    TOKEN_NO_VALIDO(500,3,"E003","Token no valido","El token de la solicitud es null o vacío,inactivo,no válido",false),
    ERROR_AL_GUARDAR_ACTUALIZAR(500,4,"E004","Error al guardar/actualizar","Id padre no existe",false),
    ERROR_AL_DESHABILITAR(500,5,"E005","Error al deshabilitar","Error al deshabilitar la encuentas o elementos de la encuesta",false),
    CREDENCIALES_NO_VALIDAS(500,6,"E006","Credenciales no validas","No se permite el acceso al usuario",false),
    RECURSO_DEHABILITADO(500,7,"E007","Recurso dehabilitado","El recurso se encuentra deshabilitado",false),
    ERROR_DE_COMUNICACION(500,8,"E008","Error de comunicacion","Error de comunicación con servicios",false),
    EXITO(200,9,"200","Exito","Operación realizada con éxito",true),
    ERROR_AL_OBTENER_LA_ENCUESTA(500,11,"E010","Error al obtener la encuesta","Error al obtener la encuesta",false),
    ERROR_AL_OBTENER_LAS_RESPUESTA(500,12,"E011","Error al obtener las respuesta","Error al obtener las respuestas de la encuesta",false),
    ERROR_INTERNO(500,13,"E012","Error interno","Error al procesar la petición",false),
    SIN_INFORMACION(500,15,"E014","Sin información","Error, la encuesta no existe",false),
    ERROR_EN_EL_NOMBRE_DE_LA_ENCUESTA(500,16,"E015","Error en el nombre de la encuesta","Error, nombre de la encuesta duplicado",false),
    ERROR(500,17,"500","Error","Error en la petición",false),
    ERROR_AL_ENVIAR_EL_EMAIL(500,18,"EMAIL_ERROR1","Error al enviar el email","Error al enviar correo electrónico, verifique con el administrador",false),
    NO_SE_ENCONTRARON_DATOS(500,19,"NO_DATA_FOUND","No se encontraron datos","No se encontraron datos",false),
    NO_SE_ACTUALIZARON_DATOS(500,20,"NO_UPDATE","No se actualizaron datos","No se encontraron registros para actualizar con esos datos",false),
    REGISTROS_REPETIDOS(500,21,"20000","Registros repetidos","Los registros son repetidos",false),
    ERROR_AL_INTENTAR_GUARDAR_LA_ENCUESTA(500,22,"LCE-01","Error al intentar guardar la encuesta","Error al intentar guardar la encuesta",false),
    NO_SE_ENCONTRO_ASIGNACION(500,24,"NO_ASSIGN_FOUND","No se encontró asignación","No se encontró asignación para este usuario",false),
    INIT_FUNCTION_ID_INVALID(500,25,"NO_SAP_FUNCTION","INIT_FUNCTION_ID_INVALID","No tiene asociada una función SAP, valida información",false),
    VALIDATION_OUTDATED_DATE(500,26,"INVALID_HOUR","VALIDATION_OUTDATED_DATE","No puedes recibir prospectos. ",false),
    VALIDATION_LOCATION_INVALID(500,27,"INVALID_LOCATION","VALIDATION_LOCATION_INVALID","No tienes asociada una sucursal.",false),
    VALIDATION_CECO_INVALID(500,28,"INVALID_CECO","VALIDATION_CECO_INVALID","No estás asociado a CECO de una sucursaL",false);

    ResponseEnum(int code,
                 long id,
                 String sCode,
                 String message,
                 String description,
                 boolean success) {
        this.code = code;
        this.id = id;
        this.sCode = sCode;
        this.message = message;
        this.description = description;
        this.success = success;
    }

    private int code;
    private long id;
    private String  sCode;
    private String message;
    private String description;
    private boolean success;

    public int getCode() {
        return code;
    }

    public long getId() {
        return id;
    }

    public String getsCode() {
        return sCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSuccess() {
        return success;
    }
}

