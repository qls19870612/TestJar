package test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loader.IHttpLoader;

/**
 *
 * 创建人  liangsong
 * 创建时间 2019/11/15 15:56
 */
public class HttpLoader implements IHttpLoader {

    private static final Logger logger = LoggerFactory.getLogger(HttpLoader.class);
    public String getData(String url) {
        logger.debug("getData url:{}", url);
        return "Hello I am from " + "LoaderApplication2 -" + url;
    }
}
