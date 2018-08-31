package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
//在脚本中的metaClass注入的实行方法都只在该脚本中生效,想在局生效要加
ExpandoMetaClass.enableGlobally()
def persion = new Persion(name: 'hanmeimei', age: 18)
//println persion.cry()
//用metaClass属性动态的设置属性,设定后的属性和正常属性一样 mateClass位于DefaultGroovyMethods中
Persion.metaClass.sex = 'male'
//def person = new Persion(name: 'hanmeimei', age: 18)
//println person.sex
//person.sex = 'female'
//println person.sex
//为类动态的添加方法
Persion.metaClass.updateSex = { -> sex.toUpperCase() }
//def person = new Persion(name: 'hanmeimei', age: 18)
//println person.updateSex()
//为类动态的添加static方法
Persion.metaClass.static.create = {def name, def age -> new Persion(name: name, age: age)}
def person = Persion.create('lilei', 33)
println "the name is ${person.name}, the age id ${person.age}"
