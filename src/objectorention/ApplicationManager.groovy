package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
class ApplicationManager {

    static def init(){
        ExpandoMetaClass.enableGlobally()
        //给第三方接口类增加自定义静态方法
        Persion.metaClass.static.create = {def name, def age ->
            new Persion(name: name, age: age)
        }
    }

}
