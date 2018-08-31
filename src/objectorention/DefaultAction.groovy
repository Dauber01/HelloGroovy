package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
trait DefaultAction {

    //trait符合java的适配器模式,trait相当于java的abstract class,中间可以有实现的方法,没有方法体的方法要加abstract修饰

    def say(){
        println 'hello world'
    }

    abstract def doaction()

}