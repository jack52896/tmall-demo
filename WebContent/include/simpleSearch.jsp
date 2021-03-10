<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="simpleSearchOutDiv">
    <a href="${contextPath}">
        <img id="simpleLogo" class="simpleLogo" src="img/site/simpleLogo.png">   
    </a>
     
    <form action="foresearch" method="post" >
    <div class="simpleSearchDiv pull-right">
        <input id = "keyword" name="param.keyword" type="text"  placeholder="时尚男鞋  太阳镜 ">
        <button class="searchButton" type="submit">搜天猫</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count>=8 and st.count<=11}">
                    <span>
                        <a href="forecategory?category.id=${c.id}">
                            ${c.name}
                        </a>
                        <c:if test="${st.count!=11}">            
                            <span>|</span>             
                        </c:if>
                    </span>          
                </c:if>
            </c:forEach>         
        </div>
    </div>
    </form>
    <div style="clear:both"></div>
</div>