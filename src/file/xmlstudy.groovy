package file

import groovy.xml.MarkupBuilder;
/**
 * @do ${DESCRIPTION}
 * @author Lucifer
 * @date 2018/08/31 10:40
 */
final String xml = '''
<response version-api="2.0">
    <value>
        <books id="1" classification="android">
            <book available="20" id="1">
                <title>疯狂Android讲义</title>
                <author id="1">李刚</author>
            </book>
            <book available="14" id="2">
                <title>第一行代码</title>
                <author id="2">郭林</author>
            </book>
            <book available="13" id="3">
                <title>Android开发艺术探索</title>
                <author id="3">任玉刚</author>
            </book>
        </books>
    </value>
</response>'''

def xmlslurper = new XmlSlurper()
def response = xmlslurper.parseText(xml)
//println response.value.books.book[0].title.text()     //通过属性.text()的方式获取节点内的值
//println response.value.books.book[0].@id      //通过@属性的值获取节点标签中的值
def list = []
response.value.books.book.each{book ->      //each的下层的成为list的节点
    if (book.author.text() == '李刚'){
        list << book.title.text()
    }
}
//println list.toListString()
//深度遍历
def titles = response.depthFirst().findAll {book ->     //用来接收的变量名字必须为要接收的属性名+s,否则会报错 .depthFirst也可以用.'**'.代替,表示深度遍历,但不容易简明知意,不推荐使用
    return book.author.text() == '李刚'/* ? true : false*/
}
//println titles
//广度遍历
def title = response.value.books.children().findAll{node ->     //广度遍历,children可以用.'*'.代替，便是广度遍历但是同样不推荐
    node.name() == 'book' && node.@id == '2'        //该行的node.names是需要加()的,代表节点的名字
}.collect{note ->
    return note.title.text()
}
//println title


/*
       生成xml格式数据
<langs type='current' count='3' mainstream='true'>
<language flavor='static' version='1.5'>java</language>
	<language flavor='dynamic' version='1.6.0'>Groovy</language>
<language flavor='dynamic' version='1.9'>javaScript</language>
<langs>*/
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)
//通过MarkupBuilder静态的创建xml文件
//通过指定的根节点进行创建
/*xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true'){
    //创建对应的子节点,如果下面还有节点,则继续使用闭包声明
    language(flavor:'static', version:'1.5', 'java')
    language(flavor:'dynamic', version:'1.6.0', 'Groovy')
    language(flavor:'dynamic', version:'1.9', 'javaScript')
}*/
//println sw

//通过MarkupBuilder基于class动态的创建xml文件
def lang = new Langs()
xmlBuilder.langs(type: lang.type, count: lang.count, mainstream: lang.mainstream){
    lang.language.each { langu ->
        language(flavor:langu.flavor, version:langu.version, langu.value)
    }
}
println sw

class Langs{
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def language = [new Language(flavor: 'static', version: 1.5, value: 'java'),
                    new Language(flavor: 'dynamic', version: 1.6, value: 'Groovy'),
                    new Language(flavor: 'dynamic', version: 1.9, value: 'javaScript'),]
}

class Language{
    String flavor
    String version
    String value
}