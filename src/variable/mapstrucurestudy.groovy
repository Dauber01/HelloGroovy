package variable

//def map = new HashMap() //java的map定义方法
def map = [name:'lilei', age:'18', sex:'f']
//println map
//println map.age
//println map['name']
//map.put() //java用来添加元素的方法仍然有效
map.gole = '60'
//删除元素的方法和java的方法一致，都是用remove方法
map.leftShift(sister:'hameimei')
map.map = [name: 'haha', age: 'heihei']
//println map
//println map.getClass()
//定义的时候如果想将map的类型定义为HashMap或其他类型也可以用as语句，或者直接声明强类型变量
def hashmap = [name: 'xixi', age: '36'] as Set
//println hashmap.getClass()
HashMap hashMap = [name: 'kk', sex: 'f']
//println hashMap.getClass()

//对map类型的相关操作
def students = [
        1: [number: '0001', name: 'Bob', score: 55, sex: 'male'],
        2: [number: '0002', name: 'Johnny', score: 62, sex: 'female'],
        3: [number: '0003', name: 'Claire', score: 73, sex: 'female'],
        4: [number: '0004', name: 'Amy', score: 66, sex: 'male']
]
//遍历
students.each { def student ->
    println "the key is ${student.key}, the value is ${student.value}"
}
//遍历,index属性在要第二位，因为传入的参数列表默认第一个是map的元素
students.eachWithIndex{ def student, int index ->
    println "the index is ${index}, the key is ${student.key}, the value is ${student.value}"
}
//遍历
students.eachWithIndex{ key, value, int index ->
    println "the index is ${index}, the key is ${key}, the value is ${value}"
}
//find
def stu = students.find {student -> return student.value.score >= 60}
println stu
def stumap = students.findAll {student -> return student.value.score >= 60}
println stumap.toMapString()
int count = students.count {student -> return student.value.score >= 60 && student.value.sex == 'male'}
println count
def stunames = students.findAll {student -> return student.value.score >= 60}.collect{student -> return student.value.name}
println stunames.toListString()
def colle = students.groupBy {student -> return student.value.score >= 60 ? '及格' : '不及格'}
println colle.toMapString()
def sort = students.sort {def student1, def student2 ->
    Number score1 = student1.value.score
    Number score2 = student2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? 1 : -1
}
println sort.toMapString()
//map.any方法和.every方法和list的操作一样

