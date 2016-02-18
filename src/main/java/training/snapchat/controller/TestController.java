package training.snapchat.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.snapchat.entity.Tests;

@Controller
public class TestController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public HttpEntity<Tests> printWelcome() {
    Tests c = new Tests();
    c.setName("test");
    HttpEntity<Tests> x = new HttpEntity<Tests>(c);
    return x;

  }

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String index() {
    return "index";
  }

}
