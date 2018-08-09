package com.abc.Interceptor.wrapper;

import com.abc.Interceptor.filter.MyHttpFilter;
import org.apache.commons.io.output.TeeOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * <p>自定义HttpServletResponseWrapper</p>
 * <p>功能</p>
 * <p>在{@link MyHttpFilter}类中使用此类，使得HTTP响应数据可通过此类获取到</p>
 * Created by liujinwen on 2018-08-02
 */
public class MyHttpResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream output;
    private ServletOutputStream filterOutput;

    public MyHttpResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new ByteArrayOutputStream();
    }

    /**
     * 利用TeeOutputStream复制流，解决多次读写问题
     * @return
     * @throws IOException
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (filterOutput == null) {
            filterOutput = new ServletOutputStream() {
                //替换构造方法
                //拿父类的response，初始化的时候，里面还没有数据，只有一些request信息和response信息,但是调用了创建outputStream,
                //private TeeOutputStream teeOutputStream = new TeeOutputStream(bufferOutputStream,output);
                private TeeOutputStream teeOutputStream = new TeeOutputStream(MyHttpResponseWrapper.super.getOutputStream(), output);

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {

                }

                @Override
                public void write(int b) throws IOException {
                    teeOutputStream.write(b);
                }
            };
        }
        return filterOutput;
    }

    public byte[] getBody() {
        return output.toByteArray();
    }
}
