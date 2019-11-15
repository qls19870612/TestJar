/**
 *
 * 创建人  liangsong
 * 创建时间 2019/11/15 16:07
 */
public enum  JarEnum {
    LoaderApplication(1,"LoaderApplication/target/LoaderApplication-1.0-SNAPSHOT.jar","test.HttpLoader","https://www.baidu.com"),

    LoaderApplication2(2,"LoaderApplication2/target/LoaderApplication2-1.0-SNAPSHOT.jar","test2.HttpLoader","https://www.qq.com"),


    ;

    public final String path;
    public final String className;
    public final String url;
    public final int id;

    JarEnum(int id,String path,String className,String url) {
        this.id = id;
        this.path = path;
        this.className = className;
        this.url = url;

    }
}
