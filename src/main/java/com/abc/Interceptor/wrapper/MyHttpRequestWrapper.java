package com.abc.Interceptor.wrapper;

import com.abc.Interceptor.filter.MyHttpFilter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * <p>自定义HttpServletRequestWrapper</p>
 * <p>功能</p>
 * <p>在{@link MyHttpFilter}类中使用此类，使得HTTP请求数据可通过此类获取到</p>
 * Created by liujinwen on 2018-08-02
 */
public class MyHttpRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    /**
     * 构造函数，在构造对象时，将inputStream数据缓存到body参数中
     * @param request
     * @throws IOException
     */
    public MyHttpRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = readBytes(request.getInputStream());
    }

    /**
     * 重写getReader方法，从{@code ByteArrayInputStream}中读取数据
     * @return
     */
    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * 重写getInputStream方法，从{@code ByteArrayInputStream}中读取数据
     * @return
     */
    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() {
                return bais.read();
            }
        };
    }

    /**
     * 获取{@code InputSteam}中的所有数据
     * @param in
     * @return
     * @throws IOException
     */
    private byte[] readBytes(InputStream in) throws IOException{
        byte[] byteBuff = new byte[2048];
        byte[] byteResult = new byte[0];

        int len;
        while ((len = in.read(byteBuff)) != -1) {
            byte[] joinedArray = new byte[byteResult.length + len];
            System.arraycopy(byteResult, 0, joinedArray, 0, byteResult.length);
            System.arraycopy(byteBuff, 0, joinedArray, byteResult.length, len);
            byteResult = joinedArray;
        }
        return byteResult;
    }

    public byte[] getBody() {
        return body;
    }
}
