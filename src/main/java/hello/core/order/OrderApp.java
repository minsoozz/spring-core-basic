package hello.core.order;

import hello.core.AppConfig;
import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;

public class OrderApp {

  public static void main(String[] args) {

    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);
    System.out.println("order.calculatorPrice() = " + order.calculatorPrice());
  }
}
