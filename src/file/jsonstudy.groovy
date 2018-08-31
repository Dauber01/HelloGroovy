package file

import com.google.gson.Gson
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Persion

/**
 * to do
 * @author Lucifer
 * @date 2018/8/31
 */
def list = [new Persion(name: 'xixi', age: 18),
            new Persion(name: 'haha', age: 28)]
def json = JsonOutput.toJson(list)      //groovy中提供的bean转json方法
println JsonOutput.prettyPrint(json)    //groovy中json类型的格式化打印

def jsonp = new JsonSlurper()
//jsonp.parse()

//Gson        //groovy在引入gson的jar包之后可以直接使用Gson的相关方法

def response = getNetWorkData("http://localhost:8080/")
//println JsonOutput.prettyPrint(response)      //该方法只能格式化的打印json格式的数据
println response.seed       //.parseText的方法可以将String类型的直接转化为Object类型而无需创建实体类,并且可以直接调用其属性

def getNetWorkData(String url){
    def collection = new URL(url).openConnection()      //groovy并没有封装自己的网络请求,而是使用jdk默认的网络请求
    collection.setRequestMethod('GET')
    collection.connect()
    def response = collection.content.text
    println response
    def jsonSup = new JsonSlurper()
    return jsonSup.parseText(response)
}