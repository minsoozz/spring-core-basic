package hello.core.web;

import static java.lang.Thread.sleep;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest httpServletRequest) throws InterruptedException {
    String requestURL = httpServletRequest.getRequestURL().toString();

    System.out.println("myLogger = " + myLogger.getClass());

    sleep(10000);

    myLogger.setRequestURL(requestURL);
    myLogger.log("controller test");
    logDemoService.logic("testId");
    return "OK";
  }

}
