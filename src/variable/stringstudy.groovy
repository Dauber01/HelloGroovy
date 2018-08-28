package variable

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
//''的String和java中的性质和用法完全相似，类型也为java.lang.string类型
def s_1 = 'hello\'a\' word !'
println s_1.class

//''''''类型的string用来format格式，类型也为java.lang.string类型
def s_2 = '''\
line one 
line two
line three'''
println s_2
println s_2.class

//""的String类型在没有${}注入的时候和java的string类型完全相似，但注入${}表达式之后类型变为org.codehaus.groovy.runtime.GStringImpl
def s_4 = "hello word !"
println s_4.class
//org.codehaus.groovy.runtime.GStringImpl可以引入变量
def s_3 = "like ${s_4}";
println s_3.class

//org.codehaus.groovy.runtime.GStringImpl可以引表达式
def s_5 = "1 + 2 = ${1 + 2}"
println s_5
println s_5.class

def result = echo(s_5)
//在转变过后的类型转为返回的参数
println result.class
println result

//在实际的使用中org.codehaus.groovy.runtime.GStringImpl和java.lang.String可以进行相互转换
String echo(String s){
    return s;
}