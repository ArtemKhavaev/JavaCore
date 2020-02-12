package com.domain.lesson20Annotation;

/*
@ClassInfo
public class AnnotationLesson {
    private String string;
    public AnnotationLession(@ParamsInfo String string){
        this.string = string;
    }

    @MethodInfo(author = "itmo", version = 2)
    public void someVoid(){
        System.out.println("Some Void");

    }

    @Override
    @MethodInfo(author = "obj")

    @Override
    public String toString() {
        return "anotationLesson{" +
                "string='" + string + '\'' +
                '}';
    }

    public static void main(String[]args){
        AnnotationLesson lesson = new AnnotationLesson("Lesson");
        Method[]methods = lesson.getClass().getDeclaredMethods();
        for(Method method:methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));
            method.isAnnotationPresent(MethodInfo.class);

            Annotation[] info = method.getDeclaredAnnotations(MethodInfo.class);
            if (info != null){
                System.out.println(info.author());
                System.out.println(info.version());
            }
        }

    }
}
class SomeClass{
    // аннотация для полей класса
    private String name;
    private Some some;
    private int data;

}

//написать рефлективный static toString();
// название some : значение
// название data : значение

// вывести те поля, которые не помечены аннотацией
*/
