package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
class Entry {

    static void main(def args){
        println "初始话开始..."
        ApplicationManager.init()
        println "初始话结束..."
        def person = PersionManager.getPersion()
        println "the person name is ${person.name}, the age is ${person.age}"
    }

}
