package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import loader.CommonMain;
import loader.IHttpLoader;

/**
 *
 * 创建人  liangsong
 * 创建时间 2019/11/15 10:53
 */
public class HttpLoader implements IHttpLoader {
    private static final Logger logger = LoggerFactory.getLogger(HttpLoader.class);
    public static void main(String[] args) {
        new CommonMain();
    }

    public HttpLoader() {
        for(int i = 0; i < 100000000; i++) {
            new File("");
        }
    }

    public String getData(String url) {
        logger.debug("getData url:{}", url);


        return "Hello I am from " + "LoaderApplication -" + url;
    }
}
