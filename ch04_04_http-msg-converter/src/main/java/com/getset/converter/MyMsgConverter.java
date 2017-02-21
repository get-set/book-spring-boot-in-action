package com.getset.converter;

import com.getset.converter.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 自定义HttpMessageConverter。
 * Created by Kang on 2017/2/21.
 */
public class MyMsgConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMsgConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        System.out.println("readInternal---" + tempArr);
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    @Override
    protected void writeInternal(DemoObj o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello: " + o.getId() + "++++" + o.getName();
        System.out.println("writeInternal---" + o.getName());
        httpOutputMessage.getBody().write(out.getBytes());

    }
}
