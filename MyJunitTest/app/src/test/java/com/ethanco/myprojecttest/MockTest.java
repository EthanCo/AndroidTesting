package com.ethanco.myprojecttest;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * @Description Mockito 测试
 * Created by EthanCo on 2016/8/24.
 */
public class MockTest {
    @Mock
    List mockedList;

    @Test
    public void testMock() {
        //创建Mock对象 可用@Mock注解创建，比较简单
        //List mockedList = mock(List.class);

        //初始化@Mock注解的对象
        MockitoAnnotations.initMocks(this);

        //============================= Z-验证某些行为 ==============================/

        //使用Mock对象
        mockedList.add("one");
        mockedList.clear();

        //验证函数的调用次数
        verify(mockedList).add("one");
        //verify(mockedList).add("two"); 无此操作，验证 failed
        verify(mockedList).clear();

        //============================= Z-做一些桩测试 ==============================/

        //测试桩，在调用get(0)时返回"first"
        when(mockedList.get(0)).thenReturn("first");
        //调用get(1)时抛出异常
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //输出first
        System.out.println(mockedList.get(0));
        //抛出异常
        //System.out.println(mockedList.get(1));
        //因为get(999)没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        //============================= Z-参数匹配器 ==============================/

        //使用内置的anyInt()参数匹配器，当调用get(int)时都返回"element"
        when(mockedList.get(anyInt())).thenReturn("element");
        //使用自定义的参数器(在inValid()函数中返回你自己的匹配器实现)
        //when(mockedList.get(isValid())).thenReturn("element");

        //输出element
        System.out.println(mockedList.get(999));
        //也可以验证匹配器
        //verify(mockedList).get(anyInt());

        //============================= Z-验证函数的确切调用次数、最少调用、从未调用 ==============================/
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //下面两个的验证结果一样，因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //使用never验证，never相当于time(0)
        verify(mockedList, never()).add("never happened");

        //使用atLeast()/atMost
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("twice");
        verify(mockedList, atMost(5)).add("three times");

        List mockTwo = mock(List.class);
        //验证Mock对象没有交互过
        //verifyZeroInteractions(mockedList); //mockedList已交互过
        verifyZeroInteractions(mockTwo); //mockTwo没有交互过

        //============================= Z-为连续的调用做测试桩(Stub) ==============================/
        /*when(mockedList.get(anyInt()))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");*/

        /*//第一次调用:抛出运行时异常
        System.out.println(mockedList.get(0));
        //第二次调用:输出"foo"
        System.out.println(mockedList.get(1));
        //第三次调用:也是输出"foo"
        System.out.println(mockedList.get(2));*/

        //另外，连续调用的另一种更简短的方式
        when(mockedList.get(anyInt()))
                .thenReturn("one", "two", "three");

        //============================= Z-为回调做测试桩 ==============================/
        when(mockedList.get(anyInt())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                //获取函数调用的参数
                Object[] args = invocation.getArguments();
                //获得Mock对象本身
                Object mock = invocation.getMock();
                return "answer===>" + mock.toString();
            }
        });

        System.out.println(mockedList.get(50));

        //doReturn(),doThrow(),doAnswer(),doNothing(),noCallRealMethod()

        //============================= Z-Spy ==============================/
        //spy应尽量少用，可用来处理遗留代码 (没有使用mock生成的对象)
        List list = new LinkedList();

        //监控一个真实的对象
        List spy = spy(list);
        //可以为某些函数打桩
        when(spy.size()).thenReturn(100);

        //在监控真实对象上使用when会报错，可以使用onReturn、Answer、Throw()函数族来进行打桩
        //不能:因为当调用spy.get(0)时会调用真实对象的get(0)函数，此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
        //when(spy.get(0)).thenReturn("foo");
        doReturn("foo").when(spy).get(0);

        System.out.println(spy.get(0));

        //Mockito并不会为真实对象代理函数(Method)调用，实际上它会复制真实对象。
        //当你在监控一个真实对象时，你想为这个真实对象的函数做测试桩，那么就是在自找麻烦。

        //通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.size());

        //交互验证
        verify(spy).add("one");
        verify(spy).add("two");

        //============================= Z-为下一步的断言捕获参数 ==============================/
        //在某些场景中，不光要对方法的返回值和调用进行验证，同时需要验证一系列交互后所传入方法的参数。那么我们可以用参数捕获器来捕获传入方法的参数进行验证，看它是否符合我们的要求。
        //http://www.voidcn.com/blog/hotdust/article/p-5970898.html
        mockedList.add("Haha");
        ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);
        verify(mockedList).add(argument.capture());
        assertEquals("Haha", argument.getValue());

        /**
         * ArgumentCaptor与自定义的参数匹配器相关
         * 这两种技术都能用于检测外出传递到Mock对象的参数
         * ArgumentCaptor更适合以下情况:
         * 1.自定义不能被重用的参数匹配器
         * 2.仅需要断言参数值
         */
    }
}
