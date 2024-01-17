package com.tree.gdhealth.utils.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**<p> 권한제어 애노테이션</p>
 * @apiNote 컨트롤러의 메소드 위에 작성합니다.
 * @author 정인호
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {
    Authority AUTHORITY();
}
