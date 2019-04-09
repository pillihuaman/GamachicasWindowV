<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
  <div class="container">
      <form:form method = "POST" action = "/gamachicas.com.pe/PostImg">
  <fieldset>
    <div id="legend">
      <legend class="">Registrar Informacion de la imagen</legend>
    </div>
    <div class="alert alert-warning" role="alert">
 Solo se puede registrar de 1 a 4 imagenes de un solo producto que representan las vistas de !
 Principal ,atras,Lateral, frontal.
</div>
    
    <div class="control-group">
      <label class="control-label">Posición en la pagina principal</label>
      <div class="controls">
      <input type="number" name="Clothingline.idclothingline" min="1" max="9000" class="form-control">
      </div>
    </div>
    <br>

    <div class="control-group">
      <!-- Button -->
      <div class="controls">
      <input type="submit" class="btn btn-success" value="Registrar">
      
      </div>
    </div>
  </fieldset>
      </form:form>
            </div>

</body>
</html>