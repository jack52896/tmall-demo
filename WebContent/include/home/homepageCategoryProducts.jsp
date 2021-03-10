<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="homepageCategoryProducts">
    <c:forEach items="${categorys}" var="c" varStatus="stc">
        
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">${c.name}</span>
                <br>
                <c:forEach items="${c.products}" var="p" varStatus="st">
                 
                        <div class="productItem" >
                            <a href="foreproduct?product.id=${p.id}"><img width="100px" src="./img/productSingle_middle/${p.firstProductImage.id}.jpg"></a>
                            <a class="productItemDescLink" href="foreproduct?product.id=${p.id}">
                                <span class="productItemDesc">[热销]
                                ${fn:substring(p.name, 0, 20)}
                                </span>
                            </a>
                            <span class="productPrice">
                                <fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
                            </span>
                        </div>
                          
                </c:forEach>
                <div style="clear:both"></div>
            </div>
       
    </c:forEach>
     
    <img id="endpng" class="endpng" src="./img/site/end.png">
 
</div>