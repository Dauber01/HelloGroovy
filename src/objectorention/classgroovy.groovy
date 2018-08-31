package objectorention

/**
 * to do
 * @author Lucifer
 * @date $ ( DATE )
 */
def person = new Persion(name:'lilei', age:18)
//在groovy中,所有的class都继承了groovyobject,该类中对很多方法进行了封装,包括属性的get set方法
println "the name is ${person.name}, and the age is ${person.age}"  //groovy在对象获取属性用.的方式的时候底层实际是用了get和set方法
person.addAge(10)