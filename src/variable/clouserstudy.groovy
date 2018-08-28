package variable

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */

def clouser = {
    String name, int age ->
        //println "Hello ${name} , your age is ${age}!"
        //闭包有默认得返回值为null,如果无return声明，则值null
        return 'success'
}

//用call得形式进行调用
//clouser.call('Groovy')
//用方法得形式进行调用
def result = clouser('Groovy', 18)
//println "the result is : ${result}"

//通过upto计算number以内数字的阶乘
int fab(int number) {
    int result = 1;
    1.upto(number, { num -> result *= num })
    return result
}
//通过downto方法
int fab2(int number){
    int result = 1;
    number.downto(1){ num -> result *= num }
    return result
}
//通过times方法完成number以内数字的累加
int fab3(int number){
    int result = 0;
    number.times { num -> result += num}
    return result
}

int f_1 = fab(5)
//println f_1
int f_2 = fab2(5)
//println f_2
int f_3 = fab3(101)
//println f_3

//字符串的闭包用法
String str = "2 and 3 is 5";
println str.each {
    //s ->
        //print s.multiply(2)
}
//通过find方法查找字符串中的第一个数字
println str.find {s -> s.isNumber()}
//通过findall方法查找字符串中的所有数字
println str.findAll {s -> s.isNumber()}
//通过any方法验证str中是否存在数字
println str.any {s -> s.isNumber()}
//通过every方法验证str中是否全是数字
println str.every {s -> s.isNumber()}
//通过collect方法收集符合要求的成员
def list = str.collect {s -> s.toUpperCase()}
println list.asList().toListString()