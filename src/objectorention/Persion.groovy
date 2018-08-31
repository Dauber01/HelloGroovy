package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
/**
 * groovy中的所有的类,接口,属性,方法默认都是public的
 */
class Persion/* implements DefaultAction*/ /*Action*/ implements Serializable{

    String name

    Integer age

    def addAge(int year){
        println age + year
    }

    @Override   //在类中,metaClass和methodMissing都缺失的时候会直接调用invokeMethod
    Object invokeMethod(String name, Object args) {
        return "the method is ${name}, the args is ${args}"
    }

    def methodMissing(String name, Object args){    //在类中,metaClass缺失的时候会查找并调用methodMissing
        return "the method ${name} is missing"
    }
/* @Override
    def doaction() {
        return null
    }*/

}
