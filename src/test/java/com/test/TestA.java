package com.test;

import org.junit.Assert;
import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;

public class TestA {
	@Test
    public void t1() {  
        MockUp<IStudentService> proxyStub = new MockUp<IStudentService>() {  
            // 需要使用@Mock标记,否则jmockit不会处理;  
            // 而且方法的签名必须与接口中方法签名一致，否则jmockit会报错  
            @Mock  
            public String getName(int id) {
                return "00" + id;  
            }  
        };  
  
        IStudentService mockInstance = proxyStub.getMockInstance();
        Assert.assertEquals("001", mockInstance.getName(1));  
        Assert.assertEquals(0, mockInstance.getAge(1));  
        proxyStub.tearDown();  
    }  
  
    @Test
    public void t2() {  
        MockUp<AbstractStudentService> proxyStub = new MockUp<AbstractStudentService>() {  
            @Mock  
            public int getAge(int id) {
                return 10 * id;  
            }  
        };  
  
        AbstractStudentService mockInstance = proxyStub.getMockInstance();  
  
        Assert.assertEquals("ATY", mockInstance.getName(1));  
  
        Assert.assertEquals(10, mockInstance.getAge(1));  
  
        proxyStub.tearDown();  
    }  
}
