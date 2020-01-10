package com.reed.myContext.core;

import com.reed.myContext.Anno.AnnoAutowire;
import com.reed.myContext.Anno.AnnoService;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Context {
    private LinkedHashMap<String ,Object> map = new LinkedHashMap<>();

    public LinkedHashMap getMap(){
        return map;
    }


    public <T> void setBean(String key,T value){
        map.put(key,value);
    }

    public Object getBean(String key){
        return  map.get(key);
    }

    public void initContext(String path) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        List<Class> classes = getClazzFromPath(path);
        for (Class clazz:classes) {
            if(getBean(clazz.getSimpleName())==null){
                objInit(clazz);
            }
        }
        for (Class clazz:classes) {
            fieldInit(clazz);
        }
    }

    private void fieldInit(Class clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(AnnoAutowire.class)){
                Object bean = getBean(clazz.getSimpleName());
                Object value = getBean(field.getType().getSimpleName());
                if(bean!=null&&value!=null)
                field.set(bean,value);
            }
        }
    }

    private void objInit(Class clazz) throws InstantiationException, IllegalAccessException {
        Object o = null;
        if(clazz.isAnnotationPresent(AnnoService.class)){
            o = clazz.newInstance();
            setBean(clazz.getSimpleName(),o);
        }
    }



    /**
     *
     * @param path example:com.reed.myContext.core.Context
     * @return
     */
    private List<Class> getClazzFromPath(String path) throws ClassNotFoundException {
        path = path.replace(".","/");//  com/reed/myContext/core/Context
        ClassLoader classLoader = this.getClass().getClassLoader();
        String resource = classLoader.getResource(path).getPath();
        File[] files = new File(resource).listFiles();
        List<Class> classes = new ArrayList<>();
        getFiles(files,classes,path);
        return classes;
    }

    private void getFiles(File[] files,List list,String path) throws ClassNotFoundException {
        for (File file:files){
            if(file.isDirectory()){
                getFiles(file.listFiles(),list,path);
            }else{
                String absolutePath = file.getAbsolutePath().replace("\\","/");
                if(absolutePath.endsWith(".class")){
                    String substring = absolutePath.substring(absolutePath.indexOf(path))
                            .replace(".class","")
                            .replace("/",".");
                    list.add(this.getClass().getClassLoader().loadClass(substring));
                }
            }
        }
    }
}
