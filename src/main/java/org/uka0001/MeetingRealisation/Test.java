package org.uka0001.MeetingRealisation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //TypeReference <Integer> token = new TypeReference() {};
        System.out.println(populate(list));
    }

    static Map<Class<?>, Supplier<Object>> generator = new LinkedHashMap<>();
    static List<String> list = new ArrayList<>();
    //TypeReference <Map<String, Integer>> typeReference = new TypeReference<Map<String, Integer>>();


    static {
        generator.put(Integer.class, () -> 1);
        generator.put(Boolean.class, () -> true);
        generator.put(String.class, () -> "Hello");
    }

    private static <T> Object populate(ArrayList<String> x) {
        if (isSimpleType(x)) {
            return generator.get(x).get();
        } else {
            if (isCollection(x.getClass())) {
                if (List.class.isAssignableFrom(x.getClass())) {

                }
            } else {
                //TODO cought Class
            }

        }
        return null;
    }

    private static boolean isCollection(Class<?> x) {
        return List.class.isAssignableFrom(x) || Map.class.isAssignableFrom(x);
    }

    private static boolean isSimpleType(Object x) {
        return generator.containsKey(x);
    }

    private <T> Type[] nestedTypes(Type typeRef) {
        return typeRef instanceof ParameterizedType ?
                ((ParameterizedType) typeRef)
                        .getActualTypeArguments() : new Type[]{typeRef};

    }
}
