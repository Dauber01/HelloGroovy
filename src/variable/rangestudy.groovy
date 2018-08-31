package variable


/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
def range = 1..10
println range[0]    //通过下标获取range中对应的值
println range.contains(3)
println range.getClass()    //rang的类型为IntRange,rang类继承list类,所以大多的操作方法基本和list一致
Range range1 = 1..10
println range.from
println range.to

//range的遍历,在groovy中,应该尽量使用用闭包实现的方法,所以该使用each的遍历方法
range.each {
    println it
}
for (i in range){
    println i
}
//range在switch中的使用
def result = rangeswitch(78)
println result
def rangeswitch(Number number){
    def result
    switch (number){
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
    }
    return result
}