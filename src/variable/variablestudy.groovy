package variable

/**
 * to do study test
 * @author Lucifer
 * @date $ ( DATE )
 */

//groovy可以定义为基本类型
int x = 10;
//实际操作中基本类型会被转为包装类型，进行自动装箱
//println x.class

//同上
double y = 3.14
//println y.class

def x_1 = 10
//println x_1.class
def x_2 = 3.1415926
//println x_2.class
def x_3 = 'String'
//def变量的类型会根据赋值的类型进行逆推
//println x_3.class
x_1 = x_3
//println x_1.class

def str = "groovy"
//将String作为中心，传入固定的长度，填充对应的字符，如果为单数的话，右边填充的长度比左边的长度多1
//println str.center(9, 'a')
//println str.padLeft(10, 'a')
def str1 = "roovy"
//java自带的对比，为0是表示相等
println str.compareTo(str1)
//groovy中特定的操作符，对比字符串的unicode值
println str == str1
println str > str1
//直接操作从字符串中减去固定的字符
//println str.minus(str1)
println str - str1
//groovy通过特定的符号直接提取字符
println str[0]
println str[0..1]
println str.reverse()   //将字符串的内容进行倒序
println str.capitalize()    //将首字母大写
println str.isNumber()  // 是否为数字