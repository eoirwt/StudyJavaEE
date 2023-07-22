package exceptionLink;

/**
 *
 */
public class C {
    public void c(){
        B b = new B();
        try {
            b.b();
        }catch (CustomException2 e) {
            e.printStackTrace();
            /*
            exceptionLink.CustomException2: 业务发生重大问题!
                at exceptionLink.B.b(B.java:12)
                at exceptionLink.C.c(C.java:10)
                at exceptionLink.Test.main(Test.java:9)
            Caused by: exceptionLink.CustomException1: 业务发生问题
                at exceptionLink.A.a(A.java:8)
                at exceptionLink.B.b(B.java:8)
	        ... 2 more
             */
        }
    }
}

