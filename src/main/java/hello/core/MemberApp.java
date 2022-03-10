package hello.core;

import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {

//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("member.getName() = " + member.getName());
    System.out.println("findMember.getName() = " + findMember.getName());
  }
}
