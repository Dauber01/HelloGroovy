package variable

import java.util.stream.Collectors

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */

//def list = new ArrayList()  //java中定义list的方式
def list = [1, 2, 3, 4, 5]  //groovy中list的定义方式
//println list.class
//println list.size()
//def args = [1, 2, 3, 4, 5] as int[]   //groovy中数组的定义方式
//println args.class
//int[] arg = [1, 2, 3, 4, 5]   //groovy中数组的定义方式
//println arg.class
//为list添加元素
list.add(6)
list.leftShift(7)
list << 8
println list.toListString()
//def lagelist = list + 9
//println lagelist.toListString()
//为list删除元素
list.remove((Object)7)
//println list.toListString()
list.remove(6)
//println list.toListString()
list.removeAt(5)
//println list.toListString()
list.removeElement(4)
//println list.toListString()
list.removeAll {it -> it % 2 == 0}
//println list.toListString()
//println list - [1, 3]
//println list.toListString()
//对list进行排序
def sortList = [1, -3, 5, 6, -7, 9]
//Comparator comparator = {a, b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : -1} //java方式实现排序
//Collections.sort(sortList, comparator)    //java方式实现自定义排序
//sortList.sort()
sortList.sort {a, b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : -1}
//println sortList
def stringList = ['a', 'b', 'groovy', 'java', 'ok']
stringList.sort {it -> it.size()}
//println stringList
int k = sortList.find {return it % 2 == 0}
//println k
def klist = sortList.findAll{return it % 2 != 0}
//println klist.toListString()
//println sortList.any{return it % 2== 0}
//println sortList.every{return it % 2 ==0}
println sortList.min{return Math.abs(it)}
println sortList.max{return Math.abs(it)}
int count = sortList.count{return it % 2 == 0}
println count
