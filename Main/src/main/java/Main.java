import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import loader.IHttpLoader;

/**
 *
 * 创建人  liangsong
 * 创建时间 2019/11/15 11:22
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        logger.debug("start with me ");
        new Main();
    }
    private HashMap<String,IHttpLoader> loaderHashMap = new HashMap<String, IHttpLoader>();//缓存HttpLoader实例
    public Main() {
        testJarAll();
    }

    private void testJarAll()
              {


        for(int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            for (JarEnum jarEnum : JarEnum.values()) {
                try {
                    testJar(jarEnum.path, jarEnum.className,jarEnum.url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            logger.debug("testJarAll System.currentTimeMillis.-start:{}", System.currentTimeMillis()-start);
        }




    }

    private void testJar(String jarShortDir, String classFullName, String url)
            throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        logger.debug("testJar ================= START jarShortDir:{},classFullName:{}", jarShortDir,classFullName);
        IHttpLoader httpLoader = getHttpLoader(jarShortDir,classFullName);
        String data = httpLoader.getData(url);
        logger.debug("testJar jar包返回数据 :{}", data);
        logger.debug("testJar =================   END jarShortDir:{},classFullName:{}", jarShortDir,classFullName);
    }

    private IHttpLoader getHttpLoader(String jarShortDir, String classFullName)
            throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String key = jarShortDir + "-" + classFullName;
        if (loaderHashMap.containsKey(key)) {
            return loaderHashMap.get(key);
        }
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/" + jarShortDir);
        logger.debug("getHttpLoader file.exists:{}", file.exists());
        URL url = new URL("file:" + file.getPath());

        logger.debug("getHttpLoader url:{}", url);
        URL[] urls = new URL[]{url};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        Class<?> mainClass = urlClassLoader.loadClass(classFullName);
        IHttpLoader httpLoader = (IHttpLoader) mainClass.newInstance();
        loaderHashMap.put(key,httpLoader);
        return httpLoader;
    }

}
