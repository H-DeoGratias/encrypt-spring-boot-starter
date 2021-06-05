package org.hdeogratias.encrypt.starter.modal;

/**
 * @author H-DeoGratias
 * @create 2021-06-05 16:40
 * @Gitee https://gitee.com/H-DeoGratias
 */
public enum ResponseEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"服务器内部错误");

    private Integer code;
    private String message;

    ResponseEnum() {
    }

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
