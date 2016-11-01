package demo.kanban.contract.moscow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by xchou on 5/16/16.
 */
@Controller
@RequestMapping("/error")
public class MyErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {


    @RequestMapping(method = RequestMethod.GET)
    public String error(HttpSession session) {
        System.out.println("ERROR session : test " + session.getAttribute("test").toString());

        return "ERROR!";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
