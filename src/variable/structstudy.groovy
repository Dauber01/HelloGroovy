package variable

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
def param = 1.23
def result
switch (param){
    case 'case':    //当值为case的时候
        result = 'case'
        break
    case 'food':
        result = 'food'
        break
    case [1.23, '2', 'kiss', 'like']:
        result = 'list'
        break
    case Integer:
        result = 'Integer'
        break
    case BigDecimal:
        result = 'bigDecimal'
        break
    default:
        result = 'default'
        break
}
println result

//for循环的新用法
def number = 0
//对range进行遍历循环
for (i in 0..9){
    number += i
}
println number
number = 0
//对list进行循环
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 9]){
    number += i
}
println number
number = 0
//对map进行循环
for (i in ['xiaoming':1, 'xiaoli':2, 'hanmeimie':3]){
    number += i.value
}
println number
