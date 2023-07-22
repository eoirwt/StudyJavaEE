package exceptionLink;


public class B {
    public void b(){
        A a = new A();
        try {
            a.a();
        }catch (CustomException1 e){
            // 捕获 CustomException1, 抛出 CustomException2, 并保存CustomException1的原始信息
            // customException2 就由多个异常组成的链条，这就是异常链
            CustomException2 customException2 = new CustomException2("业务发生重大问题!", e, 204);
            throw customException2;
        }

    }
}
