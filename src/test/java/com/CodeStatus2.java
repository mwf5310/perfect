package com;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CodeStatus2 {
    @BeforeClass
    public static void setup() {
        useRelaxedHTTPSValidation();//宽松的校验，信任所有https，降低安全机制
        RestAssured.baseURI = "https://testhome.com";
        //  RestAssured.proxy("127.0.0.1",8080);
    }

    @Test
    public void testAssert() {
        //given().queryParam(parameterName:"q",...parameterValues:"appium")
        given().queryParam("q", "appium")

                .when().get("https://testerhome.com/search").prettyPeek()
                .then()
                .statusCode(200)
                .body("html.head.title", equalTo("appium · 搜索结果 · TesterHome"))
        ;
    }

    @Test
    public void testAssert2() {
        given().when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                .then()
                .statusCode(200).body("topics.title", hasItem("优质招聘汇总"));
    }

    @Test
    public void testerhomeJsonSingle() {
        given().when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                .then()
                .statusCode(200)
                // .body("topic.title",equalTo("优质招聘汇总"))
                .body("topics.title", hasItems("优质招聘汇总"))
                .body("topics.title[1]", equalTo("第四届移动互联网测试开发大会门票转让汇总贴"))
                // .body("topics.id[-1]", equalTo(14691))
                .body("topics.findAll{topics ->topics.id==10254}.title", hasItems("优质招聘汇总"))
                .body("topics.find{topics ->topics.id==10254}.title", equalTo("优质招聘汇总"))


        ;
    }
}

               /*
               <shopping>
 <category type="groceries">
 <item>
 <name>Chocolate</name>
 <price>10</price>
 </item>
 <item>
 <name>Coffee</name>
 <price>20</price>
 </item>
 </category>
 <category type="supplies">
 <item>
 <name>Paper</name>
 <price>5</price>
 </item>
 <item quantity="4">
 <name>Pens</name>
 <price>15</price>
 </item>
 </category>
 <category type="present">
 <item when="Aug 10">
 <name>Kathryn's Birthday</name>
 <price>200</price>
 </item>
 </category>
 </shopping>

                */
/*
        @Test
        public void testXML () {
            //given().when().get("http://127.0.0.1:8000" / hogwarts.xml).prettyPeek()
                 //   .then()
                    .statusCode(200)
                    .body("shopping.category.item.name[2]", equalTo("paper"))
                    .body("shopping.category[1].item.name[1]", equalTo("pens"))
                    .body("shopping.category.size()", equalTo(3))//多少个类
                    .body("shopping.category.item.name[2]", equalTo("paper"))
                    .body("shopping.category.find{it.@type=='present'}.item.name", equalTo(""))
                    .body("shopping.category.find{it.@type=='present'}.item.name", equalTo(""))
                    .body("**.find{it.price==200}.name", equalTo(""))//xml 语法

            ;
            //1.extract().response()
            //1System.out.println(response.statusLine());
            //2.extract().path("shopping.category.item.name[2]")
            //System.out.println(name)
        }


    }


    ;
}

*/







