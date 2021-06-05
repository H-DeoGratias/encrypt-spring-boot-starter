package org.hdeogratias.encrypt.starter.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author H-DeoGratias
 * @create 2021-06-05 16:46
 * @Gitee https://gitee.com/H-DeoGratias
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Encrypt {
}
