package com.tree.gdhealth.utils.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**<p>접근제어 에러시 에러페이지 이동시키기 위한 컨트롤러</p>
 * @author 정인호
 */
@Controller
public class AuthController {

    @GetMapping("/error/noAuth")
    public String getErrorPage(){
        return "/error/noAuth";
    }
}
