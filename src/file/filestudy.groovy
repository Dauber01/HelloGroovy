package file

import objectorention.Persion;/**
 * @do ${DESCRIPTION}
 * @author Lucifer
 * @date 2018/08/31 15:32
 */
//groovy可以使用所有关于java的文件处理方式
def file = new File("../../Hello Groovy.iml")
/*file.eachLine {line ->        //提供了更简便的行遍历方法
    println line
}*/
//println file.getText()        //通过getText方法获取整个文件中的内容
def list = file.readLines()     //获取所有行的list,适合需要对每行进行操作的业务场景
/*list.each { line ->
    println line
}*/
/*
def bytes = file.withReader {reader ->      //闭包中的reader对象为java中的reader对象,操作起来更加灵活方便
    char [] bytes = new char[100]
    reader.read(bytes)
    return bytes
}
println bytes*/
/*def result = copymethod("../../Hello Groovy.iml", "../../Hello Groovy3.iml")
println result*/
def copymethod(String fromfile, String tofile){
    try{
        def tofi = new File(tofile)
        if (!tofi.exists()){
            tofi.createNewFile()
        }
        def from = new File(fromfile)
        from.withReader {reader ->
            def lines = reader.readLines()
            tofi.withWriter {writer ->      //获取writer的方法和获取reader的方法一致
                lines.each {line ->
                    writer.append(line + "\r\n")
                }
            }
        }
        return true
    }catch (Exception e){
        e.printStackTrace()
    }
}
def person = new Persion(name: 'lilei', age: 18)
//def result = obejectsave(person, "../../person.bin")
def result = (Persion)readobject("../../person.bin")
println result
println "the person name is ${result.name}, the age is ${result.age}"

def obejectsave(Object o, String filepath){
    try{
        def file = new File(filepath)
        if (!file.exists()){
            file.createNewFile()
        }
        file.withObjectOutputStream { out ->
            out.writeObject(o)
        }
        return true
    }catch (Exception e){
        e.printStackTrace()
    }
    return false
}

def readobject(String filepath){
    def o = null
    try{
        def file = new File(filepath)
        file.withObjectInputStream { input ->
            o = input.readObject()
        }
    }catch (Exception e){
    }
    return o
}