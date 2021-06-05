package org.hdeogratias.encrypt.starter.resp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hdeogratias.encrypt.starter.anno.Encrypt;
import org.hdeogratias.encrypt.starter.modal.R;
import org.hdeogratias.encrypt.starter.prop.EncryptProperties;
import org.hdeogratias.encrypt.starter.utils.AESUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * @author H-DeoGratias
 * @create 2021-06-05 16:53
 */
@EnableConfigurationProperties(EncryptProperties.class)
@ControllerAdvice
public class EncryptResponse implements ResponseBodyAdvice<R> {
    private ObjectMapper om = new ObjectMapper();
    @Autowired
    EncryptProperties encryptProperties;
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(Encrypt.class);
    }

    @Override
    public R beforeBodyWrite(R body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        byte[] keyBytes = encryptProperties.getKey().getBytes();
        try {
            if (body.getMessage()!=null) {
                body.setMessage(AESUtils.encrypt(body.getMessage().getBytes(),keyBytes));
            }
            if (!body.getData().keySet().isEmpty()) {
                HashMap<String,Object> map = new HashMap<>();
                String key = body.getData().keySet().iterator().next();
                Object val = body.getData().values().iterator().next();
                map.put(key,AESUtils.encrypt(om.writeValueAsBytes(val), keyBytes));
                body.setData(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}
