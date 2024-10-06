<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <form action="${pageContext.request.contextPath }/admin/category/insert" 
 	method ="post" enctype="multipart/form-data">
  <label for="categoryname">Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="images">Images:</label><br>
  <div style="width: 100px; height: 100px">
  <img  id="imagess" src="" width="150px" height="150px">
  </div><br>
  Nhập link : <innput type="text" id="images1" name ="images1"><br>
  Hoặc tải file :
  <input type="file" onchange="chosseFile(this)" id="images" name="images"><br>
  <label for="status">Status:</label><br>
  <input type="statuson" type="radio"  name="status" value="1">
  <label for="statuson"> Hoạt động </label>
  <input id= "statusoff" type="radio"  name="status" value="0">
  <label for="statusoff"> Khoá </label> <br>
   <input type="submit" value="Insert">
</form>